package com.bjsxt.model;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class AttachmentSender {
	private MimeMessage message;
	private Properties props;
	private Session session;
	private MimeMultipart mp;
	private String name = "";
	private String password = "";
	private Multipart mm ;
	private String host="";
	private String content;
	private String title;
	private String rec;
	/**
	 * complete the initialization
	 * @param host
	 * @param name
	 * @param password
	 */
	public AttachmentSender(String host, String name, String password,String content, String title,String rec)
	{
		this.name = name;
		this.password = password;
		this.host=host;
		this.content=content;
		this.title=title;
		this.rec=rec;
	}
	public void addAttachMent(String filename)
	{
		try{
			mp = new MimeMultipart();
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			DataHandler handler=new DataHandler(fileds); 
			bp.setDataHandler(handler);//
			System.out.println("fileds.getName() "+fileds.getName());
			bp.setFileName(fileds.getName());
			mp.addBodyPart(bp);
//			  bodyPart=new MimeBodyPart();  
//          FileDataSource fds=new FileDataSource(attachFile); //得到数据源  
//          bodyPart.setDataHandler(new DataHandler(fds)); //得到附件本身并放入BodyPart  
//          bodyPart.setFileName(MimeUtility.encodeText(fds.getName()));  //得到文件名并编码（防止中文文件名乱码）同样放入BodyPart  
//          multiPart.addBodyPart(bodyPart);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean send()
	{
		try 
		{
			Transport transport ;
			String smtphost = "smtp.163.com";
			String qm = "683954adef"; //您的QQ密码
			String tu = "163.com"; //你邮箱的后缀域名
			String tto = rec; //接收邮件的邮箱
			String ttitle = title;
			String tcontent = content;
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp." + tu);//发信的主机，这里我填写的是我们公司的主机！可以不用修改！
			props.put("mail.smtp.auth", "true");
			Session s = Session.getInstance(props);
			s.setDebug(true);
			MimeMessage message = new MimeMessage(s);
			//给消息对象设置发件人/收件人/主题/发信时间
			InternetAddress from = new InternetAddress("jxlgcp@" + tu); //这里的115798090 改为您发信的QQ号
				message.setFrom(from);
				System.out.println("tto "+tto);
			InternetAddress to = new InternetAddress(tto);
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(ttitle);
			message.setSentDate(new Date());
			//给消息对象设置内容
	
			BodyPart mdp = new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
			mdp.setContent(tcontent, "text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
			Multipart mm = new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
			//象(事实上可以存放多个)
			mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
			message.setContent(mm);//把mm作为消息对象的内容
			message.saveChanges();
			
		    transport = s.getTransport("smtp");
			transport.connect("smtp." + tu, "jxlgcp", qm); //这里的115798090也要修改为您的QQ号码
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

}



/*
props = new Properties();
		//set the SMTP host
		props.put("mail.smtp.host", host);
		//set SMTP authorization
		props.put("mail.smtp.auth", "true");
		//get the mail session
		MyAuthenticator auth = new MyAuthenticator(name,password);
		session = Session.getInstance(props);
		session.setDebug(true);
		//create MIME mail object
		message = new MimeMessage(session);
		mp = new MimeMultipart();
		
		
		
		
public void setFrom(String from){
	try {
		message.setFrom(new InternetAddress(from));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void setTo(String to){
	try {
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void setSubject(String subject){
	try {
		message.setSubject(subject);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void setContent(String content){
	try{
		BodyPart bp = new MimeBodyPart();
		bp.setContent(content,"text/html");
		mp.addBodyPart(bp);
	}catch(Exception e){
		e.printStackTrace();
	}
}





public boolean send(){
	try{
		message.setContent(mp);
		message.saveChanges();
		//create SMTP sender object
		Transport transport = session.getTransport("smtp");
		//get the connection with server
		System.out.println("name "+name+" password "+password);
		transport.connect("smtp.163.com",name,password);
		//send the mail via server
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
		return true;
	}catch(NoSuchProviderException e){
		e.printStackTrace();
		return false;
	}catch (MessagingException e){
		e.printStackTrace();
		return false;
	}
}
*/