/**
  * This program is to understand the wait() and notify() in Multithreading in Java.
  * 
  * wait() makes thread1 release the lock and put the thread1 to sleep. Now when any other thread2 having the lock on the same monitor
  * calls the notify() then the thread1 will wake and start processing from next statement after the wait() was called
  *
  * notify() notifies the waiting thread. But calling notify() doesn't make the thread release the lock immediately. Once it comes out of 
  * block under synchronized lock then only it will release the lock. notify() just tells the waiting threads to start watching for the 
  * lock to be released
  *
**/
public class ProducerConsumer {
	
	public static void main(String[] args) {
		
		ProducerConsumer pc = new ProducerConsumer();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				pc.produce();
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				pc.consume();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

	public void produce() {

		synchronized (this) {

			System.out.println("Producer thread running and now consuming thread will take control");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Producer thread has again taken the control after getting notified");
		}
	}
	
	public void consume() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			
			System.out.println("Consumer thread running as producer thread called wait");
			
			notify();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
