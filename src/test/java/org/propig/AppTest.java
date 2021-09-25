package org.propig;

import static org.junit.Assert.assertTrue;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void signObjectTest() throws NoSuchAlgorithmException,
            IOException, SignatureException, InvalidKeyException {
        // 对象签名
        byte[] data = "Data Signature".getBytes(StandardCharsets.UTF_8);
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        Signature signature = Signature.getInstance(keyPairGen.getAlgorithm());

        SignedObject signedObject = new SignedObject(data, keyPair.getPrivate(), signature);

        Assert.assertTrue(signedObject.verify(keyPair.getPublic(),signature));
    }

    @Test
    public void signMessageTest() throws
            NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 消息签名
        byte[] signData = "Data Signature".getBytes();
        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator2.initialize(1024);
        KeyPair keyPair2 = keyPairGenerator2.generateKeyPair();
        Signature signature = Signature.getInstance(keyPairGenerator2.getAlgorithm());
        signature.initSign(keyPair2.getPrivate());
        signature.update(signData);

        byte[] sign = signature.sign();

        signature.initVerify(keyPair2.getPublic());
        signature.update(signData);
        Assert.assertTrue(signature.verify(sign));
    }


    @Test
    public void digestMessageTest() throws NoSuchAlgorithmException {

        // JDK SHA1
        byte[] input = "SHA".getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(input);
        byte[] output = sha.digest();


        // Bouncy Castle SHA1
        Digest bcSha1 = new SHA1Digest();
        bcSha1.update(input, 0, input.length);
        byte[] bcOutput = new byte[bcSha1.getDigestSize()];
        bcSha1.doFinal(bcOutput, 0);

        Assert.assertTrue(Arrays.equals(output, bcOutput));
    }

    @Test
    public void hmacMd5Test() throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] input = "MAC".getBytes(StandardCharsets.UTF_8);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] output = mac.doFinal(input);
    }

    @Test
    public void desCipherTest() throws
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IOException {
        // DES加密与解密
        File file = new File("secret");
        if(file.exists()){
            file.delete();
        }
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey secretKey = kg.generateKey();
        byte[] key = secretKey.getEncoded();
        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String input = "1234567890";
        CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(file), cipher);

        DataOutputStream dos = new DataOutputStream(cos);
        dos.writeUTF(input);
        dos.flush();
        dos.close();

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        CipherInputStream cis = new CipherInputStream(new FileInputStream(file), cipher);
        DataInputStream dis = new DataInputStream(cis);
        String output = dis.readUTF();
        dis.close();

        Assert.assertTrue(input.equals(output));

    }

    @Test
    public void secretKeySpecTest() throws NoSuchAlgorithmException {

        KeyGenerator kg2 = KeyGenerator.getInstance("DESede");
        SecretKey secretKey3 = kg2.generateKey();
        byte[] key3 = secretKey3.getEncoded();


        KeyGenerator kg = KeyGenerator.getInstance("RC2");
        SecretKey secretKey = kg.generateKey();
        byte[] key = secretKey.getEncoded();

        SecretKey secretKey2 = new SecretKeySpec(key, "RC2");
        byte[] key2 = secretKey2.getEncoded();
        Assert.assertTrue(Arrays.equals(key, key2));

    }

    @Test
    public void findCert() throws IOException, KeyStoreException,
            CertificateException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream("D:\\Oracle\\Temp\\keystore.jks");
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(fis, "engine".toCharArray());

        X509Certificate x509Certificate = (X509Certificate)ks.getCertificate("mydomain");
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());

        System.out.println(x509Certificate.getSigAlgName());
        fis.close();
    }

    @Test
    public void aesGenerateTest() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(256);
        SecretKey secretKey = kg.generateKey();
        byte[] key = secretKey.getEncoded();

        System.out.println(key);
    }
}
