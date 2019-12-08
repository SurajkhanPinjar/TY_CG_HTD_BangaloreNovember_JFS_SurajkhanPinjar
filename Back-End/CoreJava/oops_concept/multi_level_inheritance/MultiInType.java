package MultiLevelInheritance;

public class MultiInType {
	public static void main(String[] args) {
		
		FirstGen fn = new ThirdGen();
		fn.call();
		fn.msg();
		
		
		SecondGen sn=new ThirdGen();
		sn.call();
		sn.msg();
		sn.radio();
		
		
		ThirdGen tn=new ThirdGen();
		tn.call();
		tn.msg();
		tn.radio();
		tn.camera();
	}

}
