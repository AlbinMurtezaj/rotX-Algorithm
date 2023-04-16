import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class EncryptionExample {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String ROTX_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String message, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String encryptedMessage, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, "UTF-8");
    }
    public static String rotXEncrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (ROTX_ALPHABET.indexOf(c) >= 0) {
                int index = (ROTX_ALPHABET.indexOf(c) + 15) % ROTX_ALPHABET.length();
                result.append(ROTX_ALPHABET.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static String rotXDecrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            if (ROTX_ALPHABET.indexOf(c) >= 0) {
                int index = (ROTX_ALPHABET.indexOf(c) - 15 + ROTX_ALPHABET.length()) % ROTX_ALPHABET.length();
                result.append(ROTX_ALPHABET.charAt(index));
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
        String secretKey;
        while(true) {
            System.out.print("Vendose gjatësine e çelesit(16, 24 ose 32 bajt :");
            secretKey=(scanner.nextLine());
            if(secretKey.length()== 16 || secretKey.length() == 24 || secretKey.length() == 32) {
                break;
            }
            System.out.println("Gjatesia e çelesit nuk eshte e sakte. Ju lutem provoni perseri!");
        }


        // Enkriptimi simetrik
        String encryptedMessage = encrypt(message, secretKey);
        System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);
        // ne qofte se perdoruesi pergjigjet me po, atehere mesazhi i enkriptuar, dekriptohet pastaj shfaqet
        while (true) {
            System.out.print("A deshiron qe te shfaqet mesazhi i dekriptuar? (P/J): ");
            String choice = scanner.nextLine();
            // kontrollon nese perdoruesi e shtype "P" ose "J"
            if (choice.equalsIgnoreCase("P")) {
                String decryptedMessage = decrypt(encryptedMessage, secretKey);
                System.out.println("Mesazhi i dekriptuar: " + decryptedMessage);
                break; // del nga loop-a nese shtype vlera valide
            } else if (choice.equalsIgnoreCase("J")) {
                break; // del nga loop-a nese e shtyp vlera valide
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


