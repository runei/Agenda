package agenda;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Funcoes {

    public static String Criptar(String string) throws NoSuchAlgorithmException  {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte bytes[] = messageDigest.digest(string.getBytes());

        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
                result.append(String.format("%02X", 0xFF & b));
        }
        return result.toString();
    }
	
}
