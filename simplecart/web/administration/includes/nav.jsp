<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<script>
var navigation = new Array ('mainnavDiv','docsnavDiv');

var main_nav_array = new Array(
    'Catalog Management',
    '<html:link styleClass="navigation_link copy" action="/ManageCategory.do?activity=display"><bean:message bundle="administration" key="adminLink.category"/></html:link>',
    '<html:link styleClass="navigation_link copy" action="/ManageProduct.do?activity=display"><bean:message bundle="administration" key="adminLink.product"/></html:link>',
    '<html:link styleClass="navigation_link copy" action="/ManageOption.do?activity=display"><bean:message bundle="administration" key="adminLink.option"/></html:link>',
    '<html:link styleClass="navigation_link copy" action="/ManageAdministrator.do?activity=display"><bean:message bundle="administration" key="adminLink.administrator"/></html:link>');

var docs_nav_array = new Array(
    'Order Management',
    '<html:link action="/ManageSalesOrder.do?activity=displayAll">View Orders</html:link>');

function makeNavigation (nav_array,div_name) {
	menu = '';
	menu += '<table cellpadding="0" cellspacing="0" border="0">\n';
	menu += '	<!-- column definition -->\n';
	menu += '	<tr>\n';
	menu += '		<td width="18" class="navigation_category_matte"><img src="images/spc.gif" width="18" height="1" border="0"><br></td>\n';
	menu += '		<td width="20" class="navigation_category_matte"><img src="images/spc.gif" width="20" height="1" border="0"><br></td>\n';
	menu += '		<td width="137" class="navigation_category_matte"><img src="images/spc.gif" width="137" height="1" border="0"><br></td>\n';
	menu += '	</tr>\n';

	menu += '	<tr>\n';
	menu += '		<td width="18" class="navigation_category_matte" height="19" align="center" valign="center"><html:img bundle="adminimages" pageKey="icon.arrow.expanded"/><br></td>\n';
	menu += '		<td colspan="2" class="navigation_category_matte navigation_link  copy" valign="center">\n';
	menu += '			'+nav_array[0]+'\n';
	menu += '		</td>\n';
	menu += '	</tr>\n';
	menu += '	<!-- top orange line --><tr><td colspan="3" class="background_matte"><img src="images/spc.gif" width="1" height="2" border="0"</td></tr>\n';

	for (i=1;i<nav_array.length;i++) {
		menu += '	<tr>\n';
		menu += '		<td colspan="2" class="white_matte"><img src="images/spc.gif" width="1" height="18" border="0"><br></td>\n';
		menu += '		<td width="137" class="white_matte  copy">';
		menu += '			'+nav_array[i]+'\n';
		menu += '		</td>\n';
		menu += '	</tr>\n';
	}
	menu += '	<!-- top orange line --><tr><td colspan="3" class="background_matte"><img src="images/spc.gif" width="1" height="2" border="0"</td></tr>\n';

	menu += '</table>\n';
	return menu;
}

document.write(makeLayer(makeNavigation(main_nav_array,'mainnavDiv'),'mainnavDiv',22,80,10));
document.write(makeLayer(makeNavigation(docs_nav_array,'docsnavDiv'),'docsnavDiv',22,178,9));
show('mainnavDiv');
show('docsnavDiv');
</script>
