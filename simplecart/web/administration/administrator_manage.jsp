<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="includes/header.jsp" />

<html:errors/>
<html:javascript formName="/PersistAdministrator" dynamicJavascript="true" staticJavascript="false"/>

<table cellpadding="0" cellspacing="0" border="0">

    <html:form action="/PersistAdministrator" focus="nameFirst" onsubmit="return validatePartyForm(this);">
    <tr>
        <td colspan="3"><bean:message bundle="administration" key="adminMessage.administrator.manage"/><br></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.nameFirst"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="nameFirst" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.nameLast"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="nameLast" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.emailAddress"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="emailAddress" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.username"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="username" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.password" /></td>
        <td width="10"></td>
        <td width="150"><html:password property="password" size="15" redisplay="false"/></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptParty.passwordConfirm"/></td>
        <td width="10"></td>
        <td width="150"><html:password property="passwordConfirm" size="15" redisplay="false"/></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptAddress.streetLine1"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="streetLine1" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptAddress.streetLine2"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="streetLine2" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptAddress.city"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="city" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptAddress.state"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="state" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptAddress.postalCode"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="postalCode" size="15" /></td>
    </tr>
    <tr>
        <td align="right">
            <logic:equal name="partyForm" property="activity" value="enter">
                <html:hidden property="activity" value="enter"/>
                <html:submit property="Submit" value="Submit"/>
            </logic:equal>
            <logic:equal name="partyForm" property="activity" value="edit">
                <html:hidden property="id" name="partyForm"/>
                <html:hidden property="activity" value="edit"/>
                <html:submit property="Submit" value="Submit"/>
            </logic:equal>
            <logic:equal name="partyForm" property="activity" value="delete">
                <html:hidden property="id" name="partyForm"/>
                <html:hidden property="activity" value="delete"/>
                <html:submit property="Submit" value="Delete"/>
            </logic:equal>
        </td>
        <td width="10"></td>
        <td><html:reset/></td>
    </tr>
    </html:form>

</table>

<jsp:include page="includes/footer.jsp" />
