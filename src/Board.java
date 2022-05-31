

public class Board {

    private Piece[][] grid = new Piece[CONSTANTS.VERTICAL_SPACES][CONSTANTS.HORIZONTAL_SPACES];
    Match match = new Match(CONSTANTS.IN_A_ROW, grid);


    public Board(){
        System.out.println(grid[0].length);
        System.out.println(CONSTANTS.HORIZONTAL_SPACES);
        System.out.println(CONSTANTS.HORIZONTAL_SPACES);
        System.out.println(CONSTANTS.VERTICAL_SPACES);
    }

    public boolean checkWin(char tile){
        match.swapTile(tile);
        for(int y = CONSTANTS.VERTICAL_SPACES - 1; y >= 0 ; y--){
            for(int x = CONSTANTS.HORIZONTAL_SPACES - 1 ; x >= 0 ; x--){
                if(grid[y][x] != null){
                    match.assignPos(x, y);
                    if(y <= CONSTANTS.VERTICAL_SPACES - CONSTANTS.IN_A_ROW){
                        if(match.checkAlgorithm(0, -1)) return true;
                    }
                    if(x <= CONSTANTS.HORIZONTAL_SPACES - CONSTANTS.IN_A_ROW){
                        if(match.checkAlgorithm(1, 0)) return true;
                    }
                    if(x <= CONSTANTS.HORIZONTAL_SPACES - CONSTANTS.IN_A_ROW && y <= CONSTANTS.IN_A_ROW){
                        if(match.checkAlgorithm(1, -1)) return true;
                    }
                    if(x >= CONSTANTS.IN_A_ROW - 1 && y <= CONSTANTS.IN_A_ROW){
                        if(match.checkAlgorithm(-1, -1)) return true;
                    }
                }
            }
        }

        return false;

    }


    public Piece[][] getGrid(){ return grid;}



}



class Match{
    int numOfRequiredMatches;
    Piece[][] grid;
    int xPos;
    int yPos;
    char mutableTile;


    public Match(int numOfVals, Piece[][] g){
        numOfRequiredMatches = numOfVals;
        grid = g;
    }

    public void assignPos(int x, int y){
        xPos = x;
        yPos = y;
    }

    public boolean checkAlgorithm(int xMod, int yMod){
        int matches = 1;
        for(int cnt = 1 ; cnt < CONSTANTS.IN_A_ROW ; cnt++){
            if(grid[yPos - (yMod * cnt)][xPos + (xMod * cnt)] != null){
                if(grid[yPos - (yMod * cnt)][xPos + (xMod * cnt)].getPlayerTile() == mutableTile){
                    //System.out.println("Found tile " + mutableTile + " at " + (xPos + (xMod * cnt)) +  " , " + (yPos - (yMod * cnt)));
                    matches++;
                }else{
                    //System.out.println("Spot at " + (xPos + (xMod * cnt)) + " , " + (yPos + (yMod * cnt)) + " no match");
                    break;
                }
            }else{
                //System.out.println("Spot at " + (xPos + (xMod * cnt)) + " , " + (yPos + (yMod * cnt)) + " not exist");
            }
        }
        return matches >= CONSTANTS.IN_A_ROW;
    }

    public void swapTile(char tile){
        mutableTile = tile;
    }

}
