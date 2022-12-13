package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessMath;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece {

    private ChessMath chessMath;

    public Pawn(Board board, Color color, ChessMath chessMath) {
        super(board, color);
        this.chessMath = chessMath;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        if(getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() ==0) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //MOVIMENTO ESPECIAL EN PASSANT BRANCAS
            if (position.getRow() == 3){
                Position esquerda = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(esquerda) && isThereOpponentPiece(esquerda) && getBoard().piece(esquerda) == chessMath.getEnPassantVulnerable()){
                    mat[esquerda.getRow() -1][esquerda.getColumn()] = true;
                }
                Position direita = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(direita) && isThereOpponentPiece(direita) && getBoard().piece(direita) == chessMath.getEnPassantVulnerable()){
                    mat[direita.getRow() - 1][direita.getColumn()] = true;
                }
            }
        }
        else {
            if(getColor() == Color.BLACK){
                p.setValues(position.getRow() + 1, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() + 2, position.getColumn());
                Position p2 = new Position(position.getRow() + 1, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() ==0) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() + 1, position.getColumn() - 1);
                if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() + 1, position.getColumn() + 1);
                if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
            //MOVIMENTO ESPECIAL EN PASSANT PRETAS
            if (position.getRow() == 4){
                Position esquerda = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(esquerda) && isThereOpponentPiece(esquerda) && getBoard().piece(esquerda) == chessMath.getEnPassantVulnerable()){
                    mat[esquerda.getRow() + 1][esquerda.getColumn()] = true;
                }
                Position direita = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(direita) && isThereOpponentPiece(direita) && getBoard().piece(direita) == chessMath.getEnPassantVulnerable()){
                    mat[direita.getRow() + 1][direita.getColumn()] = true;
                }
            }
        }
        return mat;
    }
    @Override
    public String toString(){
        return "P";
    }
}
