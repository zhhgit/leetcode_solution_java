package q200_number_of_islands;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args){
		char[][] matrix = {"11000".toCharArray(),"11000".toCharArray(),"00100".toCharArray(),"00011".toCharArray()};
		System.out.println(numIslands(matrix));
	}
	
	private static int count;
	
    private static int numIslands(char[][] grid) {
    	count = 0;
    	int row = grid.length;
    	if(row == 0){
    		return 0;
    	}
    	int column = grid[0].length;
    	if(column == 0){
    		return 0;
    	}
    	boolean[][] used = new boolean[row][column];
    	visitAll(grid, used);
    	return count;
    }
    
    private static class Position{
    	int x;
    	int y;
    	Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
    
    private static void visitAll(char[][] grid,boolean[][] used) {
		int row = grid.length;
		int column = grid[0].length;
		for(int i = 0;i<row;i++){
			for(int j = 0;j<column;j++){
				if(!used[i][j] && grid[i][j] == '1'){
					used[i][j] = true;
					List<Position> currList = new LinkedList<>();
					currList.add(new Position(i, j));
					while(currList.size() > 0){
						List<Position> nextList = new LinkedList<>();
						for (int z = 0; z < currList.size(); z++) {
							Position node = currList.get(z);
							if (validPosition(node.x + 1, node.y, grid) && !used[node.x + 1][node.y] && grid[node.x + 1][node.y] == '1') {
								used[node.x + 1][node.y] = true;
								nextList.add(new Position(node.x + 1, node.y));
							}
							if (validPosition(node.x - 1, node.y, grid) && !used[node.x - 1][node.y] && grid[node.x - 1][node.y] == '1') {
								used[node.x - 1][node.y] = true;
								nextList.add(new Position(node.x - 1, node.y));
							}
							if (validPosition(node.x, node.y + 1, grid) && !used[node.x][node.y + 1] && grid[node.x][node.y + 1] == '1') {
								used[node.x][node.y + 1] = true;
								nextList.add(new Position(node.x, node.y + 1));
							}
							if (validPosition(node.x, node.y - 1, grid) && !used[node.x][node.y - 1] && grid[node.x][node.y - 1] == '1') {
								used[node.x][node.y - 1] = true;
								nextList.add(new Position(node.x, node.y - 1));
							}
							currList = nextList;
						}
					}
					count++;
				}
			}
		}
	}
    
    private static boolean validPosition(int i,int j,char[][] grid) {
    	int row = grid.length;
		int column = grid[0].length;
		return i<row && i>=0 && j<column && j>=0;
	}
}
