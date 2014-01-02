<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="/includes/header.jsp" />
<html:javascript formName="loginForm" dynamicJavascript="true" staticJavascript="false"/>
<html:javascript formName="/PersistCustomer" dynamicJavascript="true" staticJavascript="false"/>
<html:errors/>
<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="100"></td>
        <td width="10"></td>
        <td width="200"></td>
    </tr>
<div class="row">
	<div class="span12">
		<h2 class="page-header">
			My Account</
		</h2>
	</div>
</div>
<script type="text/javascript">
    function setValueToHiddenField(id)
    {
    	document.getElementsByName('activity').value= id;
    	alert(document.getElementsByName('activity').value);
        document.loginForm.submit();
    }
</script>
<section class="section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
	  				<div class="panel-body">
<!-- 					<form class="form-vertical" > -->
   					<html:form action="/ManageCustomer" focus="username"  styleClass="form-vertical" onsubmit="return validateLoginForm(this);">
						<h3>For returning customers</h3>
						<hr>
						<div class="form-group">
							<label>
								Email Address
							</label>
							<div class="controls">
<!-- 								<input class="form-control" type="text" placeholder="Email"> -->
								<html:text property="username" styleClass="form-control" size="15" maxlength="18"/>
							</div>
						</div>
						<div class="form-group">
							<a href="#" class="pull-right">Forget?</a>
							<label>
								Password
							</label>
							<div class="controls">
								<html:password property="password" styleClass="form-control" size="15" maxlength="18" redisplay="false"/>
<!-- 								<input class="form-control" type="password" placeholder="Password"> -->
							</div>
						</div>
						<div class="form-group">
						<button type="submit" class="btn btn-primary">
						  <i class="icon-user icon-white"></i> Login
						</button>
<html:button property="activity" onclick="setValueToHiddenField('signin')">
Sign in
</html:button>						
						<button type="button" class="btn btn-success">Sign in</button>
<%-- 						<html:submit property="Submit" value="Submit"/> --%>
							<html:hidden property="activity" value="login"/>
<!-- 							<button type="submit" class="btn btn-primary pull-right">Sign in</button> -->
							<div class="controls">
								<label class="checkbox">
									<input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</html:form>
					</div>
				</div>
			</div>
<!-- 			<div class="col-lg-6"> -->
<!-- 				<form class="form-vertical" > -->
<!-- 					<h3>For new customers</h3> -->
<!-- 					<hr> -->
<!-- 					<p class="lead"> -->
<!-- 						By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made. -->
<!-- 					</p> -->
<!-- 					<button class="btn btn-success"> -->
<!-- 						Create an account -->
<!-- 					</button> -->
<!-- 				</form> -->
<!-- 			</div> -->
		</div><!--end:.row-->
	</div><!--end:.container-->
</section><!--end:.section-->    
<%--     <html:form action="/ManageCustomer" focus="username" onsubmit="return validateLoginForm(this);"> --%>
<%--     <tr><td colspan="3"><h4><bean:message key="accountMessage.login"/></h4></td> --%>
<!--     <tr> -->
<%--         <td align="right" width="100"><bean:message key="promptParty.username"/></td> --%>
<!--         <td></td> -->
<%--         <td width="100"><html:text property="username" size="15" maxlength="18"/></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="100"><bean:message key="promptParty.password"/>:</td> --%>
<!--         <td></td> -->
<%--         <td width="100"><html:password property="password" size="15" maxlength="18" redisplay="false"/></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<!--         <td align="right"> -->
<%--             <html:submit property="Submit" value="Submit"/> --%>
<%--             <html:hidden property="activity" value="login"/> --%>
<!--         </td> -->
<!--         <td></td> -->
<%--         <td><html:reset/></td> --%>
<!--     </tr> -->
<%--     </html:form> --%>

<%--     <html:form action="/PersistCustomer" focus="nameFirst" onsubmit="return validatePartyForm(this);"> --%>
<%--     <tr><td colspan="3"><h4><bean:message key="accountMessage.createAccount"/></h4></td> --%>
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.nameFirst"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="nameFirst" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.nameLast"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="nameLast" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.emailAddress"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="emailAddress" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.username"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="username" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.password" /></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:password property="password" size="15" redisplay="false"/></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptParty.passwordConfirm"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:password property="passwordConfirm" size="15" redisplay="false"/></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptCustomer.phone"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="phone" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptCustomer.companyName"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="companyName" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptAddress.streetLine1"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="streetLine1" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptAddress.streetLine2"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="streetLine2" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptAddress.city"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="city" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptAddress.state"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="state" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td align="right" width="250"><bean:message key="promptAddress.postalCode"/></td> --%>
<!--         <td width="10"></td> -->
<%--         <td width="150"><html:text property="postalCode" size="15" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<!--         <td align="right"> -->
<%--             <html:hidden property="activity" value="enter"/> --%>
<%--             <html:submit property="Submit" value="Create Account"/> --%>
<!--         </td> -->
<!--         <td width="10"></td> -->
<%--         <td><html:reset/></td> --%>
<!--     </tr> -->
<%--     </html:form> --%>

</table>

<jsp:include page="/includes/footer.jsp" />
