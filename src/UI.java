public class UI {

    Board board = new Board();
    Computer computer = new Computer(board);
    Column[] columns = new Column[CONSTANTS.HORIZONTAL_SPACES];

    public UI(){
        setColumns();
    }

    private void setColumns(){
        for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
            columns[x] = new Column(board.getGrid(), x);
        }
    }


    // Player Input Section
    public void addPiece(int x){
        if(columns[x].hasEmptySpot()){
            columns[x].addPiece();
        }else{
            System.out.println("Not available spot");
        }

        if(board.checkWin(columns[x].getPiece().getPlayerTile())){
            System.out.println("POOGERS");
        }


    }


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

        for(int x = 6 ; x < CONSTANTS.HORIZONTAL_SPACES + 6 ; x++){
            for(int y = 0 ; y < CONSTANTS.PRINT_DIVIDE[x % 3] ; y++){
                System.out.print("-");
            }
        }
        System.out.println();

        System.out.print("| ");
        for(int x = 0 ; x < CONSTANTS.HORIZONTAL_SPACES ; x++){
            System.out.print(x);
            System.out.print(" | ");
        }
        System.out.println();
    }


}
