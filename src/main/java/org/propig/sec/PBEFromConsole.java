package org.propig.sec;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PBEFromConsole {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParameterSpec;
        SecretKeyFactory keyFac;


        //salt
        byte[] salt = new SecureRandom().generateSeed(100);

        //Iteration count
        int count = 1000;

        // Create PBE parameter set
        pbeParameterSpec = new PBEParameterSpec(salt, count);

        // Prompt user for encryption password
        // Collect user password from console as char array, and convert
        // it into a SecretKey object, using a PBE key factory.
        Console console = System.console();
        char[] password = console.readPassword("Enter encryption password: ");
        pbeKeySpec = new PBEKeySpec(password);
        keyFac = SecretKeyFactory.getInstance("PBEWithHmacSHA256AndAES_256");
        SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_256");

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParameterSpec);

        // Our cleartext
        byte[] clearText = "This is another example".getBytes(StandardCharsets.UTF_8);

        byte[] cipherText = pbeCipher.doFinal(clearText);


        System.out.println("H");
    }
}
