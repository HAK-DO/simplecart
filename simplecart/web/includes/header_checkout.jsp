<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
    <head>
        <title>JSP Page</title>
        <script language="Javascript1.1" src="/simplecart/javascript/staticJavascript.jsp"></script>
    </head>
    <body>

    <table>
        <tr>
            <td colspan="2"><bean:write name="loggedInUser" property="nameFirst"/></td>
        </tr>
        <tr>
            <td valign="top" width="100">CHECKOUT</td>
            <td valign="top">