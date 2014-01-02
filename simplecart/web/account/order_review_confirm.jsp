<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="/includes/header_checkout.jsp" />

<bean:message key="adminMessage.welcome"/>

<table>
    <tr>
        <td>Order Address:</td>
    </tr>
    <tr>
        <td>
            <bean:write name="order_address" property="streetLine1"/><br>
            <bean:write name="order_address" property="streetLine2"/><br>
            <bean:write name="order_address" property="city"/>,  <bean:write name="order_address" property="state"/> <bean:write name="order_address" property="postalCode"/><br>
        </td>
    </tr>
</table>

<table>
    <tr>
        <td>Order Billing:</td>
    </tr>
    <tr>
        <td>
            <%--<bean:write name="order_billing" property="value"/><br> --%>
        </td>
    </tr>
</table>


<logic:iterate id="item" name="shopcart" property="items" indexId="itemIndex">
<bean:write name="item" property="name" filter="true"/>
<bean:write name="item" property="description" filter="true"/>
<bean:write name="item" property="amount" filter="true"/>
<bean:write name="item" property="price" filter="true"/>
<%-- <bean:write name="item" property="total" filter="true"/> --%>
<br>
</logic:iterate>

<b>Total: <bean:write name="shopcart" property="cartTotal"/></b>

<table>
    <html:form action="/ProcessOrder">
    <tr><td colspan="3"><h4><bean:message key="accountMessage.createAccount"/></h4></td>
    <tr>
        <td align="right">
            <html:submit property="Submit" value="Submit Order"/>
        </td>
        <td width="10"></td>
        <td><html:reset/></td>
    </tr>
    </html:form>
</table>

<jsp:include page="/includes/footer.jsp" />
