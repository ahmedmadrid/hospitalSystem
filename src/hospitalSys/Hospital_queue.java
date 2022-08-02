package hospitalSys;

public class Hospital_queue {
	private final int MAX_QUEUE = 5;

	private String[] names = new String[MAX_QUEUE];
	private int[] status = new int[MAX_QUEUE];
	private int len;
	private int spec;

	public Hospital_queue(int spec) {
		this.len = 0;
		this.spec = spec;
	}

	public boolean add_end(String name, int _status) {
		if (len == MAX_QUEUE)
			return false;
		names[len] = name;
		status[len] = _status;
		len++;
		return true;
	}

	public boolean add_front(String name, int _status) {
		if (len == MAX_QUEUE)
			return false;
		for (int i = len - 1; i < names.length; i--) {
			names[i + 1] = names[i];
			status[i + 1] = status[i];
		}
		names[0] = name;
		status[0] = _status;
		len++;
		return true;
	}

	public void remove_front() {
		if (len == 0) {
			System.out.println("No patients at the moment. Dr have some rest");
			return;
		}

		System.out.println(names[0] + " please go with the Dr");
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i + 1];
			status[i] = status[i + 1];
		}
		len--;
	}

	public void print() {
		if (len == 0)
			return;

		System.out.println("there are " + len + "patients in this specialization");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
			if (status[i] == 0)
				System.out.print(" urgent");
			else
				System.out.print(" regular");
		}

		System.out.println();
	}

	public int[] getStatus() {
		return status;
	}

}
