<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<table>
    <tr>
        <td>
            <bean:message key="welcome.greeting"/><br>
            <html:link action="/InitializeDatabase.do">Initialize Database</html:link><br>
            <html:link forward="administrationLogin"><bean:message key="adminLink.login"/></html:link><br>
            <html:link forward="publicSite"><bean:message key="publicLink.home"/></html:link><br>
        </td>
    </tr>
</table>
