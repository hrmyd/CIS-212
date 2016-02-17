import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	private static final int BUFFER = 100000;
	
	public static void main(String[] args){
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(BUFFER);
		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue, "consumer 1");
		Consumer consumer2 = new Consumer(queue, "consumer 2");
		Consumer consumer3 = new Consumer(queue, "consumer 3");
		Consumer consumer4 = new Consumer(queue, "consumer 4");
		Consumer consumer5 = new Consumer(queue, "consumer 5");
		Consumer consumer6 = new Consumer(queue, "consumer 6");
		Consumer consumer7 = new Consumer(queue, "consumer 7");
		Consumer consumer8 = new Consumer(queue, "consumer 8");
		Consumer consumer9 = new Consumer(queue, "consumer 9");
		Consumer consumer10 = new Consumer(queue, "consumer 10");
		Consumer consumer11 = new Consumer(queue, "consumer 11");
		Consumer consumer12 = new Consumer(queue, "consumer 12");
		Consumer consumer13 = new Consumer(queue, "consumer 13");
		Consumer consumer14 = new Consumer(queue, "consumer 14");
		Consumer consumer15 = new Consumer(queue, "consumer 15");
		Consumer consumer16 = new Consumer(queue, "consumer 16");
		Consumer consumer17 = new Consumer(queue, "consumer 17");
		Consumer consumer18 = new Consumer(queue, "consumer 18");
		Consumer consumer19 = new Consumer(queue, "consumer 19");
		Consumer consumer20 = new Consumer(queue, "consumer 20");
		Consumer consumer21 = new Consumer(queue, "consumer 21");
		Consumer consumer22 = new Consumer(queue, "consumer 22");
		Consumer consumer23 = new Consumer(queue, "consumer 23");
		Consumer consumer24 = new Consumer(queue, "consumer 24");
		Consumer consumer25 = new Consumer(queue, "consumer 25");
		Consumer consumer26 = new Consumer(queue, "consumer 26");
		Consumer consumer27 = new Consumer(queue, "consumer 27");
		Consumer consumer28 = new Consumer(queue, "consumer 28");
		Consumer consumer29 = new Consumer(queue, "consumer 29");
		Consumer consumer30 = new Consumer(queue, "consumer 30");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(producer);
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		executor.execute(consumer4);
		executor.execute(consumer5);
		executor.execute(consumer6);
		executor.execute(consumer7);
		executor.execute(consumer8);
		executor.execute(consumer9);
		executor.execute(consumer10);
		executor.execute(consumer11);
		executor.execute(consumer12);
		executor.execute(consumer13);
		executor.execute(consumer14);
		executor.execute(consumer15);
		executor.execute(consumer16);
		executor.execute(consumer17);
		executor.execute(consumer18);
		executor.execute(consumer19);
		executor.execute(consumer20);
		executor.execute(consumer21);
		executor.execute(consumer22);
		executor.execute(consumer23);
		executor.execute(consumer24);
		executor.execute(consumer25);
		executor.execute(consumer26);
		executor.execute(consumer27);
		executor.execute(consumer28);
		executor.execute(consumer29);
		executor.execute(consumer30);
		executor.shutdown();
	}
}
