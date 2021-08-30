import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollection {
	
	public interface MyFirstFunctionalInterface
	{
	    public String firstWork();
	}
	
	public static void main(String[] args) {
		
		MyFirstFunctionalInterface firstFunctionalInterface = () ->  "Functional Interface";
		System.out.println(firstFunctionalInterface.firstWork());
		
		String[] datas = { "one", "two", "three" };

		List<String> list = new ArrayList<String>(Arrays.asList(datas));

		List<String> toRemove = new ArrayList<String>();
		toRemove.add("four");
		toRemove.add("one");

		List<String> result = toRemove.stream().filter(string -> !list.contains(string)).collect(Collectors.toList());

		System.out.println(result);


	}

}
