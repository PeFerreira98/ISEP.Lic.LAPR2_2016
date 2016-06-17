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
    
    public String encriptPassword(String username, String truePassword){
        int shift = username.length();
        String criptedPassword = truePassword;
        
        System.out.println(criptedPassword);
        
        for (int i = 32; i < 126-shift; i++) {
            criptedPassword.replace( (char)(i), (char)(i+shift));
        }
        
        System.out.println(criptedPassword);
        
        return criptedPassword;
    }
    
}
