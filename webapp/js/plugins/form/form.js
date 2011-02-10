 function CloseAllConditionalEntry()
 {
	var elts = document.getElementsByTagName('div');
	for (var j=0;j<elts.length;j++) 
	{
	  
		if (elts[j].className=='form-element-conditionnel') 
		{
			elts[j].style.visibility='hidden';
			elts[j].style.display='none';
		}
	}
}

function displayId(baliseId)
{
	if (document.getElementById && document.getElementById(baliseId) != null) {
		document.getElementById(baliseId).style.visibility='visible';
		document.getElementById(baliseId).style.display='block';
	}
}

function hideId(baliseId) {
	if (document.getElementById && document.getElementById(baliseId) != null) {
   		document.getElementById(baliseId).style.visibility='hidden';
    	document.getElementById(baliseId).style.display='none';
	}
}
  
function getElementById(id) {
	if (document.getElementById) return document.getElementById(id);
	if (document.all) return eval("document.all."+id);
	return null;
}

function display(id, value) {
	var panel = getElementById(id);
	panel.style.display = value;
}

 function doDisplay(id)
{
	displayId("div"+id);
}
function hide(id)
{
     hideId("div"+id);
}

 function doCheckboxEffect(isChecked,id) 
{
	if (isChecked) 
	{
		doDisplay(id);
	} 
	else 
	{
		hide(id);
	}
}
function openFrontRequirement(url)
{
	var form_win_requirement = self.open(url, 'requirement', 'toolbar=no,location=no,directories=no,status=yes,menubar=no,scrollbar=yes,resizable=yes,copyhistory=yes,width=500px,height=300px');
	form_win_requirement.focus();
}

//for datepicker questions
$(document).ready(function () 
{
	var locale = "en-US";
	if(document.getElementById("locale") != null)
	{
		locale = document.getElementById("locale").innerHTML;
	}

	$.datepicker.setDefaults({
		showOn: 'button', 
		buttonImageOnly: true, 
		buttonImage: 'js/jquery/plugins/ui/datepicker/calendar.png', 
		buttonText: 'Calendar', 
		showAnim: 'slideDown', 
		speed: 'fast'
	});

	$( ".datepicker-element" ).each(function( i ){
		/*$(this).datepicker($.extend({showStatus: true}, $.datepicker.regional[locale]));*/
		$(this).datepicker();
	});
});
