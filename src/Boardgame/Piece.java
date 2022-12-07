package Boardgame;

public class Piece {
    //Protected apenas classes dentro do mesmo pacote e subclasses podem acessala
    protected Position position;

    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;

    }
    protected Board getBoard() {
        return board;
    }

}
