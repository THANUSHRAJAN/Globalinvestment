package mail;
import java.util.Properties;    
	import javax.mail.*;    
	import javax.mail.internet.*;   
public class mail1 {
	 
	  
	    public static boolean send(final String from,final String password,String to,String sub,String msg){  
	          //Get properties object    
	         
	    	
	    	boolean log = false;
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",  
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");    
	          //get Session   
	          Session session = Session.getDefaultInstance(props,    
	           new javax.mail.Authenticator() {    
	           protected PasswordAuthentication getPasswordAuthentication() {    
	           return new PasswordAuthentication(from,password);  
	           }    
	          });


	          //compose message  


	          try {    
	           MimeMessage message = new MimeMessage(session);    
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	           message.setSubject(sub);    
	           message.setText(msg); 


	           //send message  
	           Transport.send(message);    
	           System.out.println("message sent successfully");
	           log=true;
	          } catch (MessagingException e) {throw new RuntimeException(e);}    

	          
return log;
	    } 
	 public static boolean mail(String mail,String password) {    
	     //from,password,to,subject,message  
	 boolean s=send("mailjavasend@gmail.com","qgic bvzn rmce mzyl",mail,"Alert by ambulance",password);  
	     //change from, password and to  
	 return s;
	 }   
	 
	  
	 public static void logmail(String mail,String password) {    
	     //from,password,to,subject,message  
	 send("mailjavasend@gmail.com","qgic bvzn rmce mzyl",mail,"One Time Password",password);  
	     //change from, password and to  
	 }  
	 public static void main(String []args) {    
	     //from,password,to,subject,message  
	 send("mailjavasend@gmail.com","qgic bvzn rmce mzyl","embeddedspiro2021@gmail.com","One Time Password","password");  
	     //change from, password and to  
	 }
	}    

