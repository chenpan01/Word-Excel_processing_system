 //undefined 判断新增和修改方法 
var week='';

window.onload = function()
{
			$('#DIV_toolbar').appendTo('.datagrid-toolbar');
	  		doSomething();
	  		dogetWeek();
};
function setSelectOption(Id,targetValue)
{
	//objid：下拉列表框的ID；targetValue：当前所选值
	var obj = document.getElementById(Id+"");
//	alert("Id "+Id+" targetValue "+targetValue);
	if(obj){
		var options = obj.options;
		if(options){
			var len = options.length;
			for(var i=0;i<len;i++){
				if(options[i].value+"" == targetValue+""){
					options[i].defaultSelected = true;
					options[i].selected = true;
					return true;
				}
			}
		} 
			else {
				alert('missing element(s)!');
			}
		} 
}
		function dogetWeek()
		{
			var f=document.getElementById("typeId");
			f.onchange = function()
			{
				week = $(this).children('option:selected').val()+'';
				$('#hidden').val(week);
				var xlform=document.getElementById("xlform");
				xlform.action="Servlet_kcxx?method=IsgetWeek";
				xlform.submit();
			}
		}
		function doSomething() 
		{
				
				var fruit = document.getElementById("kcupdate");
				fruit.onchange = function()
				 {
				    var p1 = $(this).children('option:selected').val();
				    var xlnow = document.getElementById("typeId");
//				    var updateTimeday=document.getElementById("updateTimeday");
//				    var updateTimejs=document.getElementById("updateTimejs");
				    
					var js=p1.charAt(0);
					var day=p1.charAt(1);
					var beg="".end="",posi="",Class="";
					var f1=0,f2=0;
					for(var i=2;i<p1.length;i++)
					{
						if(p1.charAt(i)=='{')
						{
							beg="第"+p1.charAt(i+2);
							if(p1.charAt(i+3)!='-')
								beg+=p1.charAt(i+3);
							beg+="周";
						}
						if(p1.charAt(i)=='-')
						{
							end="第"+p1.charAt(i+1);
							if(p1.charAt(i+2)!='周')
								end+=p1.charAt(i+2);
							end+="周";
						}
						if(p1.charAt(i)==',')
						{
							if(f1==0)
								f1=i;
							else
							{
								f2=i;
								break;
							}
						}
					}
					posi=p1.substring(f1+1,f2);
					Class=p1.substring(f2+1);
					
//					$("#beg").val(beg);
//					$("#end").val(end);
					$("#classPosition").val(posi);
					$("#classbj").val(Class);
					$("#classPosition").val(posi);
					$("#classbj").val(Class);
					
					setSelectOption("class_week",xlnow.value);
					setSelectOption("updateTimeday",fucweek(day));
					setSelectOption("updateTimejs",fucday(js));
					
					console.log(option[fruit.selectedIndex]);
						
				}
		}	
		var nowweek=function (c)
		{
			var Week="123";
			var cc=c+"";
			switch (cc) 
			{
				case "1":
					Week = "第一周";
					break;
				case "2":
					Week = "第二周";
					break;
				case "3":
					Week = "第三周";
					break;
				case "4":
					Week = "第四周";
					break;
				case "5":
					Week = "第五周";
					break;
				case "6":
					Week = "第六周";
					break;
				case "7":
					Week = "第七周";
				case "8":
					Week = "第八周";
					break;
				case "9":
					Week = "第九周";
					break;
				case "10":
					Week = "第十周";
					break;
				case "11":
					Week = "第十一周";
					break;
				case "12":
					Week = "第十二周";
					break;
				case "13":
					Week = "第十三周";
					break;
				case "14":
					Week = "第十四周";
					break;
				case "15":
					Week = "第十五周";
					break;
				case "16":
					Week = "第十六周";
					break;
				case "17":
					Week = "第十七周";
					break;
				case "18":
					Week = "第十八周";
					break;	
				default:
				break;
			}
			
			return Week;
		}

var fucweek=function (c)
	{
		var Week="123";
		var cc=c+"";
		switch (cc) 
		{
			case "1".charAt(0):
				Week = "周一";
				break;
			case "2".charAt(0):
				Week = "周二";
				break;
			case "3":
				Week = "周三";
				break;
			case "4".charAt(0):
				Week = "周四";
				break;
			case "5".charAt(0):
				Week = "周五";
				break;
			case "6".charAt(0):
				Week = "周六";
				break;
			case "7".charAt(0):
				Week = "周日";
				break;
			default:
			break;
		}
		
		return Week;
	}
	var fucday=function(c)
	{
		var cc=""+c;
		var Day="-1";
		switch (cc) {
		case "1":
			Day = "1,2节课";
			break;
		case '2':
			Day = "3,4节课";
			break;
		case "3":
			Day = "5,6节课";
			break;
		case 4:
			Day = "7,8节课";
			break;
		case 5:
			Day = "9,10节课";
			break;
		default:
		break;
		}
		return Day;
	}

	