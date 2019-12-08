package com.bjsxt.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;
public class JavaMail {
	public static void sendmail(String content,String sub,String rec) {
		try
		{
		Transport transport;
		String smtphost = "smtp.163.com";
		String qm = "683954997adef"; // 您的邮箱密码
		String tu = "163.com"; // 你邮箱的后缀域名
		String tto = rec; // 接收邮件的邮箱
		String ttitle= sub;
		String tcontent =content;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp." + tu);// 发信的主机，这里我填写的是我们公司的主机！可以不用修改！
		props.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message = new MimeMessage(s);
		// 给消息对象设置发件人/收件人/主题/发信时间
		InternetAddress from;
		
		from = new InternetAddress("jxlgcp@" + tu);
		System.out.println("from "+from);
		message.setFrom(from);
		System.out.println("rec "+rec);
		InternetAddress to = new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);
		System.out.println("ttitle "+ttitle);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		// 给消息对象设置内容

		BodyPart mdp = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
		mdp.setContent(tcontent, "text/html;charset=gb2312");// 给BodyPart对象设置内容和格式/编码方式
		Multipart mm = new MimeMultipart();// 新建一个MimeMultipart对象用来存放BodyPart对
		// 象(事实上可以存放多个)
		mm.addBodyPart(mdp);// 将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
		message.setContent(mm);// 把mm作为消息对象的内容
		message.saveChanges();

		transport = s.getTransport("smtp");
		int index=tto.indexOf('@');
		transport.connect("smtp." + tu, tto.substring(0,index), qm); // 这里的115798090也要修改为您的QQ号码
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 这里
	}
}

/*
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;
public class JavaMail {
	public static void sendmail(String content,String sub,String rec) {
		try
		{
		Transport transport;
		String smtphost = "smtp.163.com";
		String qm = "683954adef"; // 您的QQ密码
		String tu = "163.com"; // 你邮箱的后缀域名
		String tto = "jxlgcp@163.com"; // 接收邮件的邮箱
		String ttitle= sub;
		String tcontent =content;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp." + tu);// 发信的主机，这里我填写的是我们公司的主机！可以不用修改！
		props.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message = new MimeMessage(s);
		// 给消息对象设置发件人/收件人/主题/发信时间
		InternetAddress from;
		
		from = new InternetAddress("jxlgcp@" + tu);
		message.setFrom(from);
		InternetAddress to = new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		// 给消息对象设置内容

		BodyPart mdp = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
		mdp.setContent(tcontent, "text/html;charset=gb2312");// 给BodyPart对象设置内容和格式/编码方式
		Multipart mm = new MimeMultipart();// 新建一个MimeMultipart对象用来存放BodyPart对
		// 象(事实上可以存放多个)
		mm.addBodyPart(mdp);// 将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
		message.setContent(mm);// 把mm作为消息对象的内容
		message.saveChanges();

		transport = s.getTransport("smtp");
		transport.connect("smtp." + tu, "jxlgcp", qm); // 这里的115798090也要修改为您的QQ号码
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 这里
	}
}
*/