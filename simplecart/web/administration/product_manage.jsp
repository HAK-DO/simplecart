<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="includes/header.jsp" />

<html:errors/>
<html:javascript formName="/PersistProduct" dynamicJavascript="true" staticJavascript="false"/>

<table cellpadding="0" cellspacing="0" border="0">

    <html:form action="/PersistProduct" focus="name" onsubmit="return validateCatalogItemForm(this);">
    <tr>
        <td colspan="3"><bean:message bundle="administration" key="adminMessage.product.manage"/><br></td>
    </tr>
    <tr>
        <td colspan="3"><bean:message bundle="administration" key="fieldSection.catalog"/><br></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptCategory.chooseParent"/></td>
        <td width="10"></td>
        <td width="150">
            <html:select property="categoryId" name="catalogItemForm">
                <html:options collection="categories" property="id" labelProperty="name"/>
            </html:select>
        </td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptCatalogItem.name"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="name" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptCatalogItem.description"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="description" size="15" /></td>
    </tr>
    <tr>
        <td colspan="3"><bean:message bundle="administration" key="fieldSection.search"/><br></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptSearchUtility.searchMetaAuthor"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="searchMetaAuthor" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptSearchUtility.searchMetaKeywords"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="searchMetaKeywords" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptSearchUtility.searchMetaDescription"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="searchMetaDescription" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptSearchUtility.searchMetaDate"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="searchMetaDate" size="15" /></td>
    </tr>
    <tr>
        <td align="right" width="250"><bean:message bundle="administration" key="promptSearchUtility.searchMetaCopyright"/></td>
        <td width="10"></td>
        <td width="150"><html:text property="searchMetaCopyright" size="15" /></td>
    </tr>
    <tr>
        <td align="right">
            <logic:equal name="catalogItemForm" property="activity" value="enter">
                <html:hidden property="activity" value="enter"/>
                <html:submit property="Submit" value="Submit"/>
            </logic:equal>
            <logic:equal name="catalogItemForm" property="activity" value="edit">
                <html:hidden property="id" name="catalogItemForm"/>
                <html:hidden property="activity" value="edit"/>
                <html:submit property="Submit" value="Submit"/>
            </logic:equal>
            <logic:equal name="catalogItemForm" property="activity" value="delete">
                <html:hidden property="id" name="catalogItemForm"/>
                <html:hidden property="activity" value="delete"/>
                <html:submit property="Submit" value="Delete"/>
            </logic:equal>
        </td>
        <td width="10"></td>
        <td><html:reset/></td>
    </tr>
    </html:form>

</table>

<jsp:include page="includes/footer.jsp" />
