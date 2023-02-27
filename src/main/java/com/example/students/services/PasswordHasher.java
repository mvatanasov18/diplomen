package com.example.students.services;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
@Service
public class PasswordHasher {
    private static final SecureRandom random = new SecureRandom();
private static final byte[] salt = new byte[16];
private static  int called=0;

    public static String hashPassword(String password){
        try{
            if(called==0){
                random.nextBytes(salt);
                called++;
            }
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            password= "";
            for(Byte nz:factory.generateSecret(spec).getEncoded()){
                password=password.concat(nz.toString());
            }
            return password;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
