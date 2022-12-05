package com.example.springsecurity.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Generates a random number used as an OTP
 */
public final class GenerateCodeUtil {

    private GenerateCodeUtil() {}

    public static String generateCode() {
        String code;
        try {
            // create an instance of SecureRandom that generates a random int value
            SecureRandom random = SecureRandom.getInstanceStrong();

            // generate a value between 0 and 8,999. We add 1,000 to each generated value.
            // This way, we get values between 1,000 and 9,999 (4-digit random codes).
            int c = random.nextInt(9000) + 1000;

            // convert the int to a String and returns it
            code = String.valueOf(c);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Problem when generating the random code.");
        }
        return code;
    }
}
