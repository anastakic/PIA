/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class HashFunction {
    
    private static String bytesToHexString(byte[] encodedHash) {
        StringBuilder hashBuilder = new StringBuilder();
        for (int i = 0; i < encodedHash.length; i++) {
            String hexDigit = Integer.toHexString(0xff & encodedHash[i]);
            if (hexDigit.length() == 1) {
                hashBuilder.append('0');
            }
            hashBuilder.append(hexDigit);
        }
        return hashBuilder.toString();
    }

    public static String getHashString(String str) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            return HashFunction.bytesToHexString(encodedHash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashFunction.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}

