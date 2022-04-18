package application;

import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(input);
				
				ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.print(e.getMessage() + " Press ENTER to continue.");
				input.nextLine();
			}
			catch (RuntimeException e){
				System.out.print(e.getMessage() + " Press ENTER to continue.");
				input.nextLine();
			}
		}
	}

}
