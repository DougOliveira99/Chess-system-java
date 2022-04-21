package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		List<ChessPiece> captured = new ArrayList<>();
		
		ChessMatch chessMatch = new ChessMatch();
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(input);
				
				ChessPiece capturedPiece = chessMatch.perfomChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
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
		
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
	}
}
