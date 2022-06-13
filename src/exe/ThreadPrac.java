package c_ProcessNThread;

/*
 * Thread 2���� ���� �� main�Լ��� thread 2������ ���ÿ� 0���� 9���� ����Ͻÿ�
 * ��� ����ߴ��� �� �� �ְ� ���ھտ� [main] [thread1]ǥ���ϱ�
 */
public class ThreadPrac {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1 = new ThreadClass("[Thread1] ");
		ThreadClass tc2 = new ThreadClass("[Thread2] ");
		tc1.start(); // start�� �ϸ� �Ʒ� class�� run�� ���� �ȴ�.
		tc2.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("[Main] "+i);
			Thread.sleep(10);
		}
		
		tc1.join(); // ������ ����
		tc2.join();
	}
}

class ThreadClass extends Thread{ // thread Ŭ������ ��ӹ޴´�
	String thread_name;
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(thread_name+i);
			try {
				sleep(10); // sleep�� ������ �༭ context switch�� �Ͼ�� �ߴ�.
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}