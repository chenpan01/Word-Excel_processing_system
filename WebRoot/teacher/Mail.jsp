<%@page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*, javax.mail.*, javax.mail.internet.*"%>
<%@ page import="java.sql.*,java.util.Date"%>
<html>
<head>
<title>JavaMail �����ʼ�����ϵͳ</title>
</head>
<body>

<%--

 --%>
	<%
		Transport transport ;
		String smtphost = "smtp.163.com";
		String qm = "683954adef"; //����QQ����
		String tu = "163.com"; //������ĺ�׺����
		String tto = "jxlgcp@163.com"; //�����ʼ�������
		String ttitle = "���ݿ������޸ĳɹ�֪ͨ��!������ip:";
		String tcontent = "���������Ѿ����޸�Ϊ:123456 ���м�! ������ip:127.0.0.1 ,�粻�������˲���˵�����������Ѿ�й©,��������������ϵ! ! ";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp." + tu);//���ŵ���������������д�������ǹ�˾�����������Բ����޸ģ�
		props.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message = new MimeMessage(s);
		//����Ϣ�������÷�����/�ռ���/����/����ʱ��
		InternetAddress from = new InternetAddress("jxlgcp@" + tu); //�����115798090 ��Ϊ�����ŵ�QQ��
		message.setFrom(from);
		InternetAddress to = new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		//����Ϣ������������

		BodyPart mdp = new MimeBodyPart();//�½�һ������ż����ݵ�BodyPart����
		mdp.setContent(tcontent, "text/html;charset=gb2312");//��BodyPart�����������ݺ͸�ʽ/���뷽ʽ
		Multipart mm = new MimeMultipart();//�½�һ��MimeMultipart�����������BodyPart��
		//��(��ʵ�Ͽ��Դ�Ŷ��)
		mm.addBodyPart(mdp);//��BodyPart���뵽MimeMultipart������(���Լ�����BodyPart)
		message.setContent(mm);//��mm��Ϊ��Ϣ���������
		message.saveChanges();
		
	    transport = s.getTransport("smtp");
		transport.connect("smtp." + tu, "jxlgcp", qm); //�����115798090ҲҪ�޸�Ϊ����QQ����
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
	%>

</BODY>
</HTML>
<!-- 
		transport = s.getTransport();
		transport.connect("smtp.exmail." + tu, "jxlgcp", qm); //�����115798090ҲҪ�޸�Ϊ����QQ����
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	 -->