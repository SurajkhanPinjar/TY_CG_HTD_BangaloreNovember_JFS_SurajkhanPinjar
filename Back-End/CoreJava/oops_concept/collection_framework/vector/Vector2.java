import java.util.Vector;

public class Vector2 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.add(10);
		v1.add(15);
		v1.add(20);
		v1.add(32);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());

		v1.setSize(10);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1);

		v1.add(1000);
		System.out.println(v1);
		v1.set(6, 500);
		System.out.println(v1);

		System.out.println("-------Add Element------");
		Vector v2=new Vector();
		v2.addElement(50);
		v2.addElement(55);
		v2.addElement(65);
		v2.addElement(69);
		System.out.println(v2);

		v2.removeElement(new Integer(65));
		System.out.println(v2);

		v2.removeElementAt(0);
		System.out.println(v2);

		System.out.println("---------CopyInto-------");
		Object i1[]=new Object[(v2.size())];
		v2.copyInto(i1);
		for(int i=0;i<i1.length;i++) {
			System.out.println(i1[i]);
		}


		System.out.println("Ensure Capacity adn set size");
		v2.add(45);
		v2.add(54);
		System.out.println(v2);
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		v2.trimToSize();
		System.out.println(v2.size());
		System.out.println(v2.capacity());
		v2.ensureCapacity(6);
		v2.setSize(8);


		System.out.println("New Size cap");
		System.out.println(v2.size());
		System.out.println(v2.capacity());


	}

}
