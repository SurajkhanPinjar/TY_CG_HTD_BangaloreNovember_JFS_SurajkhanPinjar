package IRCTC;

public class IRCTC {
	synchronized void confirmTickets() {
		for (int i=0;i<5;i++) {
			System.out.println(i);
			try {
				wait();
			} catch (InterruptedException e) {

			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//
//			}
			
		}
		
	}
		synchronized void leaveMe() {
			System.out.println("Notify readed..");
			notifyAll();
	}
}
