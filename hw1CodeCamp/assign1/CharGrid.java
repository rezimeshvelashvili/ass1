// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
				
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int left = 1000000000;
		int right = -1;
		int top = 1000000000;
		int bottom = -1;
		int row = grid.length;
		int col = grid[0].length;
		for (int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(grid[i][j] == ch) {
					if(i < top) top = i;
					if(i > bottom) bottom = i;
					if(j > right) right = j;
					if(j< left) left = j;
				}
			}
		}
		return (right-left+1)*(bottom-top+1); 
	}
	
	private int countSame(int i, int j, int rowChange, int colChange, char ch) {
		int count = 0;
		int row = grid.length;
		while (i<row && i>=0 && j>=0 && j<grid[i].length) {
			if(grid[i][j] == ch) {
				count++;
			}else {
				break;
			}
			i += rowChange;
			j += colChange;
		}
		return count-1;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0; 
		int row = grid.length;
		if(grid == null) return 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j< grid[i].length; j++) {
				int up = countSame(i, j, -1, 0, grid[i][j]);
				int down = countSame(i, j, 1, 0, grid[i][j]);
				int right = countSame(i, j, 0, 1, grid[i][j]);
				int left = countSame(i, j, 0, -1 , grid[i][j]);
				if(up==down && right==left && up==left && up>0) count++;
			}
		}
		
		return count;
	}
	
}
