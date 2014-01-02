<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>

<jsp:include page="includes/header.jsp" />

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td colspan="5"><bean:message bundle="administration" key="adminMessage.option.display"/><br></td>
    </tr>

    <!-- provide a link to add a new stake -->
    <tr>
        <td colspan="6"><links:manageOption page="/ManageOption" activity="enter"><bean:message bundle="administration" key="link.add"/> <bean:message bundle="administration" key="adminLink.option"/></links:manageOption></td>
    </tr>

    <!-- spacer --><tr><td height="20"></td></tr>
    
    <tr>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="200"><img src="images/spc.gif" width="200" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="100"><bean:message bundle="administration" key="promptCatalogItem.name"/></td>
        <td width="200"><bean:message bundle="administration" key="promptCatalogItem.description"/></td>
        <td width="70"></td>
        <td width="70"></td>
    </tr>
    
    <logic:iterate id="option" name="options">
    <tr>
        <td align="left" valign="top"><bean:write name="option" property="name" filter="true"/></td>
        <td align="left" valign="top"><bean:write name="option" property="description" filter="true"/></td>
        <td align="left" valign="top"><links:manageOption page="/ManageOption"><bean:message bundle="administration" key="link.edit"/></links:manageOption></td>
        <td align="left" valign="top"><links:manageOption page="/ManageOption" activity="delete"><bean:message bundle="administration" key="link.delete"/></links:manageOption></td>
    </tr>
    </logic:iterate>

</table>

<jsp:include page="includes/footer.jsp" />
