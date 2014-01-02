// swap images using the cached images
function swap(x, y, parent) {
  if(document.all || document.getElementById) {
    if (document.images[x]) document.images[x].src=eval(y+'.src');
  } else if (document.layers) {
    if (parent) {
      if (eval('document.'+parent+'.document.images["'+x+'"]')) {
        eval('document.'+parent+'.document.images["'+x+'"].src = '+y+'.src')
      }
    } else if (eval('document.images["'+x+'"]')) {
      eval('document.images["'+x+'"].src = '+y+'.src')
    }
  }
}

//cache images for quick image swapping
function preload() {
  if (document.images) {
    for(var i = 0; i < preload.arguments.length; i += 2) {
      eval(preload.arguments[i]+'on = new Image()')
      eval(preload.arguments[i]+'on.src = "images/'+preload.arguments[i+1]+'_hover.gif"')
      eval(preload.arguments[i]+'off = new Image()')
      eval(preload.arguments[i]+'off.src = "images/'+preload.arguments[i+1]+'.gif"')
    }
  }
}


var doc = (document.layers) ? 'document.':'document.all.';
var sty = (document.layers) ? '' : '.style';
var ns = (document.layers)? true:false
var ie = (document.all)? true:false
var ns6 = (document.getElementById)? true:false

// Show/Hide functions for non-pointer layer/objects
function show(id) {
  if (ns) { if (document.layers[id]) document.layers[id].visibility = "show" }
  else if (ie) { if (document.all[id]) document.all[id].style.visibility = "visible" }
  else if (ns6) { if (document.getElementById(id)) document.getElementById(id).style.visibility="visible"; }
}

function hide(id) {
  if (ns) { if (document.layers[id]) document.layers[id].visibility = "hide" }
  else if (ie) { if (document.all[id]) document.all[id].style.visibility = "hidden" }
  else if (ns6) { if (document.getElementById(id)) document.getElementById(id).style.visibility="hidden"; }
}

function setTop(eleId, y) {
 if (document.all || document.layers || document.getElementById) {
  if (document.getElementById)
   document.getElementById(eleId).style.top = y;
  else
   eval(doc + eleId + sty + '.top = ' + y);
 }
}

function setLeft(eleId, x) {
 if (document.all || document.layers || document.getElementById) {
  if (document.getElementById)
   document.getElementById(eleId).style.left = x;
  else
   eval(doc + eleId + sty + '.left = ' + x);
 }
}

function move(eleId, x, y) {
  setTop(eleId, y);
  setLeft(eleId, x);
}

/********************** nav stuff below **********************/
navTimer = 0	// used by menu setTimeout() functions

function showNav (what) {
  show(what+'Div');
  swap(what, what+'on');
}

function hideNav (what) {
  exeHide = "hide('"+what+"Div'); swap('"+what+"','"+what+"off');";
  navTimer = setTimeout(exeHide ,1000);
}

function hideAll (what) {
  //this for loop hides other navigation when a new menu is opened
  //it uses an array built when the navigation is created.
  for (i=0;i<navigation.length;i++) {
    hide('navArrowDiv');
    if (navigation[i] != what) {
      hide(navigation[i]+'Div');
      swap(navigation[i],navigation[i]+'off');
    }
  }
}

function navDisplay (what, showHide, x, y) {
  (showHide) ? swap(what, what+'on'):swap(what, what+'off');
  (showHide) ? show('nav_arrow_up'):hide('nav_arrow_up');
  (showHide) ? move('nav_arrow_up',x,y):'';
}

function leftnavDisplay (what, showHide) {
  (showHide) ? swap(what, what+'on'):swap(what, what+'off');
  (showHide) ? show('desc_'+what):hide('desc_'+what);
  hide('sbankingDiv');
  swap('sbanking','sbankingoff');
}

function makeLayer (layer,name,x,y,zindex) {
	content = '';
	if (x>0 && y>0) {
		content += (document.layers) ? '<layer name="'+name+'" left="'+x+'" top="'+y+'" z-index="'+zindex+'" position="absolute" visibility="hidden">\n':'<div id="'+name+'" style="position: absolute; left: '+x+'; top: '+y+'; z-index: '+zindex+'; visibility: hidden;">\n';
	} else {
		content += (document.layers) ? '<layer name="'+name+'" z-index="'+zindex+'" position="relative" visibility="hidden">\n':'<div id="'+name+'" style="position: relative; z-index: '+zindex+'; visibility: hidden;">\n';
	}
	content += (layer);
	content += (document.layers) ? '</layer>\n':'</div>\n';
	return(content);
}

function popWindow (choice,myWidth,myHeight,myScrollbars,myTop,myLeft,myMenubar) {
  var ziWin = window.open (choice, "","width="+myWidth+",height="+myHeight+",scrollbars="+myScrollbars+",top="+myTop+",left="+myLeft+",menubar="+myMenubar+",bgcolor=#ffffff,resizable=yes");
  if (ziWin) ziWin.focus();	
}

function buildBreadcrumb (breadcrumbArray) {
	newBreadcrumb = '<span class="breadcrumb">';
	for (i=0; i<breadcrumbArray.length; i++) {
		// open link tag
		if (breadcrumbArray[i][0] != '') newBreadcrumb += '<a href="'+breadcrumbArray[i][0]+'" class="breadcrumb">';
		// add breadcrumb name
		newBreadcrumb += breadcrumbArray[i][1];
		// close link tag
		if (breadcrumbArray[i][0] != '') newBreadcrumb += '</a>';
		// add separator
		newBreadcrumb += '<img src="images/bread_crumb.gif" width="28" height="9" border="0">';
	}
	newBreadcrumb += '</span>';
	return newBreadcrumb;
}

function buildHeader (header) {
	newHeader = '<span class="headline">';
	// add breadcrumb name
	newHeader += header;
	newHeader += '</span>';
	return newHeader;
}


/********************************************************************
  this function sets a cookie value that will expire in two years
 ********************************************************************/
function setCookieValue(valueName, value) {
  var exp = new Date();
  var nowPlusOneWeek = exp.getTime() + (104*7*24*60*60*1000);
  exp.setTime(nowPlusOneWeek);
  //alert(valueName+"="+value+"; expires="+(exp.toGMTString())+"; domain="+domain);
  document.cookie = valueName+"="+value+"; expires="+exp.toGMTString();
  //return (document.cookie);
}

function stripSpaces(string) {
  return(string.replace(/^\W+/,'')).replace(/\W+$/,'');
}

/* example usage: setCookieValue('username','Daniel Watrous'); */

/********************************************************************
  this function returns an array of the contents of the cookie
  indexed by the name of each value.  Reference the values in
  this manner: returnedArray["valueName"].
 ********************************************************************/
function makeCookieArray () {
  var cookieTable = new Array;
  var cookieString = document.cookie+"";
  var cookieArray = cookieString.split(";");
  for (i=0; i<cookieArray.length; i++) {
    cookieTable[stripSpaces(cookieArray[i].split("=")[0])] = cookieArray[i].split("=")[1];
    //alert(cookieTable["username"]);
  }
  return(cookieTable);
}

function submit (form) {
  formObj = eval('document.'+form)
  formObj.submit();
}
