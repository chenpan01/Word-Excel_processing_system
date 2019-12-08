package com.bjsxt.util;
import java.io.*;
import javax.servlet.jsp.*;
import jxl.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
public class DealExcel 
{
	public Connection conn=null;
	public Statement state=null;
	public PreparedStatement ps=null;
	public String filePath=null;
	public static String istype(String s)
	{
		String r="[1-9][0-9]{3}[-,/，][0-9]{1,2}[-,/，][0-9]{1,2}A[0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2}A[0-9]+[.][0-9]+A[0-9]+";
		String[] res=r.split("A");
		for(int i=0;i<res.length;i++)
		{
			if(s.matches(res[i]))
			{
				switch(i)
				{
					case 0:return "DATE";
					case 1:return "TIME";
					case 2:return "FLOAT";
					case 3:return "INT";
				}
			}
		}
		return "varchar(25)";
	}
	public  void readExcel(String filePath,String name)
	{
		Workbook wb = null; 
		int i,j;
		int kk=0;
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try {
			InputStream instr = new FileInputStream(filePath);
			wb=Workbook.getWorkbook(instr);
			Sheet sheet=wb.getSheet(0);
			int rows=sheet.getRows();
			int col=sheet.getColumns();
			for(j=2;j<rows;j++)
			{
				ArrayList<String> array=new ArrayList<String>();
				array.add(j-2+"");
				for(i=0;i<col;i++)
				{
					Cell cell=sheet.getCell(i,j);
					String ss=cell.getContents();
					if(i==0)
					{
						String sss="";
						String rex="[1-9][0-9]{3}[-,年][0-9]{1,2}[-,月][0-9]{1,2}";
						Pattern p=Pattern.compile(rex);
						Matcher m=p.matcher(ss);
						if(m.find())
						{
							sss=m.group();
//							System.out.println("sss "+sss);
						}
						array.add(sss);
					}
					else 
						array.add(ss);
				}
				array.add(" ");
				arr.add(array);
//				System.out.println("dddddddsd");
			}
			createtable(arr,rows,col+1,name);
			wb.close();
			instr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void createtable(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		String str=name;
		String sql="create table "+name+" (序号 INT PRIMARY KEY,监考时间  examTime varchar(20),班级名称 className " +
				" varchar(15),课程名称  kcName varchar(25),班级数量  classNum varchar(25),教室总人数  TotalNum varchar(25)" +
				",考试场所  ksposition varchar(25),任课老师  teacher varchar(25),考核方式  style varchar(25))";
		System.out.println("sql "+sql);
		String sql1="";
		
		Iterator<ArrayList> iter=arr.iterator(); 
		int kk=0;
		while(iter.hasNext())
		{
//			System.out.println("-------------3");
			sql1="INSERT INTO "+name+" VALUES ( ";
			ArrayList a=iter.next();
			Iterator iter1=a.iterator();
			for(int k=0;k<col-1;k++)
			{
				String s=iter1.next().toString();
				sql1+="'"+s+"',";
//				System.out.println("s "+s);
			}
			sql1+="'"+iter1.next()+"');";
			System.out.println("sql1 "+sql1);
		}
		
		try {
//			ps = conn.prepareStatement(sql);
//			ps.execute();
//			ps=conn.prepareStatement(sql1);
//			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//Link.close(conn,ps,null);
		}
	}
	public static void main(String x[])
	{
		DealExcel de=new DealExcel();
		de.readExcel("D:/tmpp/jkxx.xls","jkxx");
	}
}