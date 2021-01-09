package com.sathya.ui.controller;

import java.util.List;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sathya.ui.dto.Login;
import com.sathya.ui.dto.PlanDetailsDto;
import com.sathya.ui.entity.RegisterBean;

@Controller
public class UiController {
	
	private static final String password = null;
	private static String ALLPLANS_URL="http://localhost:5556/PlanDetails/allPlans";	
	private static String REGISTER_URL="http://localhost:5559/CustomerDetails/register";	
	private static String lOGINString_URL="http://localhost:5559/CustomerDetails/login";
	
	@Autowired
	private RestTemplate restTemplate;
	
    @GetMapping("/index")
	public String getIndexPage() {
	
		return "index1";
     }
    
		@GetMapping("/login")
		public String getLoginPage() {

			return "login";
		}
		
		@GetMapping("/register")
		public String getRegisterPage(Model model) {

			ParameterizedTypeReference<List<PlanDetailsDto>> typeRef= new ParameterizedTypeReference<List<PlanDetailsDto>>() {};
			ResponseEntity<List<PlanDetailsDto>> re= restTemplate.exchange(ALLPLANS_URL,HttpMethod.GET,null,typeRef);

			List<PlanDetailsDto> plansList=re.getBody();
			RegisterBean registerBean= new RegisterBean();
			registerBean.setPlansList(plansList);
			model.addAttribute("registerBean",registerBean);
			return "register";	

		}
		@PostMapping("/addCustomer")
		public String addCustomer(@Valid @ModelAttribute RegisterBean registerBean,BindingResult result,Model model) {
			if(result.hasErrors()) {

				ParameterizedTypeReference<List<PlanDetailsDto>> typeRef= new ParameterizedTypeReference<List<PlanDetailsDto>>() {};
				ResponseEntity<List<PlanDetailsDto>> re= restTemplate.exchange(ALLPLANS_URL,HttpMethod.GET,null,typeRef);

				List<PlanDetailsDto> plansList=re.getBody();
               //RegisterBean registerBean= new RegisterBean();
		 		registerBean.setPlansList(plansList);
			model.addAttribute("registerBean",registerBean);
				
				

				/*String message=restTemplate.postForObject(REGISTER_URL,registerBean,String.class);
				model.addAttribute("message",message);*/

				 return "register"; 
				
			}else
			{
				return "success";
			}

		}

		@PostMapping("/login")
		public String loginCustomer(@RequestParam Long phoneNo, Model model) {
			Login login= new Login();
			login.setPhoneNo(phoneNo);
			login.setPassword(password);

			boolean flag=restTemplate.postForObject(lOGINString_URL, login, boolean.class);
			if(flag==true) {
				return "Home";

			}
			else {
				model.addAttribute("message", "Bad Credential");
			}
			return "";

		}

	}
