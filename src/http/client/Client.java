package f_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		// 3������ connect���� ����ȴ�. ����ÿ� ������ �����ȴ�. ����ȵ� ��쿡�� ���� �߻�
		Socket s = new Socket("127.0.0.1", 9090);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//5(������ test ����Ʈ���� �Ѿ��)
		String answer = input.readLine();
		System.out.println(answer);
	}
}
