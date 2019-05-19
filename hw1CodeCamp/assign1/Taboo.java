/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	
	HashMap<T,HashSet<T>> store = new HashMap<T,HashSet<T>>();
	
	public Taboo(List<T> rules) {
		if(!rules.isEmpty()) {
			if(rules.get(0) != null) {
				HashSet<T> set = new HashSet<T>();
				store.put(rules.get(0), set);
			}
			for(int i=1; i<rules.size(); i++) {
				T curr = rules.get(i);
				T prev = rules.get(i-1);
				if(!store.containsKey(curr) && curr != null){
					HashSet<T> set = new HashSet<T>();
					store.put(curr, set);
				}
				if(curr != null && prev != null) {
					HashSet<T> set = store.get(prev);
					set.add(curr);
					store.replace(prev, set);
				}
			}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if(store.containsKey(elem)) {
			return store.get(elem);
		}
		return Collections.emptySet();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i=0; i <list.size()-1; i++) {
			Set<T> set = noFollow(list.get(i));	
			if(set.contains(list.get(i+1))) {
				list.remove(i+1);
				i--;
			}
		}
	}
}
