<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>

<jsp:include page="includes/header.jsp" />

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td colspan="5"><bean:message bundle="administration" key="adminMessage.product.display"/><br></td>
    </tr>

    <!-- provide a link to add a new stake -->
    <tr>
        <td colspan="6"><links:manageProduct page="/ManageProduct" activity="enter"><bean:message bundle="administration" key="link.add"/> <bean:message bundle="administration" key="adminLink.product"/></links:manageProduct></td>
    </tr>

    <!-- spacer --><tr><td height="20"></td></tr>
    
    <tr>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="200"><img src="images/spc.gif" width="200" height="1" border="0"><br></td>
        <td width="175"><img src="images/spc.gif" width="175" height="1" border="0"><br></td>
        <td width="175"><img src="images/spc.gif" width="175" height="1" border="0"><br></td>
        <td width="175"><img src="images/spc.gif" width="175" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="100"><bean:message bundle="administration" key="promptCatalogItem.name"/></td>
        <td width="200"><bean:message bundle="administration" key="promptCatalogItem.description"/></td>
        <td width="175"><bean:message bundle="administration" key="promptSearchUtility.searchMetaAuthor"/></td>
        <td width="175"><bean:message bundle="administration" key="promptSearchUtility.searchMetaKeywords"/></td>
        <td width="175"><bean:message bundle="administration" key="promptSearchUtility.searchMetaDescription"/></td>
        <td width="70"></td>
        <td width="70"></td>
    </tr>
    
    <logic:iterate id="product" name="products">
    <tr>
        <td align="left" valign="top"><bean:write name="product" property="name" filter="true"/></td>
        <td align="left" valign="top"><bean:write name="product" property="description" filter="true"/></td>
        <td align="left" valign="top"><bean:write name="product" property="searchDetails.searchMetaAuthor" filter="true"/></td>
        <td align="left" valign="top"><bean:write name="product" property="searchDetails.searchMetaKeywords" filter="true"/></td>
        <td align="left" valign="top"><bean:write name="product" property="searchDetails.searchMetaDescription" filter="true"/></td>
        <td align="left" valign="top"><links:manageProduct page="/ManageProduct"><bean:message bundle="administration" key="link.edit"/></links:manageProduct></td>
        <td align="left" valign="top"><links:manageProduct page="/ManageProduct" activity="delete"><bean:message bundle="administration" key="link.delete"/></links:manageProduct></td>
    </tr>
    </logic:iterate>

</table>

<jsp:include page="includes/footer.jsp" />
