package syn;

public class MyThread extends Thread {
 
	private int ticket = 10;
	
	public void run(){
		for(int i = 0; i < 20; i++){
			if(this.ticket > 0){
				System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
			}
		}
	}
	
	public static void main(String[] args) {
		
		// 启动三个线程，每个线程各卖10张票
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		
		t1.start();
		t2.start();
		t3.start();
	}
}