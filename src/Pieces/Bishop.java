package Pieces;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Enums.PieceColor;
import Enums.PiecePoints;
import chess.Board;
/**
 * A bishop.
 * 
 * @author dimabliz@uw.edu
 * @author Maksimv@uw.edu
 */
public class Bishop extends AbstractPiece { 
	/**
	 * Creates a bishop of this color.
	 * 
	 * @param theColor the color of this bishop.
	 */
	public Bishop(PieceColor theColor, Point theLocation, Board theBoard) {
		super(theColor, PiecePoints.BISHOP, theLocation, theBoard);
	}
	
	/**
	 * Returns a list of all the Points to where the bishop
	 * is allowed to move.
	 * 
	 * @return 
	 */
	public List<Point> getAvailableMoves(final Piece[][] board) {
		List<Point> moves = new ArrayList<Point>();
		
		// Two loops below are adding points on this diagonal line:  /
		for(int i = 1; i < 8; i++) {
			if (myLocation.y+i < 8 && myLocation.x-i >= 0) {
				if (board[myLocation.x-i][myLocation.y+i] != null)  { //piece at that location
					if (board[myLocation.x-i][myLocation.y+i].getColor() != myColor) {
						moves.add(new Point(myLocation.y+i, myLocation.x-i)); //different color piece (legal move)
					}
					break;
				} else {
					moves.add(new Point(myLocation.y+i, myLocation.x-i));
				}	
			}
		}
		for(int i = 1; i < 8; i++) {
			if (myLocation.y-i >= 0 && myLocation.x-i >= 0) {
				if (board[myLocation.x-i][myLocation.y-i] != null)  { //piece at that location
					if (board[myLocation.x-i][myLocation.y-i].getColor() != myColor) {
						moves.add(new Point(myLocation.y-i, myLocation.x-i)); //different color piece (legal move)
					}
					break;
				} else {
					moves.add(new Point(myLocation.y-i, myLocation.x-i));
				}
			}
		}
		
		//Next two loops are adding points on this diagonal line: \
		for(int i = 1; i < 8; i++) {
			if (myLocation.y-i >= 0 && myLocation.x+i < 8) {
				if (board[myLocation.x+i][myLocation.y-i] != null)  { //piece at that location
					if (board[myLocation.x+i][myLocation.y-i].getColor() != myColor) {
						moves.add(new Point(myLocation.y-i, myLocation.x+i)); //different color piece (legal move)
					}
					break;
				} else {
					moves.add(new Point(myLocation.y-i, myLocation.x+i));
				}
			}
		}
		for(int i = 1; i < 8; i++) {
			if (myLocation.x+i < 8 && myLocation.y+i < 8) {
				if (board[myLocation.x+i][myLocation.y+i] != null)  { //piece at that location
					if (board[myLocation.x+i][myLocation.y+i].getColor() != myColor) {
						moves.add(new Point(myLocation.y+i, myLocation.x+i)); //different color piece (legal move)
					}
					break;
				} else {
					moves.add(new Point(myLocation.y+i, myLocation.x+i));
				}
			}
		}

		PieceColor myColor = myBoard.getLastPieceMoved().getColor() == PieceColor.White ? PieceColor.Black : PieceColor.White;
		if (this.getColor() == myColor)
			refineByCheck(moves);
		return moves;
	}
	
	/**
	 * {@inheritDoc Piece.java}
	 */
	@Override
	public String toString() {
		return super.toString() + "B";
	}
}