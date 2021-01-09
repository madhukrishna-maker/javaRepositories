
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<br>
<br>
<form:form action="addCustomer" method="post"  modelAttribute="registerBean">

	
<table>
<tr>
	<td>phoneNo</td>
	<td><form:input path="phoneNo"/></td>
	<td><form:errors path="phoneNo"/></td>

</tr>
<tr>

	<td>Name</td>
	<td><form:input path="name"/></td>
	<td><form:errors path="name"/></td>

</tr>
<tr>

	<td>password(8 to 20)</td>
	<td><form:input path="password"/></td>
	<td><form:errors path="password"/></td>
</tr>
<tr>

	<td>planId></td>
	<td><form:select path="planId"/>
	<td>
       <form:select path="planId">
       <form:option value="">-------select----</form:option>
       <form:options items="${registerBean.plansList}" itemValue="planId" itemLabel="planId"/>
       </form:select>
       </td>	
	
	<td><form:errors path="planId"/></td>
	</tr>
	<tr>
	<td colspan="3" align="center">
	<input type="Submit" value="REGISTER">
	</td>
	</tr>
	</table>
	
	</form:form>
	
	
	
	
	
	
	
	
	