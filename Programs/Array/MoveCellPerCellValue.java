package Array;
/*
Given the following 3 by 3 grid where the (first row, first column) is represented by (0,0): 

0,1 1,2 3,3 
1,1 3,3 3,2 
3,0 1,3 null 

we need to find if we can get to each cell in the table by following the cell locations at the current cell we are at.
 We can only start at cell (0,0) and follow the cell locations from that cell, to the cell it indicates and keep on doing the same for every cell.
 */
public class MoveCellPerCellValue {

	public boolean isAllCellTraversed(Cell grid[][]){
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		int total = grid.length * grid[0].length;
		int startx = grid[0][0].x;
		int starty = grid[0][0].y;
		for(int i=0; i < total-2; i++){
			if(grid[startx][starty] == null){
				return false;
			}
			if(visited[startx][starty] == true){
				return false;
			}
			visited[startx][starty] = true;
			int x = grid[startx][starty].x;
			int y = grid[startx][starty].y;
			startx = x;
			starty = y;
		}
		if(grid[startx][starty] == null){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		Cell cell[][] = new  Cell[3][2];
		
		cell[0][0] = new Cell(0,1);
		cell[0][1] = new Cell(2,0);
		cell[1][0] = null;
		cell[1][1] = new Cell(1,0);
		cell[2][0] = new Cell(2,1);
		cell[2][1] = new Cell(1,1);
		
		MoveCellPerCellValue mcp = new MoveCellPerCellValue();
		System.out.println(mcp.isAllCellTraversed(cell));
	}
	
	
}
class Cell{
	int x;
	int y;
	public Cell(int x,int y){
		this.x = x;
		this.y = y;
	}
}
