package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe com métodos que serão usados em toda aplicação
 * @author carlos.ribeiro
 *
 */
public class Utils {
	public static String geraMD5(String texto) throws NoSuchAlgorithmException  {
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
 		return hash.toString(16);
	}
	
	public static Date stringToDate(String formato, String data) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		return dateFormat.parse(data);
	}
	
	
}
