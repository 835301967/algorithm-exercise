package security;

/**
 * @Author yuxiangjin
 * @Date 2023/7/5 11:19
 **/
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSADemo {

    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPair keyPair = generateKeyPair();

        // Encrypt and decrypt a message
        String originalMessage = "Hello, RSA!";
        PublicKey aPublic = keyPair.getPublic();
        byte[] encryptedMessage = encrypt(originalMessage, aPublic);
        PrivateKey aPrivate = keyPair.getPrivate();
        String decryptedMessage = decrypt(encryptedMessage, aPrivate);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encryptedMessage));
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    public static KeyPair generateKeyPair() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
