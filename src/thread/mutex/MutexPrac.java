package d_Synchronization;

import java.util.concurrent.locks.ReentrantLock;

class ThreadClass extends Thread { // thread Ŭ������ ��ӹ޴´�.
	// ��ȣ ���� ��� ����� �ǹ��Ѵ�.
	static ReentrantLock lock = new ReentrantLock();
	
	String thread_name;
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	
	public void run() {
		lock.lock();
		try {
			// ����Ʈ�� �ϱ� �� �ķ� �ٸ� ��������� ����� �� ������ lock�ɾ�� ��
			PrintNums(thread_name);
		} finally {
			lock.unlock();
		}
	}
	
	// ������ ���� �Լ�
	static void PrintNums(String str) {
		int i;
		System.out.println(str);
		
		for(i=1; i<=30; i++) {
			System.out.println(i+" ");
		}
		System.out.println();
	}
}

public class MutexPrac {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1 = new ThreadClass("[Thread1] ");
		ThreadClass tc2 = new ThreadClass("[Thread2] ");
		tc1.start(); 
        tc2.start();

        ThreadClass.lock.lock();
    	try {        
    		ThreadClass.PrintNums("[Main]");
    	}
    	finally
    	{
    		ThreadClass.lock.unlock();
    	}
        
        tc1.join();
        tc2.join();
	}
}
