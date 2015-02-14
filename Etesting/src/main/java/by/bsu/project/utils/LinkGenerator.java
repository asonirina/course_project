package by.bsu.project.utils;

import org.apache.commons.lang.RandomStringUtils;

/**
 * User: iason
 * Date: 13.02.15
 */
public class LinkGenerator {
    public static String getResetPasswordURL(String baseURL, String email) {
        return baseURL + "/ResetPassword.html?hash=" + generateHash() + "&email=" + email;
    }

    public static boolean checkHash(String hash) {
        if(hash ==null) {
            return false;
        }
        int length = hash.length();
        if(length!=20) {
            return false;
        }
        int checkDigit = checkDigit(hash.substring(0, length - 1));
        return hash.substring(length - 1, length).equals(String.valueOf(checkDigit));
    }

    private static String generateHash() {
        String hash = RandomStringUtils.randomAlphanumeric(19);
        String lastChar = String.valueOf(checkDigit(hash));
        return hash + lastChar;
    }

    private static int checkDigit(String s) {
        byte bytes[] = s.getBytes();
        int checkDigit = 0;
        for (int i = 0; i < bytes.length; i++) {
            checkDigit += (i + 1) * bytes[i];
        }
        return checkDigit % 10;
    }
}
