package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessMath;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {

    private ChessMath chessMath;

    public King(Board board, Color color,ChessMath chessMath) {
        super(board, color);
        this.chessMath = chessMath;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return  p == null || p.getColor() != getColor();
    }
    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //ACIMA
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //ABAIXO
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //ESQUERDA
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //DIREITA
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //DIAGONAL ACIMA ESQUERDA
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //DIAGONAL ACIMA DIREITA
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //DIAGONAL ABAIXO ESQUERDA
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //DIAGONAL ABAIXO DIREITA
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //MOVIMENTO ESPECIAL CASTLING
        if (getMoveCount() == 0 && !chessMath.getCheck()) {
            //MOVIMENTO ESPECIAL CASTLING torre do lado do rei "PEQUENO"
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
        }
            if (getMoveCount() == 0 && !chessMath.getCheck()){
                //MOVIMENTO ESPECIAL CASTLING torre do lado do rei "GRANDE"
                Position posT2 = new Position(position.getRow(), position.getColumn() -4);
                if(testRookCastling(posT2)){
                    Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                    Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                    Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                    if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                        mat[position.getRow()][position.getColumn() - 2] = true;
                    }
                }
            }
        return mat;

    }
}
