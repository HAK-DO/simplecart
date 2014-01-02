<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>

<jsp:include page="includes/header.jsp" />

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td colspan="5"><bean:message bundle="administration" key="adminMessage.administrator.display"/><br></td>
    </tr>

    <!-- provide a link to add a new stake -->
    <tr>
        <td colspan="6"><links:manageAdministrator page="/ManageAdministrator" activity="enter"><bean:message bundle="administration" key="link.add"/> <bean:message bundle="administration" key="adminLink.administrator"/></links:manageAdministrator></td>
    </tr>

    <!-- spacer --><tr><td height="20"></td></tr>
    
    <tr>
        <td width="80"><img src="images/spc.gif" width="80" height="1" border="0"><br></td>
        <td width="80"><img src="images/spc.gif" width="80" height="1" border="0"><br></td>
        <td width="80"><img src="images/spc.gif" width="80" height="1" border="0"><br></td>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="150"><img src="images/spc.gif" width="150" height="1" border="0"><br></td>
        <td width="75"><img src="images/spc.gif" width="75" height="1" border="0"><br></td>
        <td width="75"><img src="images/spc.gif" width="75" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="80"><bean:message bundle="administration" key="promptParty.nameFirst"/></td>
        <td width="80"><bean:message bundle="administration" key="promptParty.nameLast"/></td>
        <td width="80"><bean:message bundle="administration" key="promptParty.username"/></td>
        <td width="100"><bean:message bundle="administration" key="promptParty.emailAddress"/></td>
        <td width="150"><bean:message bundle="administration" key="promptAddress.streetLine1"/></td>
        <td width="75"><bean:message bundle="administration" key="promptAddress.city"/></td>
        <td width="75"><bean:message bundle="administration" key="promptAddress.state"/></td>
        <td width="70"></td>
        <td width="70"></td>
    </tr>
    
    <logic:iterate id="administrator" name="administrators">
    <tr>
        <td align="left"><bean:write name="administrator" property="nameFirst" filter="true"/></td>
        <td align="left"><bean:write name="administrator" property="nameLast" filter="true"/></td>
        <td align="left"><bean:write name="administrator" property="username" filter="true"/></td>
        <td align="left"><a target="new" href="mailto:<bean:write name="administrator" property="emailAddress" filter="true"/>"><bean:write name="administrator" property="emailAddress" filter="true"/></a></td>
        <td align="left"><bean:write name="administrator" property="address.streetLine1" filter="true"/></td>
        <td align="left"><bean:write name="administrator" property="address.city" filter="true"/></td>
        <td align="left"><bean:write name="administrator" property="address.state" filter="true"/></td>
        <td align="left"><links:manageAdministrator page="/ManageAdministrator"><bean:message bundle="administration" key="link.edit"/></links:manageAdministrator></td>
        <td align="left"><links:manageAdministrator page="/ManageAdministrator" activity="delete"><bean:message bundle="administration" key="link.delete"/></links:manageAdministrator></td>
    </tr>
    </logic:iterate>

</table>

<jsp:include page="includes/footer.jsp" />
