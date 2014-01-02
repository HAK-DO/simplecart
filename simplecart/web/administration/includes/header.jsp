<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
<head>
<title>Simple Cart: Shopping Cart Application</title>
<link rel="STYLESHEET" type="text/css" href="/simplecart/includes/style.css">
<script language="JavaScript" src="/simplecart/javascript/js_source.js"></script>

<jsp:include page="nav.jsp"/>

</head>

<body  style="margin : 0px;">

<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
  <!-- column definition row -->
  <tr>
    <td width="22" class="background_matte"><img src="images/spc.gif" width="22" height="1" border="0"><br></td>
    <td width="1" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td width="175" class="white_matte"><img src="images/spc.gif" width="175" height="1" border="0"><br></td>
    <td width="2" class="white_matte"><img src="images/spc.gif" width="2" height="1" border="0"><br></td>
    <td width="20" class="white_matte"><img src="images/spc.gif" width="20" height="1" border="0"><br></td>
    <td width="522" class="white_matte"><img src="images/spc.gif" width="522" height="1" border="0"><br></td>
    <td width="20" class="white_matte"><img src="images/spc.gif" width="20" height="1" border="0"><br></td>
    <td width="1" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
  </tr>

  <!-- HEADER CONTENT -->
  <tr>
    <td width="22" class="background_matte"><img src="images/spc.gif" width="22" height="1" border="0"><br></td>
    <td width="1" class="header_border"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td colspan="3" height="44" class="white_matte"><html:img hspace="10" bundle="adminimages" pageKey="logo.simplecart"/><br></td>
    <td colspan="2" class="white_matte" align="right" valign="center">
      <html:img bundle="adminimages" pageKey="clip.loggedin"/>
      <span class="copy_red_bold"><bean:write name="loggedInAdministrator" property="username"/></span>
      <html:link action="../Welcome.do"><html:img bundle="adminimages" pageKey="button.logout" border="0"/></html:link>
      <img src="images/spc.gif" width="5" height="1" border="0"><br>
    </td>
    <td width="1" class="header_border"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
  </tr>
  <tr>
    <td width="22" class="background_matte"><img src="images/spc.gif" width="22" height="1" border="0"><br></td>
    <td colspan="7" class="header_border"><img src="images/spc.gif" width="18" height="1" border="0"><br></td>
    <td width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
  </tr>
  <!-- background_matte spacer --><tr><td colspan="9" width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="10" border="0"><br></td></tr>
  <tr>
    <td width="22" class="background_matte"><img src="images/spc.gif" width="22" height="1" border="0"><br></td>
    <td colspan="7" class="navigation_matte"><img src="images/spc.gif" width="1" height="23" border="0"><br></td>
    <td width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
  </tr>
  <!-- background_matte spacer --><tr><td colspan="9" width="100%" class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>

  <!-- BEGIN CONTENT AREA -->
  <tr>
    <td class="background_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td colspan="2" class="navigation_category_matte" height="100%"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
    <td class="background_matte"><img src="images/spc.gif" width="2" height="1" border="0"><br></td>
    <td width="20" class="white_matte"><img src="images/spc.gif" width="20" height="1" border="0"><br></td>
    <td width="522" class="white_matte copy" valign="top"><br>


