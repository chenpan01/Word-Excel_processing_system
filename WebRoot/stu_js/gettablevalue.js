var value="";
window.onload = function()
{
	  	doSomething();
};
function doSomething() 
{
		
		var fruit = document.getElementById("rtl");
		fruit.onchange = function()
		 {
			var option = document.getElementsByTagName("option");
			value = option[fruit.selectedIndex].value;
			console.log(option[fruit.selectedIndex]);
		}
}
function submitit() {
	alert("safsdfd");
	document.getElementById('formid').action = "Servler_xsdeal?method=upload&num=" + value;
	document.getElementById("formid").submit();
}

