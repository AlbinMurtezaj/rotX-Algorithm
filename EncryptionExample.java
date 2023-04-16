import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionExample {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String ROT15_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String message, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
     public static String rot15Encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (ROT15_ALPHABET.indexOf(c) >= 0) {
                int index = (ROT15_ALPHABET.indexOf(c) + 15) % ROT15_ALPHABET.length();
                result.append(ROT15_ALPHABET.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String rot15Decrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            if (ROT15_ALPHABET.indexOf(c) >= 0) {
                int index = (ROT15_ALPHABET.indexOf(c) - 15 + ROT15_ALPHABET.length()) % ROT15_ALPHABET.length();
                result.append(ROT15_ALPHABET.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    
    
     public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vendose tekstin: ");
        String message = scanner.nextLine();
        System.out.print("Vendose çelsin: ");
        String secretKey = scanner.nextLine();

        // Enkriptimi simetrik
        String encryptedMessage = encrypt(message, secretKey);
        System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);

        // ne qofte se perdoruesi pergjigjet me po, athere mesazhi i enkriptuar, dekriptohet dhe shfaqet
        while (true) {
            System.out.print("A deshiron qe te shfaqet mesazhi i dekriptuar: (P/J): ");
            String choice = scanner.nextLine();

            // kontrollon neser perdoruese e shtyp "P" ose "J"
            if (choice.equalsIgnoreCase("P")) {
                String decryptedMessage = decrypt(encryptedMessage, secretKey);
                System.out.println("Mesazhi i dekriptuar: " + decryptedMessage);
                break; // del nga loop-a nese e shtypa vlera valide
            } else if (choice.equalsIgnoreCase("J")) {
                break; // del nga loop-a nese e shtypa vlera valide
            } else {
                System.out.println("Opsioni i zgjedhur nuk eshte valid. Ju lutem provoni perseri me P ose J.");
            }
        }
         
        //cakton sa do te jete rotacioni 
        System.out.print("Vendose sa deshironi te jete rotacioni X=");
        int rotX = Integer.parseInt(scanner.nextLine());
        //Enkriptimi rotX
        String encryptedMessageRotX = rotXEncrypt(message);
        System.out.println("Mesazhi enkriptuar me ROT" + rotX + ": " + encryptedMessageRotX);

        String decryptedMessageRotX = rotXDecrypt(encryptedMessageRotX);
        System.out.println("Mesazhi denkriptuar me ROT" + rotX + ": " + decryptedMessageRotX);


        scanner.close();
    }
}


