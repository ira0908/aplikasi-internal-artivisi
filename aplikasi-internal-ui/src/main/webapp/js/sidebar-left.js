// Begin Left Sidebar
// CHANGE VARIABLES TO "no" OR "yes" - ONLY USE lowercase FOR ALL OPTIONS
var spacing		= "2"		// NUDGE SIDEBAR DOWN
var showscroller	= "yes"		// SHOW SIDEBAR SCROLLER
var showsflash		= "yes"		// SHOW FLASH IMAGE CHANGER
var flashcolor		= "000000"	// FLASH BACKGROUND COLOR
var flashwidth		= "150"		// WIDTH OF THE FLASH (IN PIXELS)
var flashheight		= "150"		// HEIGHT OF THE FLASH (IN PIXELS)

// COPYRIGHT 2009 © Allwebco Design Corporation
// Unauthorized use or sale of this script is strictly prohibited by law
// YOU DO NOT NEED TO EDIT BELOW THIS LINE
// NUDGE SPACER
document.write('<img src="${base}/picts/spacer.gif" height="'+spacing+'" width="10"><br>');

// FLASH CHANGER
   if (showsflash == "yes") {
	   document.write('<TABLE cellpadding="0" cellspacing="0" border="0" class="sideborder"><tr><td valign="top">');
	   document.write('<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" WIDTH="'+flashwidth+'" HEIGHT="'+flashheight+'" id="imagechanger">');
	   document.write('<PARAM NAME="movie" VALUE="imagechanger.swf">');
	   document.write('<PARAM NAME="quality" VALUE="high">');
	   document.write('<PARAM NAME="wmode" VALUE="transparent">');
	   document.write('<PARAM NAME="bgcolor" VALUE="#'+flashcolor+'">');
	   document.write('<EMBED src="imagechanger.swf" quality="high" wmode="transparent" bgcolor="#'+flashcolor+'"  WIDTH="'+flashwidth+'" HEIGHT="'+flashheight+'" NAME="imagechanger" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer"></EMBED></OBJECT><br>');
	   document.write('</td></tr></table>');
	   document.write('<br>');
   }

   if (showscroller == "yes") {
	   if (navigator.userAgent.indexOf('Safari') != -1) {
		   document.write('<br>');
	   } else {
		   document.write('<table cellpadding="0" cellspacing="0" border="0" class="sideborder"><tr><td align="center">');
		   Tscroll_init (0)
		   document.write('</td></tr></table>');
		   document.write('<br>');
	   }
   }
// -- END -->