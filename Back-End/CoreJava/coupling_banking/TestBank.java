package CouplingBanking;

public class TestBank {
	public static void main(String[] args) {
		Bank b1=new Bank();
		SBI s1=new SBI();
		HDFC h1=new HDFC();
		ATMmcn a1 =new ATMmcn();
		
		a1.takeMoney(h1);

		
	}

}
