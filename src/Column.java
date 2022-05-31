public class Column {

    private final int col;
    private int nextPos = CONSTANTS.VERTICAL_SPACES - 1;
    private Piece[][] grid;


    public Column(Piece[][] grid, int col){
        this.grid = grid;
        this.col = col;
    }

    public void addPiece(char tile){
        grid[nextPos][col] = new Piece(nextPos, col, tile);
        nextPos--;

    }

    public boolean hasEmptySpot(){
        return nextPos >= 0;
    }

    public Piece getPiece(){
        return grid[nextPos + 1][col];
    }

}
