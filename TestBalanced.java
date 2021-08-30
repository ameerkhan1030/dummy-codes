

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class TestBalanced {


	private static Boolean isMatch(Character start, Character end, Map<Character, Character> pairs) {

		return pairs.get(start).equals(end);
	}

	private static Boolean isBalanced(char... args) {

		Map<Character, Character> pairs = new HashMap<Character, Character>();

		pairs.put('[', ']');
		pairs.put('{', '}');

		Boolean result = false;
		if (args == null) {
			return result;
		}
		int length = args.length;

		if (length % 2 != 0) {
			return result;
		}

		for (int i = 0; i < args.length / 2; i++) {

			result = isMatch(args[i], args[--length], pairs);

			if (result.equals(Boolean.FALSE)) {
				return result;
			}
		}

		return result;

	}

	public static void main(String[] args) {

		String[] inputs = { "[[]]", "{[]}", "{([)}", "(])" };

		for (String string : inputs) {

			System.out
					.println(isBalanced(string.toCharArray()) ? string + " is Balanced" : string + " is not balanced");
		}

		LocalDate localDate = LocalDate.now().minusYears(1);
		LocalTime localTime = LocalTime.of(12, 20);
		LocalDateTime localDateTime = LocalDateTime.now();
		OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("UTC"));
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));

		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
		System.out.println(offsetDateTime);
		System.out.println(zonedDateTime);

	}
}
