package chess;

import java.util.ArrayList;

public class Tour {
	protected static int x, y;
	protected static Location curr;
	protected static String piece;
	protected static String strategy;
	protected static ArrayList<Location> visited = new ArrayList<>();

	/** Initializes the Tour and subclasses.
	 * 
	 * @param x is the width of the board.
	 * @param y is the height of the board.
	 * @param piece is the type of chess piece. (Knight, Bishop, etc.)
	 * @param strategy is the type of strategy. (Warnsdoff, Brute force, etc.)
	 */
	public void setTour(int x, int y, String piece, String strategy) {
		Tour.x = x;
		Tour.y = y;
		Tour.piece = piece;
		Tour.strategy = strategy;
	}

	/** Starts tour on point and sets point to be occupied.
	 * 
	 * @param loc
	 */
	public void startTour(Location loc) {
		Tour.curr = loc;
		Tour.visited.add(loc);
	}

	/** Checks if another move can be made by counting moves.
	 * 
	 * @return if another move can be made.
	 */
	public boolean hasNext() {
		Piece p = new Piece();
		int numMoves = p.nextMovesCount(Tour.curr);
		return (numMoves > 0);
	}

	/** Finds next move based on strategy and piece.
	 * 
	 * @return the next move.
	 */
	public Location next() {
		Strategy s = new Strategy();
		Location nextMove = s.nextMove();

		Tour.curr = nextMove;
		Tour.visited.add(nextMove);
		return nextMove;
	}
}
