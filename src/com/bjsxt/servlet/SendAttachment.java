package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.File;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bjsxt.model.Attachment;
import com.bjsxt.model.AttachmentSender;

public class SendAttachment extends HttpServlet {

	
	public SendAttachment() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		response.setContentType("text/html; charset=gb2312"); 
		//response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		//set the smtp address of sina
		String host = "smtp.163.com";
		//set mailbox accountName
		String accountName = "jxlgcp";
		//set mailbox password
		String password = "683954997adef";
		//attachment
		File uploadedFile = null;
		//sender's address
		String from = "";
		//recipient's address
		String to = "";
		//mail subject
		String subject = "";
		//mail content
		String content = "";
		String tem="";
		
		//upload the attachment to the server first
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart)
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			Iterator items;
			try
			{
				items = upload.parseRequest(request).iterator();
				while(items.hasNext())
				{
					FileItem item = (FileItem) items.next();
					if(!item.isFormField())
					{
						 String name = item.getName();  
	                     String fileName = name.substring(name.lastIndexOf('/')+1,name.length());  
	                     String path = "F:/Local";  
	                        //upload the file  
	                     uploadedFile = new File(path);  
	                     item.write(uploadedFile);  
	                     System.out.println("name "+name+" fileName "+fileName+" path "+path);
					}
				 if(item.isFormField())
					{
						//get the parameter from the form
						if(item.getFieldName().equals("from"))
						{
							tem=item.getString();
							from = "jxlgcp@163.com";
						}
						else if(item.getFieldName().equals("to"))
						{
							tem=item.getString();
							to = new String(tem.getBytes("ISO-8859-1"), "gb2312");
						}
						else if(item.getFieldName().equals("subject"))
						{
							//tem=;
							subject = new String(item.getString().getBytes("ISO-8859-1"), "gb2312");
						}
						else if(item.getFieldName().equals("content"))
						{
							tem=item.getString();
							content  = new String(tem.getBytes("ISO-8859-1"), "gb2312");
//							System.out.println("content "+content);
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//set mail info  String host, String name, String password,String content, String title,String rec
		 System.out.println("to "+to+" subject "+subject+" content "+content);
		AttachmentSender sender = new AttachmentSender(host,accountName,password,content,subject,to);//String content, String title,String rec
//		sender.setFrom(from);
//		sender.setTo(to);
//		sender.setContent(content);
//		sender.setSubject(subject);
  
//		if(uploadedFile != null)
//		{
//			String attachment = request.getRealPath(uploadedFile.getName());
//			System.out.println("attachment   "+attachment);
//			
//			sender.addAttachMent(attachment);
//		}
		
		//print the result
		if(sender.send()){
			out.print("Send mail successfully!");
		}
		else{
			out.print("Send mail failed!");
		}
		request.getRequestDispatcher("jsp_stu/mail.jsp").forward(request, response);
		//delete the file on the server after send the mail
//		if(uploadedFile.exists())
//		{
//			uploadedFile.delete();
//		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
