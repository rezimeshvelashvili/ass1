package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> store = new HashMap<T, Integer>(); 
		int ans = 0;
		for(T t : a) {
			if(store.containsKey(t)) {
				Integer curr = store.get(t)+1;
				store.replace(t, curr);
			}else {
				store.put(t, 1);
			}
		}
		for(T t : b) {
			if(store.containsKey(t)) {
				Integer curr = store.get(t)-1;
				store.replace(t, curr);
			}
		}
		for(T t : store.keySet()) {
			if(store.get(t) == 0) {
				ans++;
			}
		}
		return ans;
	}
}
