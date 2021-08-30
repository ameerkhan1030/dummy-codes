import static org.junit.Assert.assertNotSame;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;


public class FilterDeletedChild {

	public static Set<? extends Object> filterDeletedObjects(
			final Set<? extends Object> oldObject, final Set<? extends Object> updateObject) {
			Set<Object> oldObjectClone = new LinkedHashSet<>(oldObject);
			AtomicReference<Field> field = new AtomicReference<>();
			AtomicReference<Field> field1 = new AtomicReference<>();
			oldObject.forEach(object -> {
				Class<? extends Object> className = object.getClass(); 
				updateObject.forEach(obj -> {
					Class<? extends Object> className2 = obj.getClass();
					if(className.equals(className2)) {
						for (Field value : className.getDeclaredFields()) {
							if(value.isAnnotationPresent(Demo.class)) {
								value.setAccessible(true);
								field.set(value);;
								field1.set(value);;
								break;
						}
						}
					}else {
						System.out.println("error");
					}
				});
			});
			
			for (Object object : oldObject) {
					
				for (Object obj : updateObject) {
					try {
						if(field.get().get(object).equals(field1.get().get(obj))) {
							oldObjectClone.remove(object);
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.out.println("Error");
					}
				}
			}
			
			return oldObjectClone;
			
		}
	public static void main(String[] args) throws Exception {
		
		/*
		 * DummyClass dummyClass = new DummyClass(1l, "Dummy 1");
		 * 
		 * DummyClass dummyClass2 = new DummyClass(2l, "Dummy 2");
		 * 
		 * DummyClass dummyClass3 = new DummyClass(3l, "Dummy 3");
		 * 
		 * Set<DummyClass> list = new LinkedHashSet<>(); list.add(dummyClass);
		 * list.add(dummyClass2); Set<DummyClass> list2 = new LinkedHashSet<>();
		 * list2.add(dummyClass2); list2.add(dummyClass3);
		 * 
		 * System.out.println(filterDeletedObjects(list, list2));
		 */
		
		/*
		 * EqualsClass equalsClass = new EqualsClass(); equalsClass.setId(1l);
		 * equalsClass.setName("Ameer");
		 * 
		 * EqualsClass equalsClass1 = new EqualsClass(); equalsClass1.setId(1l);
		 * equalsClass1.setName("Ameer");
		 * 
		 * System.out.println(equalsClass.equals(equalsClass1)); System.out.println(
		 * EqualsBuilder.reflectionEquals(equalsClass, equalsClass1));
		 */
		
		/*
		 * Long start = System.currentTimeMillis(); List<Long> longs = new
		 * ArrayList<Long>(); longs.add(1L); longs.add(2l); System.out.println(longs);
		 * List<ConcurrencyClass> concurrencyClasses = new ArrayList<>(); CountDownLatch
		 * countDownLatch = new CountDownLatch(longs.size());
		 * 
		 * for (Long long1 : longs) {
		 * 
		 * ConcurrencyClass concurrencyClass = new
		 * ConcurrencyClass(countDownLatch,long1);
		 * concurrencyClasses.add(concurrencyClass); }
		 * 
		 * ExecutorService executor = Executors.newFixedThreadPool(1);
		 * 
		 * for (ConcurrencyClass concurrencyClass3 : concurrencyClasses) {
		 * executor.execute(concurrencyClass3); } System.out.println("End.....");
		 * countDownLatch.await(); executor.shutdown();
		 * System.out.println(Thread.currentThread().getName()); Long end =
		 * System.currentTimeMillis(); System.out.println(end-start);
		 */
		
		Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
		
		
		Boolean fafaBoolean = map.keySet().stream().anyMatch(String -> map.get(String));
		System.out.println(fafaBoolean);
	}
}
