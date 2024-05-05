
public class Main {

	int[] power = {0};
	// index 1 -> player 1power 1
	// index 2 -> power 2
	// index 3 -> power 3
	// index 4 -> player 2 power 1
	// index 5 -> power 2
	// index 6 -> power 3
	int p1power1, p1power2;
	
	void arena(int num) {
		System.out.println("+---------+");
		System.out.println("+ Arena " + num +  " +");
		System.out.println("+---------+"); 
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		arena(1);
		arena(2);
		arena(3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

