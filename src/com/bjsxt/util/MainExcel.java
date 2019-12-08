package com.bjsxt.util;

import java.io.*;
import javax.servlet.jsp.*;
import jxl.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
//https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&ch=6&tn=90711424_hao_pg&wd=%E4%BD%BF%E7%94%A8java%E8%AE%BF%E9%97%AEexcel%E6%96%87%E4%BB%B6&oq=%E5%A6%82%E4%BD%95%E8%AE%BE%E7%BD%AEmyeclipse%E7%9A%84%E8%83%8C%E6%99%AF%E4%B8%BA%E5%85%A8%E9%BB%91&rsv_pq=d7e405d50004ee3b&rsv_t=1469wabRxlg9rDDp2Zxlenz6ZTePV9lec8f7r7tc4lgFIHg9qnurY31v335klKI3BH4zBmeY&rqlang=cn&rsv_enter=1&inputT=121825&rsv_sug3=79&rsv_sug1=22&rsv_sug7=100&rsv_sug2=0&prefixsug=%E4%BD%BF%E7%94%A8java%E8%AE%BF%E9%97%AEexcel&rsp=0&rsv_sug4=125451
//E:\迅雷下载\QQ\3328849964\FileRecv
public class MainExcel
{
	
	public  String filePath=null;
	public CreatExcel ce=new CreatExcel();
	public MainExcel()
	{
		
	}
	public  void readExcel_kspk(String filePath,String name)
	{
		jxl.Workbook wb = null; 
		int i,j,flag=0;
		int kk=0;
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try 
		{
			InputStream instr = new FileInputStream(filePath);
			wb=Workbook.getWorkbook(instr);
			Sheet sheet=wb.getSheet(0);
			int rows=sheet.getRows();
			int col=sheet.getColumns();
			System.out.println("rows "+rows+" col "+col);
			for(j=2;j<rows;j++)
			{
				String name1="";
				Cell cell=sheet.getCell(3,j);
				name1=cell.getContents();
				if(name.equals(name1))
				{
					//System.out.println("name1 "+name1+" name "+name);
					ArrayList<String> array=new ArrayList<String>();
					for(int ii=4;ii<col;ii++)
					{
						if(ii==8)
							continue;
						cell=sheet.getCell(ii, j);
						String content=cell.getContents();
						if(content==null||"".equals(content))
							break;
						System.out.print(content+" /");
						array.add(content);
					}
					System.out.println();
					arr.add(array);
				}
			}
			ce.createtable_kspk(arr,arr.size(),10,name);
			wb.close();
			instr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void readExcel_xscj(String filePath,String name)
	{
		jxl.Workbook wb = null; 
		int i,j,flag=0;
		int kk=0;
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try 
		{
			InputStream instr = new FileInputStream(filePath);
			wb=Workbook.getWorkbook(instr);
			Sheet sheet=wb.getSheet(0);
			int rows=sheet.getRows();
			int col=sheet.getColumns();
			//System.out.println("rows "+rows+" col "+col);
			for(j=2;j<rows;j++)
			{
				String name1="",s2="",s3="";
				Cell cell=sheet.getCell(1,j);
				name1=cell.getContents();
				if(name.equals(name1))
				{
					ArrayList<String> array=new ArrayList<String>();
					for(int ii=2;ii<=10;ii++)
					{
						cell=sheet.getCell(ii, j);
						array.add(cell.getContents());
					}
					arr.add(array);
					
				}
			}
			ce.createtable_xscj(arr,arr.size(),9,name);
			wb.close();
			instr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void readExcel_xsxh(String filePath)
	{
		jxl.Workbook wb = null; 
		int i,j,flag=0;
		int kk=0;
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
	try {
		InputStream instr = new FileInputStream(filePath);
		wb=Workbook.getWorkbook(instr);
		Sheet sheet=wb.getSheet(0);
		int rows=sheet.getRows();
		int col=sheet.getColumns();
		//System.out.println("rows "+rows+" col "+col);
		for(j=1;j<rows;j++)
		{
			ArrayList<String> array=new ArrayList<String>();
			for(i=0;i<col;i++)
			{
				Cell cell=sheet.getCell(i,j);
				array.add(cell.getContents());
			}
			arr.add(array);
		}
//		System.out.println("rows "+rows+" col "+col);
		//ce.createtable_jsgh(arr,rows,col,name);
		wb.close();
		instr.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public  void readExcel_kcxx(String filePath,String Zhigh,int id)
	{
		jxl.Workbook wb = null; 
		int i,j,flag=0;
		int kk=0;
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try {
			InputStream instr = new FileInputStream(filePath);
			wb=Workbook.getWorkbook(instr);
			Sheet sheet=wb.getSheet(id);
			int rows=sheet.getRows();
			int col=sheet.getColumns();
			//System.out.println("rows "+rows+" col "+col);
			for(j=1;j<rows;j++)
			{
				String s1="",s2="",s3="";
				Cell cell=sheet.getCell(2,j);
				s1=cell.getContents();
				cell=sheet.getCell(5, j);
				s2=cell.getContents();
				cell=sheet.getCell(6, j);
				s3=cell.getContents();
				if(Zhigh.equals(s1)&&!"".equals(s2)&&!"".equals(s3))
				{
					ArrayList<String> array=new ArrayList<String>();
					cell=sheet.getCell(0, j);
					array.add(cell.getContents());
					cell=sheet.getCell(1, j);
					array.add(cell.getContents());
					cell=sheet.getCell(5, j);
					array.add(cell.getContents());
					cell=sheet.getCell(6, j);
					array.add(cell.getContents());
					arr.add(array);
					
				}
			}
			ce.createtable_kcxx(arr,arr.size(),4,Zhigh);
			wb.close();
			instr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public  void readExcel_hm(String filePath,String name,int id)
	{
			jxl.Workbook wb = null; 
			int i,j,flag=0;
			int kk=0;
			ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try {
				InputStream instr = new FileInputStream(filePath);
				wb=Workbook.getWorkbook(instr);
				Sheet sheet=wb.getSheet(id);
				int rows=sheet.getRows();
				int col=sheet.getColumns();
				//System.out.println("rows "+rows+" col "+col);
				for(j=1;j<rows;j++)
				{
					ArrayList<String> array=new ArrayList<String>();
					for(i=0;i<col;i++)
					{
						Cell cell=sheet.getCell(i,j);
						array.add(cell.getContents());
					}
					arr.add(array);
				}
	//			System.out.println("rows "+rows+" col "+col);
				ce.createtable_hm(arr,rows,col,name);
				wb.close();
				instr.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public  void readExcel_jkxx(String filePath,String Name,int id)
	{
			jxl.Workbook wb = null; 
			int i,j;
			int kk=0;
			ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		try {
			InputStream instr = new FileInputStream(filePath);
			wb=Workbook.getWorkbook(instr);
			Sheet sheet=wb.getSheet(id);
			int rows=sheet.getRows();
			int col=sheet.getColumns();
			int realrow=1;
			Cell cell=null;
			ArrayList<String> array1=new ArrayList<String>();
			for(i=0;i<col;i++)
			{
				cell=sheet.getCell(i,1);
				array1.add(cell.getContents());
			}
			arr.add(array1);
			for(j=2;j<rows;j++)
			{
				int flag=0;
				ArrayList<String> array=new ArrayList<String>();
				for(int ii=8;ii<11;ii++)
				{
					cell=sheet.getCell(ii,j);
					if(Name.equals(cell.getContents().toString()))//要从登陆界面开始
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					realrow++;
					for(i=0;i<col;i++)
					{
						cell=sheet.getCell(i,j);//8 9 10
						System.out.println();
						if(i==0&&j>1)
						{
							String sss="";
							String ss=cell.getContents();
							String rex="[1-9][0-9]{3}[-,年][0-9]{1,2}[-,月][0-9]{1,2}";
							Pattern p=Pattern.compile(rex);
							Matcher m=p.matcher(ss);
							if(m.find())
								sss=m.group();//
							//System.out.println("sss "+sss);
							kk++;
							array.add(sss);
						}
						else
							array.add(cell.getContents());
					}
					arr.add(array);
				}
			}
//			System.out.println("realrow "+realrow);
			ce.createtable_jkxx(arr, realrow,col, Name);
			wb.close();
			instr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
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
		return "varchar(20)";
	}
	

}


/*
CREATE TABLE `test`.`xybh` (
  `ѧԺ���` INT NOT NULL COMMENT '',
  `ѧԺ(У��)���` VARCHAR(15) NULL COMMENT '',
  `ѧԺ(У��)���` VARCHAR(15) NULL COMMENT '',
  PRIMARY KEY (`ѧԺ���`)  COMMENT '');

*/
 