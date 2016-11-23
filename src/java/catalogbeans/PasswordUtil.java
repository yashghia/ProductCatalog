package catalogbeans;


import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class PasswordUtil {
   public static String saltx;
    public static String hashPassword(String password){
        
         StringBuilder sb=null;
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(password.getBytes());
            byte[] mdArray=md.digest();
           sb=new StringBuilder(mdArray.length*2);
            for(byte b:mdArray){
            int v=b&0xff;
            if(v<16){
                   sb.append('0');
                   sb.append(Integer.toHexString(v));
            }
             
            }
           
        }catch(Exception e){
            e.printStackTrace();
        }
         return sb.toString();
    }
    public static String getSalt(){
      
        Random r=new SecureRandom();
       byte saltBytes[]=new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
       }
    
    
    
    public static String hashAndSaltPassword(String password){
    String salt=getSalt();
    saltx=salt;
    return hashPassword(password+salt);
       
    }
    
    
     public static String chkHashAndSaltPassword(String password,String salt){
 
    return hashPassword(password+salt);
       
    }
     
     
    
     public static void main(String s[])
    {
      System.out.println(PasswordUtil.hashAndSaltPassword("hello"));
    }
}
