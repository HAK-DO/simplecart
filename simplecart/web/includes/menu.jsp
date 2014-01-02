<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<h3>MENU</h3><br>
<html:link action="/ShopcartManage?activity=display">Shopcart</html:link><br><br>

<logic:iterate id="category" name="menu_categories">
<links:manageCategory page="/CatalogBrowse" activity="listing"><bean:write name="category" property="name" filter="true"/></links:manageCategory><br>
</logic:iterate>
