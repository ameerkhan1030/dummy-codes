import static java.util.concurrent.TimeUnit.MINUTES;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CustomComparator implements Comparator<String> {

	public int compare(String x, String y) {
		DateTimeFormatter DATEFORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
		LocalDateTime date = LocalDateTime.parse(x, DATEFORMAT);
		LocalDateTime anotherDate = LocalDateTime.parse(y, DATEFORMAT);
		System.out.println(date);
		System.out.println(anotherDate);
		return date.compareTo(anotherDate);
	}
}

public class ConcurrencyClass {
	public static void main(String[] args) throws ParseException {

		List<String> firstList = new ArrayList<String>();

		System.out.println(MINUTES.toMillis(1));
		System.out.println(firstList);
	}
}