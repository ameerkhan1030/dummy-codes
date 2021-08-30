

public class DummyClass{

	@Demo
	private Long id;
	
	private String name;

	private Dummy class1;
	
	public DummyClass(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dummy getClass1() {
		return class1;
	}

	public void setClass1(Dummy class1) {
		this.class1 = class1;
	}

	
	@Override
	public String toString() {
		return "DummyClass [id=" + id + ", name=" + name + ", class1=" + class1 + "]";
	}

	
}
