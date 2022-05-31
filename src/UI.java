import java.util.HashMap;

public class UI {

    Board board = new Board();
    Column[] columns = new Column[CONSTANTS.HORIZONTAL_SPACES];
    private int playerTurn = 2;

    public UI(){
        setColumns();
    }

    //Print board to terminal
    public void displayBoard(){
        for(int y = 0 ; y < CONSTANTS.VERTICAL_SPACES ; y++){
            System.out.print("| ");
            for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
                if(board.getGrid()[y][x] == null){
                    System.out.print(" ");
                }else{
                    System.out.print(board.getGrid()[y][x].getPlayerTile());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

        System.out.print("-");
        for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
            System.out.print("----");
        }
        System.out.println();

        System.out.print("| ");
        for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
            System.out.print(x);
            System.out.print(" | ");
        }
        System.out.println();
    }


    // Player Input Section
    public void addPiece(int x){
        if(x < CONSTANTS.HORIZONTAL_SPACES) {
            if (columns[x].hasEmptySpot()) {
                columns[x].addPiece(getTile());
                playerTurn++;
            } else {
                System.out.println("No available spot");
            }
        }else
            System.out.println("Out of bounds");
    }


    private void setColumns(){
        for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
            columns[x] = new Column(board.getGrid(), x);
        }
    }

    public boolean checkWin(){
        return board.checkWin(getTile());

    }

    public char getTile(){
        return (playerTurn % 2 == 0) ? CONSTANTS.PLAYER_ONE : CONSTANTS.PLAYER_TWO;
    }

}
