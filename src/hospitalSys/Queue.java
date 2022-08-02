package hospitalSys;

public class Queue {
	// array
	private int[] arr = new int[1000];
	private int len;
	
	public Queue() {
		len = 0;
	}
	
	public void add_end(int value) {
		// occupy last empty place, and create a new room
		arr[len++] = value;
		
	}

	public void add_front (int value) {
		// shift to the right, and create a new room
		for(int i = len-1; i< arr.length; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = value;
		len++;
	} 
	// 0 1 2 3 
	public int remove_front() {
		// shift to the left, and remove one room
		int rem = arr[0];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i+1];
		}
		len--;
		return rem;
	}
	
	public void print() {
		for(int i =0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
		System.out.print("\n");
	}

}
