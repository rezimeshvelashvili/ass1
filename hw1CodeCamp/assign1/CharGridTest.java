// Test cases for CharGrid -- a few basic tests are provided.
package assign1;
				
import static org.junit.Assert.*;
import org.junit.Test;

////// ALERT ///////////
////////////////////////

// Beka Gogaladzis testebi//


//////////////////////////////
public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
			
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	@Test
	public void testcountPlus1() {
		   char[][] grid = new char[][] {
	            {' ',' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
	            {' ',' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
	            {'p','p', 'p', 'p', 'p', ' ', 'x', 'x'},
	            {' ',' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
	            {' ',' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
	            {'z','z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
	            {' ',' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
	        };

			CharGrid cg = new CharGrid(grid);
			
	        assertEquals(1, cg.countPlus());

	}
	
	@Test
	public void testcountPlus2() {
		   char[][] grid = new char[][] {
			    {' ', ' ', ' ',' ','a'},
				{'c', 'a', ' ',' ','a'},
			    {'a', 'a', 'a',' ','a'},
			    {' ', 'a', ' ','a','a'},
			    {' ', ' ', ' ','a','a'}
		   };
			CharGrid cg = new CharGrid(grid);
	        assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testcountPlus3() {
		   char[][] grid = new char[][] {
	            {' ',' ', 'a', ' ', ' ', 'y', ' ', ' ', 'z'},
	            {' ','p', 'p', ' ', 'y', 'y', 'y', 'x', 'z'},
	            {'p','p', 'p', ' ', 'p', 'y', 'x', 'x', 'x'},
	            {' ','p', 'a', ' ', ' ', ' ', ' ', 'x', 'z'},
	            {' ',' ', 'p', 'z', 'y', ' ', 'y', ' ', 'z'},
	            {'z','y', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
	            {' ',' ', 'x', 'z', ' ', 'y', ' ', ' ', ' '}
	        };

			CharGrid cg = new CharGrid(grid);	
	        assertEquals(4, cg.countPlus());
	}
	
	@Test
	public void testcountPlus4() {
		   char[][] grid = new char[][] {
	            {'x','x', 'x', 'x', 'x', ' ', ' ', ' ', ' '},
	            {' ',' ', ' ', ' ', 'x', ' ', ' ', ' ', ' '},
	            {' ',' ', ' ', ' ', 'x', ' ', ' ', ' ', ' '},
	            {' ','x', 'x', 'x', 'x', 'x', 'x', 'x', ' '},
	            {' ',' ', ' ', ' ', 'x', ' ', ' ', ' ', ' '},
	            {' ',' ', 'x', 'x', 'x', 'x', 'x', ' ', ' '},
	            {' ',' ', 'x', ' ', 'x', ' ', 'x', ' ', ' '}
	        };

			CharGrid cg = new CharGrid(grid);	
	        assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testcountPlus5() {
		   char[][] grid = new char[][] {
	            {'x','x', 'x', 'x'},
	            {' ',' ', 'x', ' '}
	        };

			CharGrid cg = new CharGrid(grid);	
	        assertEquals(0, cg.countPlus());
	}
	@Test
	public void testcountPlus6() {
		   char[][] grid = new char[][] {};

			CharGrid cg = new CharGrid(grid);	
	        assertEquals(0, cg.countPlus());
	}
	@Test
	public void testcountPlus7() {
		   char[][] grid = new char[][] {
	            {'x','x', 'x', 'x', 'x', 'x'},
	            {'y','y', 'y', 'y', 'y', 'y'},
	            {'x','x', 'x', 'x', 'x', 'x'},
	            {'y','y', 'y', 'y', 'y', 'y'},
	            {'r','r', 'r', 'r', 'r', 'r'},
	            {'m','m', 'm', 'm', 'm', 'm'},
	        };

			CharGrid cg = new CharGrid(grid);	
	        assertEquals(0, cg.countPlus());
	}

	
}
