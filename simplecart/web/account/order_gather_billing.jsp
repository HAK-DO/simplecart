<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="/includes/header_checkout.jsp" />

<bean:message key="adminMessage.welcome"/>

<html:errors/>

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
    <html:form action="/PrepareOrder">
    <tr><td colspan="3"><h4><bean:message key="accountMessage.createAccount"/></h4></td>
    <tr>
        <td align="right" width="250"><bean:message key="promptCCDetails.cardType"/></td>
        <td width="10"></td>
        <td width="150">
          <html:select property="creditCardType">
          <html:option key="creditCard.visa" value="1"/>
          <html:option key="creditCard.mc" value="2"/>
          <html:option key="creditCard.disc" value="3"/>
          </html:select>
        </td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message key="promptCCDetails.cardNumber"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="creditCardNumber" size="16" maxlength="16"/></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message key="promptCCDetails.cardExpMonth"/></td>
        <td width="10"></td>
        <td width="150">
          <html:select property="creditCardExpirationMonth">
          <html:option value="01">01</html:option>
          <html:option value="02">02</html:option>
          <html:option value="03">03</html:option>
          <html:option value="04">04</html:option>
          <html:option value="05">05</html:option>
          <html:option value="06">06</html:option>
          <html:option value="07">07</html:option>
          <html:option value="08">08</html:option>
          <html:option value="09">09</html:option>
          <html:option value="10">10</html:option>
          <html:option value="11">11</html:option>
          <html:option value="12">12</html:option>
          </html:select>
        </td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message key="promptCCDetails.cardExpYear"/></td>
        <td width="10"></td>
        <td width="150">
          <html:select property="creditCardExpirationYear">
          <html:option value="2005">2005</html:option>
          <html:option value="2006">2006</html:option>
          <html:option value="2007">2007</html:option>
          <html:option value="2008">2008</html:option>
          <html:option value="2009">2009</html:option>
          <html:option value="2010">2010</html:option>
          <html:option value="2011">2011</html:option>
          <html:option value="2012">2012</html:option>
          </html:select>
        </td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message key="promptCCDetails.CVVSCode"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="creditCardCVVSCode" size="6"/></td>
    </tr>
    <tr>
        <td align="right">
            <html:hidden property="activity" value="enterBilling"/>
            <html:submit property="Submit" value="Submit Billing"/>
        </td>
        <td width="10"></td>
        <td><html:reset/></td>
    </tr>
    </html:form>
</table>

<jsp:include page="/includes/footer.jsp" />
