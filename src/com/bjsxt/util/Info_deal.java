package com.bjsxt.util;

public class Info_deal 
{
	public static boolean isxq(int x,int y)
	{
		if(x>=2&&x<=8)
		{
			if(x==2)
			{
				if(y>=16)
					return true;
				else
					return false;
			}
			else if(x!=8)
				return true;
			if(x==8)
			{
				if(y<=19)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
			return false;
	}
	public static String cleark(String sql)
	{
		String ss="";
		char c[]=sql.toCharArray();
		for(int i=0;i<sql.length();i++)
		{
			if(c[i]!='\n')
				ss+=c[i];
		}
		return ss;
	}
}
