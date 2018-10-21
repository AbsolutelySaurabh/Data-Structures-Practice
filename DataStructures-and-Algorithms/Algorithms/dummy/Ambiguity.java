package dummy;

public class Ambiguity {
	
	private static int A(int a) {
		System.out.println("A");
		return 0;
	}
	private static void A(char a) {
		
		System.out.println("void");
	}
	public static void main(String[] args) {
		
		int a = A(2);
	}
}
