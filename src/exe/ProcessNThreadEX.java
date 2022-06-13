package c_ProcessNThread;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ProcessNThreadEX {

	// ���μ��� ���� Ŀ�ǵ�
	public static String getProcessOutput(List<String> cmdList) throws IOException, InterruptedException{
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		// ���μ��� ����
		Process process = builder.start();
		// ��°�������
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		psout.read(buffer);
		return(new String(buffer));
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		// asList = �Ϲ� �迭�� ArrayList�� ��ȯ�Ѵ�.
		String output = getProcessOutput(Arrays.asList("add_2sec.exe","2","3"));
		System.out.println(output);
		
		
		// �Ʒ��� �ִ� thread Ŭ���� �ǽ� ���1
		ThreadClass1 tc1 = new ThreadClass1();
		tc1.start();
		
		try {
			tc1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// �Ʒ��� �ִ� thread Ŭ���� �ǽ� ���2
		ThreadClass2 tc2 = new ThreadClass2();
		Thread t2 = new Thread(tc2);
		t2.start();
		
		try {
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}

// thread�� �׳� ��� �޾��ִ� ��� 1
class ThreadClass1 extends Thread{
	public void run() {
		System.out.println("Thread is running...");
	}
}

// runnable interface�̿��ϴ� ��� 2
class ThreadClass2 implements Runnable{
	public void run() {
		System.out.println("Thread is running...");
	}
}