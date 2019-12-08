package com.bjsxt.util;

import java.sql.*;
import java.util.*;

public class CreatExcel 
{
	
	public String filePath=null;
	public Connection conn=null;
	public PreparedStatement ps=null;
	public CreatExcel()
	{
		
	}
	public  void createtable_kspk(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		int i,k;
		String sql="create table kspk (";
		String[][] title=new String[rows][col];
		String[] entry=new String[col];
		//▼姓名	课程名称	学分	课程性质	考试时间	任课教师	开课学院	校区	考试地点	备注

		String Sj_type[]={"kcmc","score","kcxz","kssj","teacher","xueyuan","xq","ksdd","bz"};
		String sql1="";
		Iterator<ArrayList> iter=arr.iterator();
		for(i=0;iter.hasNext();i++)
		{
			ArrayList a=iter.next();
			Iterator<String> iter1=a.iterator();
			for( k=0;iter1.hasNext();k++)
			{
				title[i][k]=iter1.next();
//				System.out.print(+" ");
			}
//			System.out.println();
		}
		try 
		{
			String sql_drop="DROP TABLE IF EXISTS `kspk`;";
			conn=DBUtils.createConn();
			ps=conn.prepareStatement(sql_drop);
			ps.execute();//删除数据库
			
			for(int ii=0;ii<Sj_type.length;ii++)
			{
				if("kssj".equals(Sj_type[ii]))
				{
					sql+=Sj_type[ii]+" varchar(50),";
					continue;
				}
				if(ii==Sj_type.length-1)
					sql+=Sj_type[ii]+" varchar(20));";
				else
					sql+=Sj_type[ii]+" varchar(20),";
			}
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);
			ps.execute();
			
			for(i=0;i<rows;i++)
			{
				sql1="insert into kspk"+"(";
				//String sql2=new String((sql1.getBytes("ISO-8859-1")),"GBK");
				for(int jj=0;jj<Sj_type.length;jj++)
				{
					if(!"".equals(title[i][jj])&&title[i][jj]!=null)
					{
							sql1+=Sj_type[jj];
							if(jj!=Sj_type.length-1)
								sql1+=",";
					}
				}
				if(sql1.charAt(sql1.length()-1)==',')
					sql1=sql1.substring(0,sql1.length()-1);
				sql1+=")values(";
				for(int jj=0;jj<Sj_type.length;jj++)
				{
					if(!"".equals(title[i][jj])&&title[i][jj]!=null)
					{
						sql1+="'"+title[i][jj]+"',";
					}
				}
				if(sql1.charAt(sql1.length()-1)==',')
					sql1=sql1.substring(0,sql1.length()-1);
				sql1+=");";
				System.out.println(sql1);
				ps = conn.prepareStatement(sql1);
				ps.execute();
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, null, ps);
		}
	}
	public  void createtable_xscj(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		int i,k;
		String sql="create table xscj (";
		String[][] title=new String[rows][col];
		String[] entry=new String[col];
		String Sj_type[]={"kcmc","sore","note","zscj","pkcj","pknote","cxcj","jdsore","kcxz"};
		String sql1="";
		Iterator<ArrayList> iter=arr.iterator();
		for(i=0;iter.hasNext();i++)
		{
			ArrayList a=iter.next();
			Iterator<String> iter1=a.iterator();
			for( k=0;iter1.hasNext();k++)
			{
				title[i][k]=iter1.next();
			}
		}
		try 
		{
			String sql_drop="DROP TABLE IF EXISTS `xscj`;";
			conn=DBUtils.createConn();
			ps=conn.prepareStatement(sql_drop);
			ps.execute();//删除数据库
			for(int ii=0;ii<Sj_type.length;ii++)
			{
				if(ii==Sj_type.length-1)
					sql+=Sj_type[ii]+" varchar(20));";
				else
					sql+=Sj_type[ii]+" varchar(20),";
			}
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);
			ps.execute();
			
			for(i=0;i<rows;i++)
			{
				sql1="insert into xscj"+"(";
				//String sql2=new String((sql1.getBytes("ISO-8859-1")),"GBK");
				for(int jj=0;jj<Sj_type.length;jj++)
				{
					if(!"".equals(title[i][jj])&&title[i][jj]!=null)
					{
						if(jj!=Sj_type.length-1)
							sql1+=Sj_type[jj]+",";
						else
							sql1+=Sj_type[jj]+"";
					}
					
				}
				if(sql1.charAt(sql1.length()-1)==',')
					sql1=sql1.substring(0,sql1.length()-1);
				sql1+=")values(";
				for(int jj=0;jj<title[0].length;jj++)
				{
					if(!"".equals(title[i][jj])&&title[i][jj]!=null)
					{
						sql1+="'"+title[i][jj]+"',";
					}
				}
				if(sql1.charAt(sql1.length()-1)==',')
					sql1=sql1.substring(0,sql1.length()-1);
				sql1+=");";
				ps = conn.prepareStatement(sql1);
				ps.execute();
				
				System.out.println(sql1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, null, ps);
		}
	}
	public void create_all(ArrayList<ArrayList> arr,int cir,int rows,int col,int dou)
	{
		String sql_drop="";
		String name="";
		try 
		{
			conn=DBUtils.createConn();
			for(int bs=1;bs<cir;bs++)
			{	
				if(cir==2)
				{
					sql_drop="DROP TABLE IF EXISTS `kcxx`;";
				}
				else
				{
					sql_drop="DROP TABLE IF EXISTS `kcxx" +bs+"`;";
					name=bs+"";
				}
//				System.out.println("sql_drop "+sql_drop);
				String sql_c="create table kcxx"+name+" (id int primary key,time char(10),week1 char(60) ,week2 char(60),week3 char(60) ,week4 char(60),week5 char(60),week6 char(60),week7 char(60));";
//				System.out.println("sql_c "+sql_c);
				String[][] tem=new String[rows+1][col+1];
				String Time[]={"1,2节","3,4节","5,6节","7,8节","9,10节"};
				String[][] in_sql=new String[6][7];
				for(int i=0;i<6;i++)
				{
					for(int j=0;j<7;j++)
						in_sql[i][j]=" ";
				}
				ps=DBUtils.getPs(conn, sql_drop);
				ps.execute();//新建数据库
				ps=DBUtils.getPs(conn, sql_c);
				ps.execute();//新建数据库
				Iterator<ArrayList> iter1=arr.iterator();
				int i=0,j=0;
				for(;iter1.hasNext();i++)
				{
					ArrayList a=iter1.next();
					Iterator<String> iter2=a.iterator();
					for(j=0;iter2.hasNext();j++)
					{
						tem[i][j]=iter2.next();
					}
				}			
				for(i=0;i<rows;i++)
				{
					String time[]=tem[i][2].split(";");
//					System.out.println("time "+time[0]);
					int fir=time[0].indexOf('{');
					int end=time[0].indexOf('}');
					int mid=time[0].indexOf('-');
					
					int fweek=Integer.parseInt(time[0].substring(fir+2,mid));
					int eweek=Integer.parseInt(time[0].substring(mid+1,end-1));//不含后面的
					if(fweek<=bs&&eweek>=bs);
					else
					{
						if(dou==1)
							break;
					}
					String position[]=tem[i][3].split(";");
					int t_i=0,t_j=0;
					for(int ii=0;ii<time.length;ii++)
					{
						String content=tem[i][1];
						content+=time[ii].substring(7)+",";
						content+=position[0]+","+tem[i][0]; 
						t_j=ShowkcxxUtil.isDay(time[ii].charAt(1));
						t_i=Integer.parseInt(time[ii].charAt(3)+"");
						in_sql[t_i/2][t_j]=content;
					}
				}
				for(i=0;i<5;i++)
				{
					int ii=i+1;
					String sql="insert into kcxx"+name+" values('"+ii+"','"+Time[i]+"',";
					for(j=0;j<7;j++)
					{
						if(!"".equals(in_sql[i][j]))
						{
							if(j!=6)
								sql+="'"+in_sql[i][j]+"',";
							else
								sql+="'"+in_sql[i][j]+"')";
						}
						else
						{
							if(j!=6)
								sql+=" "+",";
							else
								sql+=" "+")";
						}
					}
					ps=conn.prepareStatement(sql);
					ps.execute();//新建数据库
					if(cir==2)
						System.out.println("CreatExcel sql  "+sql);
				}
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(dou==1)
				DBUtils.close(conn,null,ps);
		}
	}
	
	public  void createtable_kcxx(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		try 
		{
			create_all(arr,2,rows,col,0);
			create_all(arr,17,rows,col,1);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
				DBUtils.close(conn,null,ps);
		}
	}
	
	public  void createtable_hm(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		Link link=new Link();
		try 
		{
			String sql_drop="DROP TABLE IF EXISTS `"+name+"`;";
			String sql_c="create table "+name+"(id int primary key,name char(40) unique);";
			String[][] tem=new String[10000][2];
			conn=DBUtils.createConn();
		    ps=conn.prepareStatement(sql_drop);
			ps.execute();//新建数据库
			ps=conn.prepareStatement(sql_c);
			ps.execute();//新建数据库
			Iterator<ArrayList> iter1=arr.iterator();
			int i=0;
			while(iter1.hasNext())
			{
				ArrayList a=iter1.next();
				Iterator<String> iter2=a.iterator();
				tem[i][0]=iter2.next();
				tem[i][1]=iter2.next();
				i++;
			}
			String sql_in="";
			sql_in="insert into "+name+"(id,name) values";
			for(int i1=0;i1<rows-1;i1++)
			{
				if(i1!=rows-2)
					sql_in+="('"+tem[i1][1]+"',"+"'"+tem[i1][0]+"'),";
				else
					sql_in+="('"+tem[i1][1]+"',"+"'"+tem[i1][0]+"');";
				if("".equals(tem[i1][1])||tem[i1][1]==null)
				{
					break;
				}
			}
			System.out.println("sql_in  "+sql_in);
			ps=DBUtils.getPs(conn, sql_in);
			ps.execute();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn,null,ps);
		}
	}
	public  void createtable_jkxx(ArrayList<ArrayList> arr,int rows,int col,String name)
	{
		int i,k;
		String str=name;
		String sql="create table jkxx (id int PRIMARY KEY,";
		String[][] title=new String[rows][col];
		String[] entry=new String[col];
		String Sj_type[]={"KsTime","KcName","ClassName","ClassNum","Similar","Position","Posi_num","Supervisor"
				,"jk1","jk2","jk3","jk4","Tea_teacher","kh_Style"};
		String[] type=new String[Sj_type.length];
		String sql1=null;
		Iterator<ArrayList> iter=arr.iterator();
		//System.out.println("arr.size()  "+arr.size());
		//sob(rows);
		for(i=0;iter.hasNext();i++)
		{
			ArrayList a=iter.next();
			Iterator<String> iter1=a.iterator();
			for( k=0;iter1.hasNext();k++)
			{
				title[i][k]=iter1.next();
				if(i==0)
					entry[k]=Info_deal.cleark(title[i][k]);
			}
		}
		try 
		{
			String sql_drop="DROP TABLE IF EXISTS `jkxx`;";
			conn=DBUtils.createConn();
			ps=conn.prepareStatement(sql_drop);
			ps.execute();//删除数据库
			for(i=0;i<Sj_type.length;i++)
			{
				type[i]=MainExcel.istype(Sj_type[i]);
			}
			for(int ii=0;ii<Sj_type.length;ii++)
			{
				if(ii==Sj_type.length-1)
					sql+=Sj_type[ii]+" "+type[ii]+",Note varchar(20));";
				else
					sql+=Sj_type[ii]+" "+type[ii]+",";
			}
			String sql_1="";
			sql_1=Info_deal.cleark(sql);
			System.out.println(sql_1);
			
			ps = conn.prepareStatement(sql_1);
			ps.execute();
			//link.close(conn,ps,null);
			
			for(i=1;i<rows;i++)
			{
				sql1="insert into "+"jkxx"+"(id,";
				//String sql2=new String((sql1.getBytes("ISO-8859-1")),"GBK");
				for(int jj=0;jj<Sj_type.length;jj++)
				{
					if(!"".equals(title[i][jj]))
						 sql1+=Sj_type[jj]+",";
				}
				sql1+="Note)values("+i+",";
				for(int jj=0;jj<title[0].length;jj++)
				{
					if(!"".equals(title[i][jj]))
					{
						sql1+="'"+title[i][jj]+"',";
					}
				}
				sql1+="' '"+");";
				ps = conn.prepareStatement(sql1);
				ps.execute();
				
				System.out.println(sql1);
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn,null,ps);
		}
	}
}
