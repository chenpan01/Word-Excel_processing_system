package com.bjsxt.util;

public class ShowkcxxUtil {
	public static String swap_week(String cc)
	{
		String Week="";
		int num=Integer.parseInt(cc);
		switch (num) 
		{
			case 1:
				Week = "第一周";
				break;
			case 2:
				Week = "第二周";
				break;
			case 3:
				Week = "第三周";
				break;
			case 4:
				Week = "第四周";
				break;
			case 5:
				Week = "第五周";
				break;
			case 6:
				Week = "第六周";
				break;
			case 7:
				Week = "第七周";
			case 8:
				Week = "第八周";
				break;
			case 9:
				Week = "第九周";
				break;
			case 10:
				Week = "第十周";
				break;
			case 11:
				Week = "第十一周";
				break;
			case 12:
				Week = "第十二周";
				break;
			case 13:
				Week = "第十三周";
				break;
			case 14:
				Week = "第十四周";
				break;
			case 15:
				Week = "第十五周";
				break;
			case 16:
				Week = "第十六周";
				break;
			case 17:
				Week = "第十七周";
				break;
			case 18:
				Week = "第十八周";
				break;	
			default:
	}
		return Week;
	}
	public static int isDay(char day)
	{
		int ans=0;
		switch(day)
		{
			case '一':
				ans=1;
				break;
			case '二':
				ans=2;
				break;
			case '三':
				ans=3;
				break;
			case '四':
				ans=4;
				break;
			case '五':
				ans=5;
			case '六':
				ans=6;
				break;
			case '日':
				ans=7;
				break;
		}
		return ans;
	}
	public static String swap_num(char c)
	{
		String s="";
		switch(c)
		{
			case '一':
			s="1";
			break;
			case '二':
			s="2";
			break;
			case '三':
			s="3";
			break;
			case '四':
			s="4";
			break;
			case '五':
			s="5";
			break;
			case '六':
			s="6";
			break;
			case '七':
			s="7";
			break;
		}
		return s; 
	}
	public static String getWeek_zw(char c)
	{
		String s="";
		switch(c)
		{
			case '一':
			s="week1";
			break;
			case '二':
			s="week2";
			break;
			case '三':
			s="week3";
			break;
			case '四':
			s="week4";
			break;
			case '五':
			s="week5";
			break;
			case '六':
			s="week6";
			break;
			case '七':
			s="week7";
			break;
		}
		return s; 
	}
	public static String isWeek_num(char c) {
		String Week = "";
		switch (c) {
		case '1':
			Week = "week1";
			break;
		case '2':
			Week = "week2";
			break;
		case '3':
			Week = "week3";
			break;
		case '4':
			Week = "week4";
			break;
		case '5':
			Week = "week5";
			break;
		case '6':
			Week = "week6";
			break;
		case '7':
			Week = "week7";
			break;
		}
		return Week;
	}
	public static String isWeek(char c) {
		String Week = "";
		switch (c) {
		case '1':
			Week = "周一";
			break;
		case '2':
			Week = "周二";
			break;
		case '3':
			Week = "周三";
			break;
		case '4':
			Week = "周四";
			break;
		case '5':
			Week = "周五";
			break;
		case '6':
			Week = "周六";
			break;
		case '7':
			Week = "周日";
			break;
		}
		return Week;
	}
	public static String isJk(char c) {
		String Week = "";
		switch (c) {
		case '1':
			Week = "1,2节课";
			break;
		case '2':
			Week = "3,4节课";
			break;
		case '3':
			Week = "5,6节课";
			break;
		case '4':
			Week = "7,8节课";
			break;
		case '5':
			Week = "9,10节课";
			break;
		}
		return Week;
	}
}
