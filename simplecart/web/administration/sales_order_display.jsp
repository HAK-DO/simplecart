<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="includes/header.jsp" />

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td colspan="4" height="25" valign="top" class="heading_page copy"><bean:message bundle="administration" key="adminMessage.category.display"/><br></td>
    </tr>

    <!-- spacer --><tr><td height="20"></td></tr>
    
    <tr>
        <td width="110"><img src="images/spc.gif" width="110" height="1" border="0"><br></td>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="110"><img src="images/spc.gif" width="110" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="110" align="center" class="table_border_column_definition copy"><bean:message bundle="administration" key="promptParty.nameFirst"/> / <bean:message bundle="administration" key="promptParty.nameLast"/></td>
        <td width="100" align="center" class="table_border_column_definition copy"><bean:message bundle="administration" key="promptSalesOrder.placedOn"/></td>
        <td width="110" align="center" class="table_border_column_definition copy"><bean:message bundle="administration" key="promptSalesOrder.salesOrderTotalCost"/></td>
        <td width="70" align="center" class="table_border_column_definition"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    </tr>
    
    <% int count=0; %>
    <logic:iterate id="salesOrder" name="salesOrders">
    <tr class="<%= (count++ % 2==0 ?"table_shading_on":"table_shading_off") %>">
        <td align="left" class="table_border_column_normal copy"><bean:write name="salesOrder" property="customer.nameFirst"/> <bean:write name="salesOrder" property="customer.nameLast"/></td>
        <td align="left" class="table_border_column_normal copy"><bean:write name="salesOrder" property="placedOn" filter="true"/></td>
        <td align="left" class="table_border_column_normal copy"><bean:write name="salesOrder" property="salesOrderTotalAsString" filter="true"/></td>
        <td align="center" class="table_border_column_end copy"><html:link href='<%= "ManageSalesOrder.do?activity=displayDetail&id=" + ((org.simplecart.contract.salesorder.InternetSalesOrder) salesOrder).getId() %>'><bean:message key="link.viewdetail"/></html:link></td>
    </tr>
    </logic:iterate>

</table>

<jsp:include page="includes/footer.jsp" />
