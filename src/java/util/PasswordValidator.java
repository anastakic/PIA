/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ana
 */
public class PasswordValidator {

    public static boolean valid(String password) {
        char[] pass = password.toCharArray();
        char[] specials = {'#', '*', '.', '!', '?', '$', '"', '^', '+', '-', ':', ';', 
            '<', '>', '/', '(', ')', '[', ']', '{', '}', '@', ':', ';', ',', '~', '=',
            '%', '_', '&', '£'};
        if (pass.length < 8 || pass.length > 12) {
            return false;
        }
        if (!(Character.isAlphabetic(pass[0]))){
//                isLowerCase(pass[0]) || Character.isUpperCase(pass[0]))) {
            return false;
        }
        for (int i = 2; i < pass.length; i++) {
            if (pass[i] == pass[i - 1] && pass[i - 1] == pass[i - 2]) {
                return false;
            }
        }
        int specialCount = 0;
        int digitCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        for (int i = 0; i < pass.length; i++) {
            if (Character.isLowerCase(pass[i])) {
                lowerCount++;
            }
            if (Character.isUpperCase(pass[i])) {
                upperCount++;
            }
            if (Character.isDigit(pass[i])) {
                digitCount++;
            }
            for (int j = 0; j < specials.length; j++) {
                if (pass[i] == specials[j]) {
                    specialCount++;
                    break;
                }
            }
        }
        if (lowerCount < 3 || upperCount < 1 || digitCount < 1 || specialCount < 1) {
            return false;
        }
        return true;
    }

}


