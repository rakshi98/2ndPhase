package com.virtusa.trainingmanagementsystem;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mail 
{

	public static void sendEmail(Session session, String toEmail, String subject, String body)
	{
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("kavithabadiger505@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("kavithabadiger505@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.gmail.com";
	    String to = "kavithabadiger505@gmail.com";
	    
	    final String username="Kavitha Badiger";
	    final String password="**********";
	    
	    Properties props = new Properties();
	    
	    props.put("mail.smtp.auth","true");
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.host",smtpHostServer);
	   props.put("mail.smtp.port","587");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator() 
	    {
	    	protected PasswordAuthentication getPasswordAuthentication()
	    	{
	    		return new PasswordAuthentication(username,password);
	    	}
	    });
	    
	    sendEmail(session, to,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}
	
}

