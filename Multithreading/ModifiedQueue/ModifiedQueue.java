import java.util.concurrent.atomic.AtomicInteger;

public class ModifiedQueue extends Thread {

	Integer[] arr = { 6, 5, 4, 3, 2, 1 };
	private AtomicInteger index = new AtomicInteger(5);

	public Integer dequeue() {
		Integer val = null;
		for (;;) {
			int currVal = index.get();
			if (currVal >= 0) {
				val = arr[currVal];
				arr[currVal] = null;
				int newVal = currVal - 1;
				if (index.compareAndSet(currVal, newVal)) {
					break;
				}
			}else {
				break;
			}
		}
		return val;
	}

	public void run() {
		while (true) {
			Integer i = this.dequeue();
			if (i == null)
				break;
			System.out.println(i + "  " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ModifiedQueue mq1 = new ModifiedQueue();

		Thread t1 = new Thread(mq1);
		Thread t2 = new Thread(mq1);
		Thread t3 = new Thread(mq1);

		t1.start();
		t2.start();
		t3.start();
	}
}
