//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	
	private boolean [][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		boolean [][] bg = new boolean[this.grid.length][this.grid[0].length];
		int count =0;
		boolean [] b = new boolean[this.grid[0].length];
		for(int i=0; i<bg[0].length; i++) {
			for(int j=0; j<bg.length; j++) {
				if(this.grid[j][i] == true) count++;
			}
			if(count == bg.length) b[i] = true;
			count = 0;
		}
		for(int i=0; i< this.grid[0].length; i++) {
			if(!b[i]) {
				for(int j=0; j<this.grid.length; j++) {
					bg[j][count] = this.grid[j][i]; 
				}
				count++;
			}
		}
		this.grid = bg;
		for(int i=0; i< this.grid[0].length; i++) {
				for(int j=0; j<this.grid.length; j++) {
					System.out.println(this.grid[j][i]); 
				}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid; // TODO YOUR CODE HERE
	}
}
