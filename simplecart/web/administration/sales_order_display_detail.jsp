<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="includes/header.jsp" />

Customer Information<br>
<bean:write name="salesOrder" property="customer.nameFirst"/> <bean:write name="salesOrder" property="customer.nameLast"/><br>
<bean:write name="salesOrder" property="customer.address.streetLine1"/><br>
<bean:write name="salesOrder" property="customer.address.city"/> <bean:write name="salesOrder" property="customer.address.state"/>, <bean:write name="salesOrder" property="customer.address.postalCode"/><br>
<br>
Order Information<br>
Order #: <bean:write name="salesOrder" property="id"/><br>
Date Placed: <bean:write name="salesOrder" property="placedOn"/><br>
Notes: <i><bean:write name="salesOrder" property="notes"/></i><br>
<bean:write name="salesOrder" property="address.streetLine1"/><br>
<bean:write name="salesOrder" property="address.city"/> <bean:write name="salesOrder" property="address.state"/>, <bean:write name="salesOrder" property="address.postalCode"/><br>
<br>
Billing Information<br>
<logic:iterate id="payment" name="salesOrderPayments">
Credit Card Type: <bean:write name="payment" property="creditCardType"/><br>
Credit Card Number: <bean:write name="payment" property="creditCardNumber"/><br>
Credit Card Exp. Date: <bean:write name="payment" property="expirationDate"/><br>
Credit Card CVVS: <bean:write name="payment" property="creditCardCVVSCode"/><br>
</logic:iterate>

<br>
Line Items<br>
<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="110"><img src="images/spc.gif" width="110" height="1" border="0"><br></td>
        <td width="100"><img src="images/spc.gif" width="100" height="1" border="0"><br></td>
        <td width="110"><img src="images/spc.gif" width="110" height="1" border="0"><br></td>
        <td width="70"><img src="images/spc.gif" width="70" height="1" border="0"><br></td>
    </tr>
    
    <tr>
        <td width="110" align="center" class="table_border_column_definition copy">SKU</td>
        <td width="100" align="center" class="table_border_column_definition copy">QTY</td>
        <td width="110" align="center" class="table_border_column_definition copy">COST</td>
        <td width="70" align="center" class="table_border_column_definition copy">TOTAL</td>
    </tr>
    
    <% 
    int count=0; 
    String rowClass = "table_shading_on";
    %>
    <logic:iterate id="lineItem" name="salesOrderLineItems">
    <% rowClass = (count++ % 2==0 ?"table_shading_on":"table_shading_off"); %>
    <tr class="<%= rowClass %>">
        <td align="left" class="table_border_column_normal copy"><bean:write name="lineItem" property="option.stockKeepingUnitIdentifier"/></td>
        <td align="left" class="table_border_column_normal copy"><bean:write name="lineItem" property="quantity" filter="true"/></td>
        <td align="left" class="table_border_column_normal copy"><bean:write name="lineItem" property="unitPrice" filter="true"/></td>
        <td align="center" class="table_border_column_end copy"><bean:write name="lineItem" property="lineItemTotalCost"/></td>
    </tr>
    <tr class="<%= rowClass %>">
        <td colspan="4" align="left" class="table_border_column_normal table_border_column_end copy"><bean:write name="lineItem" property="comment" filter="true"/></td>
    </tr>
    </logic:iterate>
</table>


<jsp:include page="includes/footer.jsp" />
