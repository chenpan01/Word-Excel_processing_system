package com.bjsxt.model;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Attachment 
{
	private MimeMessage message;
	private Properties props;
	private Session session;
	private MimeMultipart mp;
	private String name = "";
	private String password = "";

	/**
	 * complete the initialization
	 * @param host
	 * @param name
	 * @param password
	 */
	public Attachment(String host, String name, String password){
		this.name = name;
		this.password = password;
		props = System.getProperties();
		//set the SMTP host
		props.put("mail.smtp.host", host);
		//set SMTP authorization
		props.put("mail.smtp.auth", "true");
		//get the mail session
		MyAuthenticator auth = new MyAuthenticator(name,password);
		session = Session.getDefaultInstance(props,auth);
		//create MIME mail object
		message = new MimeMessage(session);
		mp = new MimeMultipart();
	}
	
	/**
	 * set mail sender
	 * @param from
	 */
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
	
	/**
	 * set mail recipient
	 * @param to
	 */
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
	
	/**
	 * set mail subject
	 * @param subject
	 */
	public void setSubject(String subject){
		try {
			message.setSubject(subject);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * set the mail content
	 * @param content
	 */
	public void setContent(String content){
		try{
			BodyPart bp = new MimeBodyPart();
			bp.setContent(content,"text/html");
			mp.addBodyPart(bp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * attach the file
	 * @param filename
	 */
	public void addAttachMent(String filename){
		try{
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());
			mp.addBodyPart(bp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * send mail
	 * @return
	 */
	public boolean send()
	{
		try
		{
			message.setContent(mp);
			message.saveChanges();
			//create SMTP sender object
			Transport transport = session.getTransport("smtp");
			//get the connection with server
			transport.connect("smtp.163.com","jxlgcp",password);
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
}

