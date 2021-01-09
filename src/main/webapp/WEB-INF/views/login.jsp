<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br>
<br>
<marquee onmouseover="stop()" onmouseout="start()">Pelase Enter The Phone Number And Password</marquee>


<br> <br>
<body style="background-color:powderblue;">

<c:if test="${message ne null}">
<c:out value="${message}"/>

</c:if>
<br>
<br>
<form action ="loginCustomer" method="post">

<table>
<tr>
<td>PhoneNunmber</td>
<td><input type="text" name="phoneNo">
</td>
<tr>
<td>Password</td>
<td><input type="password" name="password">
</td>
<tr>
<td colspan="3" align="center">
<input type="submit" value="Login"/>
</td>
</tr>
</table>
</form>
