// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TabooTest {

	// testebi agebulia beka gogaladzisgan
	
	
	@Test
	public void noFollowBasicTest1() {
		List<String> list = Arrays.asList("a", "c", "a", "b");
		Taboo<String> taboo = new Taboo<String>(list);

		Set<String> test1 = new HashSet<String>();
		test1.addAll(Arrays.asList("c", "b"));
		assertTrue(test1.equals(taboo.noFollow("a")));

		
		assertTrue(Collections.emptySet().equals(taboo.noFollow("x")));

		
		Set<String> test2 = new HashSet<String>();
		test2.addAll(Arrays.asList("c", "b"));
		assertTrue(test2.equals(taboo.noFollow("a")));

		
		Set<String> test3 = new HashSet<String>();
		test3.addAll(Arrays.asList("a"));
		assertFalse(test3.equals(taboo.noFollow("b")));

	}

	@Test
	public void noFollowBasicTest2() {
		List<String> l = Arrays.asList("a", "c", null, "a", "b", "a", "p", "k", "j", null, "a", "j");
		Taboo<String> t = new Taboo<String>(l);
		
		Set<String> test1 = new HashSet<String>();
		test1.addAll(Arrays.asList("p","c", "b", "j"));
		assertTrue(test1.equals(t.noFollow("a")));

		
		Set<String> test2 = new HashSet<String>();

		assertTrue(test2.equals(t.noFollow("j")));

		
		Set<String> test3 = new HashSet<String>();
		test3.addAll(Arrays.asList("k"));
		assertTrue(test3.equals(t.noFollow("p")));
	}
	
	@Test
	public void reduceBasicTest1() {
		List<String> list = Arrays.asList("a", "c", "a", "b");
		Taboo<String> taboo = new Taboo<String>(list);

		List<String> given = new ArrayList<String>();
		given.addAll(Arrays.asList("a", "c", "b", "x", "c", "a"));
		taboo.reduce(given);

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList("a", "x", "c"));
		assertTrue(result.equals(given));
	}

	@Test
	public void reduceBasicTest2() {
		List<String> list = Arrays.asList("a", "c", null, "a", "b", "a", "p", "k", "j", null, "a", "j");
		Taboo<String> taboo = new Taboo<String>(list);

		List<String> given = new ArrayList<String>();
		given.addAll(Arrays.asList("a", "b", "c", "a", "j", "a", "p", "k", "j", "a", "p"));
		taboo.reduce(given);

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList("a", "a", "a", "k", "a"));
		assertTrue(result.equals(given));
	}

	@Test
	public void reduceBasicTest3() {
		List<String> list = Arrays.asList("b", "u", "l", "b", "u", "l", "i");
		Taboo<String> taboo = new Taboo<String>(list);

		List<String> given = new ArrayList<String>();
		given.addAll(Arrays.asList("m", "i", "p", "l", "i", "k", "a", "n", "a"));
		taboo.reduce(given);

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList("m", "i", "p", "l", "k", "a", "n", "a"));
		assertTrue(result.equals(given));

	}

	@Test
	public void reduceBasicTest4() {
		List<String> list = Arrays.asList("a", "a");
		Taboo<String> taboo = new Taboo<String>(list);

		List<String> given = new ArrayList<String>();
		given.addAll(Arrays.asList("a", "a", "a", "a"));
		taboo.reduce(given);

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList("a"));
		assertTrue(result.equals(given));
	}

	@Test
	public void reduceBasicTest5() {
		List<String> list = Arrays.asList();
		Taboo<String> taboo = new Taboo<String>(list);

		List<String> given = new ArrayList<String>();
		given.addAll(Arrays.asList("a", "h", "c", "b"));
		taboo.reduce(given);

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList("a", "h", "c", "b"));
		assertTrue(result.equals(given));

		
		List<String> list1 = Arrays.asList("a");
		Taboo<String> taboo1 = new Taboo<String>(list1);

		List<String> given1 = new ArrayList<String>();
		given1.addAll(Arrays.asList("a", "h", "c", "b"));
		taboo1.reduce(given1);

		List<String> result1 = new ArrayList<String>();
		result1.addAll(Arrays.asList("a", "h", "c", "b"));
		assertTrue(result1.equals(given1));
	}


}
