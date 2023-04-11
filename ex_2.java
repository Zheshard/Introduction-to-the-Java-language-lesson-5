
// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
import java.util.*;
import java.util.stream.Collectors;

public class ex_2 {

	public static void main(String[] args) {

		List<String> employees = new ArrayList();
		employees.add("Иван Иванов");
		employees.add("Светлана Петрова");
		employees.add("Кристина Белова");
		employees.add("Анна Мусина");
		employees.add("Анна Крутова");
		employees.add("Иван Юрин");
		employees.add("Петр Лыков");
		employees.add("Павел Чернов");
		employees.add("Петр Чернышов");
		employees.add("Мария Федорова");
		employees.add("Марина Светлова");
		employees.add("Мария Савина");
		employees.add("Мария Рыкова");
		employees.add("Марина Лугова");
		employees.add("Анна Владимирова");
		employees.add("Иван Мечников");
		employees.add("Петр Петин");
		employees.add("Иван Ежов");

		Map<String, Integer> nameCount = new HashMap();

		for (String empl : employees) {
			String name = empl.substring(0, empl.indexOf(' '));
			if (nameCount.containsKey(name)) {
				nameCount.put(name, nameCount.get(name) + 1);
			} else {
				nameCount.put(name, 1);
			}
		}
		System.out.println(nameCount);

		Map<String, Integer> replNameCount = new HashMap();

		for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
			if (entry.getValue() > 1) {
				replNameCount.put(entry.getKey(), entry.getValue());
			}
		}

		System.out.println(replNameCount);

		Map<String, Integer> sortedMap = replNameCount.entrySet().stream()
				.sorted(Comparator.comparingInt(e -> -e.getValue()))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(a, b) -> {
							throw new AssertionError();
						},
						LinkedHashMap::new));

		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue() + " раз(а)");
		}
	}
}