package priorityQ;

public class PqUse {

	public static void main(String[] args) {
		
		PQ<Integer> pq = new PQ<>();
		pq._insert(1, 5);
		pq._insert(2, 4);
		pq._insert(3, 3);
		pq._insert(4, 2);
		pq._insert(5, 1);

		for(int i=0;i<pq.items.size();i++) {
			System.out.println(pq.items.get(i));
		}
		
		System.out.println("RETURN max: "+ pq._get_max());
		System.out.println("REMOVE max: "+ pq._remove_max());
		System.out.println("RETURN max: "+ pq._get_max());
		
		for(int i=0;i<pq.items.size();i++) {
			System.out.println(pq.items.get(i));
		}

	}

}
