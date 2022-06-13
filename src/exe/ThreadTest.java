package c_ProcessNThread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running...");
			}
		});
		t1.start();
		
		// Lambda Runnable 1
		Runnable taskR = () -> {
			System.out.println(Thread.currentThread().getName()+" is running");
		};
		new Thread(taskR).start();
		
		// Lambda Runable 2
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+" is running");
		}).start();
	}
}
