package Application;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessException;
import Chess.ChessMath;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Board board = new Board(8, 8);

        ChessMath chessMath = new ChessMath();
        List<ChessPiece> captured = new ArrayList<>();


        while (true){
            try {
                UI.clearScreen();
                UI.printMatch(chessMath, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMath.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMath.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMath.performChessMove(source,target);

                if (capturedPiece != null){
                    captured.add((capturedPiece));
                }
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }


    }
}