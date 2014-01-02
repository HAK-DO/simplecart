<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="/includes/header.jsp" />

<html:errors/>

<div class="row">
	<div class="span12">
		<h2 class="page-header">
			<bean:message key="accountMessage.createAccount"/>
		</h2>
	</div>
</div>


   <html:form action="/PrepareOrder" focus="streetLine1" styleClass="form-horizontal" onsubmit="return validateAddressForm(this);">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label"><bean:message key="promptAddress.streetLine1"/></label>
    <div class="col-sm-10">
    	<html:text property="streetLine1" styleClass="form-control" size="15" />
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"><bean:message key="promptAddress.streetLine2"/></label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"><bean:message key="promptAddress.city"/></label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"><bean:message key="promptAddress.state"/></label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label"><bean:message key="promptAddress.postalCode"/></label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>  
<!--   <div class="form-group"> -->
<!--     <div class="col-sm-offset-2 col-sm-10"> -->
<!--       <div class="checkbox"> -->
<!--         <label> -->
<!--           <input type="checkbox"> Remember me -->
<!--         </label> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
       	<html:hidden property="activity" value="enterAddress"/>
        <html:submit property="Submit" value="Submit Address" styleClass="btn btn-default" />
      	<html:reset styleClass="btn btn-default" />
    </div>
  </div>
</html:form>		
<!-- <table> -->
<%--     <html:form action="/PrepareOrder" focus="streetLine1" onsubmit="return validateAddressForm(this);"> --%>

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
<%--             <html:hidden property="activity" value="enterAddress"/> --%>
<%--             <html:submit property="Submit" value="Submit Address"/> --%>
<!--         </td> -->
<!--         <td width="10"></td> -->
<%--         <td><html:reset/></td> --%>
<!--     </tr> -->
<%--     </html:form> --%>
<!-- </table> -->

<jsp:include page="/includes/footer.jsp" />
