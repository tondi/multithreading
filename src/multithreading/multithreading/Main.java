package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.out.println("hello world");
		
		List<Double> myList = new ArrayList<Double>(Arrays.asList(new Double[] {1.0, 2.0, 3.0, 5.0}));
		
		MyRunnable one = new MyRunnable(myList);
		MyRunnable two = new MyRunnable(myList); 
		MyRunnable three = new MyRunnable(myList);
		
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(two);
//		Thread t3 = new Thread(three);
		
		t1.start();
		t2.start();
//		t3.start();

		t1.join();
		t2.join();
//		t3.join();
		
		System.out.println(myList);
	}

	
}
