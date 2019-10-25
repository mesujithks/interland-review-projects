 /* @Revision $Revision: 1696 $
 * @Author $Author: sumanth $
 * @Date $Date: 2009-08-05 15:15:17 +0530 (Wed, 05 Aug 2009) $
 */

function trim(stringToTrim){
	return stringToTrim.replace(/^\s+|\s+$/g,'');
}

function searchDiscussion() {
	var key = trim(document.search.searchkey.value);
	if(trim(key)=='')
		{
			alert("Please enter search string");
			document.search.searchkey.focus();
			return false;
		}
	document.search.action="/online_university/forumsearch.html";
 	document.search.submit();
 	return true;
}

function mouseClick()
	{
		document.click.area.value='';
		document.click.area.focus();
		return true;
	}
