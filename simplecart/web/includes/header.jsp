<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
<title>Simple Cart Java Shopping Cart Software</title>
<link href="/simplecart/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/simplecart/dist/docs.css" rel="stylesheet">

<link rel="STYLESHEET" type="text/css" href="/simplecart/includes/style.css">
<script language="Javascript1.1" src="/simplecart/javascript/staticJavascript.jsp"></script>
<script language="JavaScript" src="/simplecart/js_source.js"></script>

<!--#include virtual="/nav.html" -->

</head>
  <body class="bs-docs-home">
    <a class="sr-only" href="#content">Skip to main content</a>

    <!-- Docs master nav -->
    <header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="./Welcome.do" class="navbar-brand">simple cart</a>
    </div>
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
		<ul class="nav navbar-nav">
			<logic:iterate id="category" name="menu_categories">
				<li>
					<links:manageCategory page="/CatalogBrowse" activity="listing">
						<bean:write name="category" property="name" filter="true" />
					</links:manageCategory>
				</li>
			</logic:iterate>
		</ul>
		<ul class="nav navbar-nav navbar-right">
	        <li>
		      	<html:link action="/ShopcartManage?activity=display">View Cart</html:link>
	        </li>
	        <li>
	        <logic:empty name="loggedInUser" scope="session"> 
		      	<html:link action="/LoginAcoount">Login in Account</html:link>
	        </logic:empty>
	        <logic:notEmpty name="loggedInUser" scope="session">
	        	<a>
	        		<bean:write name="loggedInUser" property="username"/>
	        	</a>
	        </logic:notEmpty>
<!-- 	          	<a href="/LoginAcoount">Login in Account</a> -->
	<%--           <html:img hspace="10" vspace="10" bundle="images" pageKey="btn.login.account" border="0"/> --%>
	        </li>        
      </ul>
    </nav>
  </div>
</header>

    <div class="bs-header" id="content">
      <div class="container">