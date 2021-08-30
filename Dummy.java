
public class Dummy {

	public static void arrayNull(int[] myArr, Dummy2 dummy2, int a) {

		// myArr={4,5,6};
		// dummy2 = new Dummy2();
		dummy2.setIdLong(2l);
		a++;
		System.out.println(a);
		System.out.println(dummy2.getIdLong());
		System.out.println(dummy2);
		for (int i : myArr) {
			System.out.println(i);
		}

	}
	public static void main(String[] args) throws CloneNotSupportedException {
		int[] arr = { 1, 2, 3 };

		Dummy2 dummy2 = new Dummy2();
		dummy2.setIdLong(1l);
		System.out.println(dummy2);
		int a = 10;
		arrayNull(arr, dummy2, a);
		System.out.println(a);
		System.out.println(dummy2.getIdLong());
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
}

class Dummy2 implements Cloneable {

	private Long idLong;
	
	private String namString;

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}

	public String getNamString() {
		return namString;
	}

	public void setNamString(String namString) {
		this.namString = namString;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

