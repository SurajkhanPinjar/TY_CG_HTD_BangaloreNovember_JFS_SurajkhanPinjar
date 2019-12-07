import java.util.LinkedList;

public class LinkedLiMethods {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(10);
		l1.add(20);
		l1.add(55);
		l1.add(45);
		System.out.println(l1);
		
		System.out.println("-------Add f and Last");
		l1.addFirst(100);
		System.out.println(l1);
		l1.addLast(200);
		System.out.println(l1);
		
		System.out.println("-----Remove---");
		l1.remove();
		System.out.println(l1);
		
		System.out.println("-----Remove F and L-----");
		l1.removeFirst();
		System.out.println(l1);
		l1.removeLast();
		System.out.println(l1);
		
		LinkedList l2=new LinkedList();
		l2.add(10);
		l2.add(22);
		l2.add(33);
		l2.add(10);
		l2.add(22);
		System.out.println("l2 "+l2);
		System.out.println("----------Remove Occc-------");
		l2.removeFirstOccurrence(10);
		System.out.println(l2);
		l2.removeLastOccurrence(22);
		System.out.println(l2);
		
		System.out.println(l2.getFirst());
		
		
		System.out.println("------peek peekF peekL-----");
		System.out.println(l2.peek());
		System.out.println(l2.peekFirst());
		System.out.println(l2.peekLast());
		
		System.out.println("-------Offer offerF OfferL-------");
		System.out.println("l2:"+l2);
		l2.offer(100);
		System.out.println(l2);
		l2.offerLast(2000);
		System.out.println(l2);
		l2.offerFirst(10000);
		System.out.println(l2);
		
		
		System.out.println("------polll  pollF pollL---------");
		
		System.out.println(l2);
		l2.poll();
		System.out.println(l2);
		l2.pollFirst();
		System.out.println(l2);
		l2.pollLast();
		System.out.println(l2);
		
		
		System.out.println("-----push---");
		l2.push(500);
		System.out.println(l2);
		
		System.out.println("-----pop--------");
		l2.pop();
		System.out.println(l2);
		
		System.out.println("----Element-------");
		System.out.println(l2.element());
		System.out.println("l2:"+l2);
	}

}
