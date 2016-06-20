/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;


/**
 *
 * @author zero_
 */
public class Password {
    
    private String encryptedPassword;
    private String username;
    
    public Password(String username, String truePassword){
        this.username = username;
        this.encryptedPassword = encryptPassword(username, truePassword);
    }   
    
    public String getDecryptedPassword(){
        return decryptPassword();
    }
    
    public String getEncryptedPassword(){
        return this.encryptedPassword;
    }
    
    public boolean checkPassword(String username, String truePassword){
        if(!this.username.equalsIgnoreCase(username)){
            return false;
        }
        if(truePassword.equals(decryptPassword())){
            return true;
        }
        return false;
    }
    
    private String encryptPassword(String username, String truePassword){
        int shift = username.length();
        
        char[] encryptedPassword = truePassword.toCharArray();
        
        for(int j = 0; j < truePassword.length(); j++){
            encryptedPassword[j] = (char)(encryptedPassword[j] + (char)shift);
        }
        
        return new String(encryptedPassword);
    }
    
    private String decryptPassword(){
        int shift = this.username.length();
        char[]aux = this.encryptedPassword.toCharArray();
        
        for(int i = 0; i < this.encryptedPassword.length(); i++){
            aux[i] = (char)(aux[i] - (char)shift);
        }
          
        String password = new String(aux);
        return password;
    }
    
}
