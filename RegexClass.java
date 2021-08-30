import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexClass {

	public static void main(String[] args) {
		
		String string = "The Fat \n cat sat \n on the mat.";
		
		String pattern = ".at";
		
		Pattern pattern2 = Pattern.compile(pattern);
		Matcher  matcher = pattern2.matcher(string);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		System.out.println(string);
	}
}
