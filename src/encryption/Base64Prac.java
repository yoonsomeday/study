package e_EncryptionNDecryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.*;

public class Base64Prac {
	static public void Base64(String TestString) throws UnsupportedEncodingException {
		// Base64 ���ڴ�
		Encoder encoder = java.util.Base64.getEncoder();
		// Base64 ���ڵ� �� ���ڿ��� ��ȯ
		String encodedString = encoder.encodeToString(TestString.getBytes("UTF-8"));
		System.out.println(encodedString);
		
		// Base64 ���ڴ�
		Decoder decoder = java.util.Base64.getDecoder();
		// Base64 ���ڵ�
		byte[] decodedBytes = decoder.decode(encodedString);
		// ���ڵ� ����� ���ڿ��� ��ȯ
		String decodedString = new String(decodedBytes, "UTF-8");
		System.out.println(decodedString);
	}
	
	static public void SHA256(String input) throws NoSuchAlgorithmException {
		// SHA-256 messageDigest �ν��Ͻ� ����
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		// SHA-256 ��ȣȭ
		byte[] result = mDigest.digest(input.getBytes());
		
		StringBuffer sb = new StringBuffer();
		
		// ��ȣȭ ��� ���ڿ� ��ȯ
		for(int i=0; i<result.length; i++) {
			sb.append(Integer.toString((result[i]&0xFF)+0x100, 16).substring(1));
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Base64("This is a Base64 test.");
		SHA256("1234");
	}
}
