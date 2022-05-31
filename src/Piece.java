public class Piece {
    int xPos;
    int yPos;
    char player;

    public Piece(int x, int y, char playerTile){
        xPos = x;
        yPos = y;
        player = playerTile;
    }

    public char getPlayerTile(){
        return player;
    }

}
