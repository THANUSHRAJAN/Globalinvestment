package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class testmail {
	  public static void send(final String from,final String password,String to,String sub,String msg){  
          //Get properties object    
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
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    } 
 public static void mail(String mail,String password) {    
     //from,password,to,subject,message  
 send("mailjavasend@gmail.com","qgic bvzn rmce mzyl",mail,"One Time Password",password);  
     //change from, password and to  
 }   
 public static void logmail(String mail,String password) {    
     //from,password,to,subject,message  
 send("mailjavasend@gmail.com","qgic bvzn rmce mzyl",mail,"One Time Password",password);  
     //change from, password and to  

 
 
}   



public static void main  (String args [] ) {

String gma="mailjavasend@gmail.com";
String random="66456";
  mail( gma,"Hello "+ gma+", your current password is "+random+",.");
	


}




}    

