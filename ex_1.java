
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ex_1 {

	public static void addPhoneNumber(String name, String number, HashMap<String, List<String>> contacts) {
		List<String> numbers;
		if (contacts.containsKey(name)) {
			numbers = contacts.get(name);
		} else {
			numbers = new ArrayList();
			contacts.put(name, numbers);
		}
		numbers.add(number);
	}

	public static void printAllNumbers(HashMap<String, List<String>> contacts) {
		for (String name : contacts.keySet()) {
			System.out.print(name + ": ");
			List<String> numbers = contacts.get(name);
			for (String number : numbers) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		HashMap<String, List<String>> phoneBook = new HashMap<>();
		Scanner scanner = new Scanner(System.in, "cp866");

		while (true) {
			System.out
					.println("Введите 1, чтобы добавить номер телефона, или 2, чтобы распечатать все номера. 0 - завершить:");
			int choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Введите имя:");
				String name = scanner.next();
				System.out.println("Введите номер телефона:");
				String number = scanner.next();
				addPhoneNumber(name, number, phoneBook);
			} else if (choice == 2) {
				printAllNumbers(phoneBook);
			} else if (choice == 0) {
				break;
			}
		}
	}
}
