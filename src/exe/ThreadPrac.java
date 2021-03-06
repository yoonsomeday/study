package c_ProcessNThread;

/*
 * Thread 2개를 만든 후 main함수와 thread 2개에서 동시에 0부터 9까지 출력하시오
 * 어디서 출력했는지 알 수 있게 숫자앞에 [main] [thread1]표시하기
 */
public class ThreadPrac {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1 = new ThreadClass("[Thread1] ");
		ThreadClass tc2 = new ThreadClass("[Thread2] ");
		tc1.start(); // start를 하면 아래 class의 run을 돌게 된다.
		tc2.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("[Main] "+i);
			Thread.sleep(10);
		}
		
		tc1.join(); // 스레드 종료
		tc2.join();
	}
}

class ThreadClass extends Thread{ // thread 클래스를 상속받는다
	String thread_name;
	public ThreadClass(String name) {
		this.thread_name = name;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(thread_name+i);
			try {
				sleep(10); // sleep을 적절히 줘서 context switch가 일어나게 했다.
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}