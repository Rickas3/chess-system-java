package Chess;

import Boardgame.Board;
import Boardgame.Piece;

public abstract class ChessPiece extends Piece {

   private  Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    //RETIRADO O SET PARA NAO ALTERAR A COR APENAS ACESSA-LA
    public Color getColor() {
        return color;
    }

}
