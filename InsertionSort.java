import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

	static void insertionSort(final List<Integer> values) {
	
		for (int i = 1; i < values.size(); i++) {
			
			int key = values.get(i);
			int j = i-1;
			
			while (j>=0 && values.get(j)>key) {
				values.set(j+1, values.get(j));
    			j = j-1;
			}
			values.set(j+1, key);
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> values = new LinkedList<>();
		values.add(2);
		values.add(4);
		values.add(1);
		values.add(5);
		values.add(3);
		insertionSort(values);
		System.out.println(values);
	}
}
