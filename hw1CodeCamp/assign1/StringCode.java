package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max=0;
		int curr=0;
		char ch = 'a';
		for(int i=0; i<str.length(); i++) {
			if(i==0) {
				ch = str.charAt(i);
				curr++;
				max++;
			}else {
				if(str.charAt(i)!=ch) {
					ch = str.charAt(i);
					curr = 1;
				}else {
					curr++;
					if(curr>max) max = curr;
				}
			}
		}
		return max; // TODO ADD YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		// TODO ADD YOUR CODE HERE
		String ans = "";
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(i==str.length()-1) {
				if(!Character.isDigit(ch)) {
					ans+=ch;
				}
			}else {
				if(Character.isDigit(ch)) {			
						for(int j=0; j<Character.getNumericValue(ch); j++) {
							ans+=str.charAt(i+1);
						}
				}else {
					ans+=ch; 
				}
			}
		}
		return ans;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> h = new HashSet<String>(a.length()*2);
		for(int i=0; i<a.length()-len+1; i++) {
			h.add(a.substring(i, i+len));
		}
		for(int i=0; i<b.length()-len+1; i++) {
			if(h.contains(b.substring(i, i+len))) {
				return true;
			}
		}
		return false; 
	}
}
