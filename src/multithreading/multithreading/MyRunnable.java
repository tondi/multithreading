package multithreading;

import java.util.List;
import java.util.stream.DoubleStream;

class MyRunnable implements Runnable {
	private List<Double> list;
	private Integer id;
	static Integer lastId = 0; 
	
	MyRunnable(List<Double> list) {
		this.list = list;
		
		this.id = MyRunnable.lastId++;
	}
	
	public void run() {					
		for(int i = 0; i < 5; i ++) {
			synchronized(list) {
//				Double one = list.get(list.size() - 1);
//				Double two = list.get(list.size() - 2);
				
				System.out.println("Is modified by thread " + this.id);
//				list.add(one + two);
				
				Double sum = list.stream().mapToDouble(Double::doubleValue).sum();
				list.add(sum);
				
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}