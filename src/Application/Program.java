package Application;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessMath;

public class Program {
    public static void main(String[] args) {
        Board board = new Board(8, 8);

        ChessMath chessMath = new ChessMath();
        UI.printBoard(chessMath.getPieces());
    }
}