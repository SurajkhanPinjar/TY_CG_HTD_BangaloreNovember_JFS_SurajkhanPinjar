package InterfaceConcept;

public interface Bottle1 {
	void open();
	
	void drink();
	
	 default void juice() {
		 System.out.println("mast Juice");
	 }

	 default void close() {
		 System.out.println("CLose the bottle");
	 }
}
