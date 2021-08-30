import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Test {

	private Integer number;

	private String word;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	private Test2 test2;

	public Test(final Integer number, final String word) {

		this.number = number;
		this.word = word;
	}

	public Test2 getTest2() {
		return test2;
	}

	public void setTest2(Test2 test2) {
		this.test2 = test2;
	}

	static List<String> getDifference(Object s1, Object s2) throws IllegalAccessException {
		List<String> values = new ArrayList<>();
		for (Field field : s1.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value1 = field.get(s1);
			Object value2 = field.get(s2);
			if (value1 != null && value2 != null) {
				if (!Objects.equals(value1, value2)) {
					values.add(String.valueOf(field.getName()));
				}
			}
		}
		return values;
	}

	@Override
	public String toString() {
		return "Test [number=" + number + ", word=" + word + ", test2=" + test2 + "]";
	}

}

class Test2 {

	private Integer number1;

	private String word1;

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public Test2() {

	}

	@Override
	public String toString() {
		return "Test2 [number1=" + number1 + ", word1=" + word1 + "]";
	}

}

@FunctionalInterface
interface TestI {

	public int add(int a, int b);

}
public class Collection {

	public static Date truncateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static void main(String[] args) throws InterruptedException, ParseException {

		TestI i = (a, b) -> a + b;

		TestI res = i::add;
		
		System.out.println(res.add(1, 2));

		List<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20).collect(Collectors.toList());
		streamIterated.forEach(System.out::println);

	}
}