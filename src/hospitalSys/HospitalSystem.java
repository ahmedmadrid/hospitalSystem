package hospitalSys;

import java.util.Scanner;

public class HospitalSystem {
	Scanner scanner = new Scanner(System.in);
	public final int MAX_SPECIALIZATION = 20;

	private Hospital_queue[] queues = new Hospital_queue[MAX_SPECIALIZATION];

	public HospitalSystem() {
		for (int i = 0; i < MAX_SPECIALIZATION; i++) {
			queues[i] = new Hospital_queue(i);
		}
	}
	
	public int menu() {
		int choice = -1;
		while (choice == -1) {
			System.out.println("\nEnter you choice");
			System.out.println("1) add new patient");
			System.out.println("2) print all patients");
			System.out.println("3) get next patient");
			System.out.println("4) Exit");

			choice = scanner.nextInt();

			if (!(choice >= 1 && choice <= 4)) {
				System.out.println("Invalid choice. try again");
				choice = -1;
			}
		}
		return choice;
	}
	
	public void run() {
		int choice = menu();
		while (true) {
			if (choice == 1) {
				add_patient();
			} else if (choice == 2)
				print_patients();
			else if (choice == 3)
				get_next_patient();
			else
				break;
		}
	}

	

	public void add_patient() {
		int spec;
		int st;
		String name;

		System.out.println("Enter specialization name status");
		spec = scanner.nextInt();
		name = scanner.nextLine();
		st = scanner.nextInt();
		scanner.nextLine();
		boolean status;
		if (st == 0)
			status = queues[spec].add_end(name, st);
		else
			status = queues[spec].add_front(name, st);
		if (status == false) {
			System.out.println("Sorry we can't add more patients to this specialization");
			scanner.close();
		}
		scanner.close();
	}

	public void print_patients() {
		System.out.println("************************************");
		for (int spec = 0; spec < MAX_SPECIALIZATION; spec++)
			queues[spec].print();
	}

	public void get_next_patient() {
		int spec;
		System.out.println("Enter specialization: ");
		spec = scanner.nextInt();
		scanner.nextLine();
		queues[spec].remove_front();
	}

	

}
