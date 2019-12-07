package MultiLevelInheritance;

public class TestPhones {
	public static void main(String[] args) {
		FirstGen fg=new FirstGen();
		fg.call();
		fg.msg();
		SecondGen sg=new SecondGen();
		sg.call();
		sg.msg();
		sg.radio();
		ThirdGen tg=new ThirdGen();
		tg.camera();
		tg.call();
		tg.msg();
		tg.radio();
	}

}
