<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
<head>
<link rel="STYLESHEET" type="text/css" href="includes/style.css">
</head>

<body style="margin : 0px;">

<script language="Javascript1.1" src="/simplecart/javascript/staticJavascript.jsp"></script>
<html:javascript formName="loginForm" dynamicJavascript="true" staticJavascript="false"/>

<table cellpadding="0" cellspacing="0" border="0" align="center" width="100%" height="100%" class="background_matte">
    <tr>
        <td align="center" height="100%">
            <html:form action="/SubmitAdministratorLogin" focus="username" onsubmit="return validateLoginForm(this);">
            <table cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td width="1"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="135"><img src="images/spc.gif" width="135" height="1" border="0"><br></td>
                    <td width="5"><img src="images/spc.gif" width="5" height="1" border="0"><br></td>
                    <td width="145"><img src="images/spc.gif" width="145" height="1" border="0"><br></td>
                    <td width="120"><img src="images/spc.gif" width="120" height="1" border="0"><br></td>
                    <td width="1"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- black line --><tr><td colspan="6" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td colspan="4" align="right" class="navigation_matte"><html:img bundle="images" pageKey="clip.login.adminlogin" hspace="10"/></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- black line --><tr><td colspan="6" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>
                <!-- spacer row --><tr><td height="3" colspan="6"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>
                <!-- black line --><tr><td colspan="6" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td colspan="4" align="center" class="white_matte"><html:img bundle="images" pageKey="logo.simplecart.large" vspace="20"/></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- display login errors when needed -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td colspan="4" align="center" class="white_matte"><html:errors/></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- gather username -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="135" class="white_matte copy" align="right"><bean:message key="promptParty.username"/>: </td>
                    <td width="5" class="white_matte"><img src="images/spc.gif" width="5" height="1" border="0"><br></td>
                    <td width="145" class="white_matte"><html:text property="username" size="12" maxlength="18"/></td>
                    <td width="120" class="white_matte"><img src="images/spc.gif" width="120" height="1" border="0"><br></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- spacer row -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td colspan="4" height="4" class="white_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- gather password -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="135" class="white_matte copy" align="right"><bean:message key="promptParty.password"/>: </td>
                    <td width="5" class="white_matte"><img src="images/spc.gif" width="5" height="1" border="0"><br></td>
                    <td width="145" class="white_matte"><html:password property="password" size="12" maxlength="18" redisplay="false"/></td>
                    <td width="120" class="white_matte"><html:image bundle="images" pageKey="btn.login" style="border-width : 0px;"/></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- forgotten password -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="135" class="white_matte">&nbsp;</td>
                    <td width="5" class="white_matte"><img src="images/spc.gif" width="5" height="1" border="0"><br></td>
                    <td width="145" class="white_matte">&nbsp;</td>
                    <td width="120" class="white_matte copy"><html:link href="#"><bean:message key="link.forgotpassword"/></html:link></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- spacer row -->
                <tr>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td colspan="4" height="20" class="white_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                    <td width="1" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td>
                </tr>
                <!-- black line --><tr><td colspan="6" class="black_matte"><img src="images/spc.gif" width="1" height="1" border="0"><br></td></tr>
                <tr>
                    <td colspan="6" height="30" valign="center" align="center" class="background_matte, copy"><bean:message key="simplecart.copyright"/></td>
                </tr>
                <!-- old code
                <tr>
                    <td colspan="2" width="200" height="20" valign="top"><bean:message key="login.greeting"/></td>
                </tr>
                -->
            </table>
            </html:form>
        </td>
    </tr>
</table>

</body>
</html:html>