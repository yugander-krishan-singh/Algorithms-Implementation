/**
  * For causing deadlock I have put two instance variables loc1 and lock2. When Thread1 acquires lock1 it tries to acquire lock2 
  * without releasing lock1. On the other hand Thread2 has also already acquired lock2 and is looking to acquire the lock1.
  * 
  * lock1 and lock2 are static so they are class-level locks.
  * If locak1 and lock2 are object level locks then also below program will work as we are using the same object d of Deadlock class 
  * to invoke thread1() and thread2()
**/
public class Deadlock {

	private static final Object lock1 = new Object();
	
	private static final Object lock2 = new Object();
	
	public void thread1() {
		
		synchronized (lock1) {
			
			try {
				Thread.sleep(2000);
				
				System.out.println("waiting for the lock "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			thread2();
			
		}
		
	}
	
	
	public void thread2() {
		
		synchronized(lock2) {
			try {
				Thread.sleep(2000);
				
				System.out.println("Waiting for the lock "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thread1();
		}
		
	}
	
	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				d.thread1();
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				d.thread2();
			}
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
	}
}
