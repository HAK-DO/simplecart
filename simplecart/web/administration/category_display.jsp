<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>

<jsp:include page="includes/header.jsp" />

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td colspan="4" height="25" valign="top" class="heading_page copy"><bean:message bundle="administration" key="adminMessage.category.display"/><br></td>
    </tr>

    <!-- provide a link to add a new stake -->
    <tr>
        <td colspan="4"><links:manageCategory page="/ManageCategory" activity="enter" styleClass="copy"><bean:message bundle="administration" key="link.add"/> <bean:message bundle="administration" key="adminLink.category"/> <html:img bundle="adminimages" pageKey="button.add" border="0"/></links:manageCategory></td>
    </tr>

    <!-- spacer --><tr><td height="20"></td></tr>
    
    <tr>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="200"><img src="images/spc.gif" width="200" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="100" align="center" class="table_border_column_definition copy"><bean:message bundle="administration" key="promptCatalogItem.name"/></td>
        <td width="200" align="center" class="table_border_column_definition copy"><bean:message bundle="administration" key="promptCatalogItem.description"/></td>
        <td width="70" align="center" class="table_border_column_definition"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
        <td width="70" align="center" class="table_border_column_definition"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    </tr>
    
    <% int count=0; %>
    <logic:iterate id="category" name="categories">
    <tr class="<%= (count++ % 2==0 ?"table_shading_on":"table_shading_off") %>">
        <td align="left" class="table_border_column_normal copy"><bean:write name="category" property="name" filter="true"/></td>
        <td align="left" class="table_border_column_normal copy"><bean:write name="category" property="description" filter="true"/></td>
        <td align="center" class="table_border_column_normal copy"><links:manageCategory page="/ManageCategory"><html:img bundle="adminimages" pageKey="button.edit" border="0"/></links:manageCategory></td>
        <td align="center" class="table_border_column_end copy"><links:manageCategory page="/ManageCategory" activity="delete"><bean:message bundle="administration" key="link.delete"/></links:manageCategory></td>
    </tr>
    </logic:iterate>

</table>

<jsp:include page="includes/footer.jsp" />
