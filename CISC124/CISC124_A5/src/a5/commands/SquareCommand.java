package a5.commands;

import a5.Turtle;

/**
 * Commands a turtle to draw a square of non-zero length.
 * The square edges are drawn in clockwise order with the
 * turtle moving forward from its current position and heading.
 *
 */
public class SquareCommand extends CompositeCommand {
	private double length;
	
	/**
	 * Specifies the turtle that responds to this command and the side length of the square.
	 * @param t The turtle that responds to this command.
	 * @param length The side length of the square.
	 * @throws IllegalArgumentException If the length is zero or negative.
	 */
	public SquareCommand(Turtle t, double length) {
		super(t);
		if (length > 0) {
			this.length = length;
		} else {
			throw new IllegalArgumentException("Length cannot be negative.");
		}
		
		int sides = 4; // Wanted to make it easy for people to make polygons.
		double angle = 360/sides;
		
		for (int i = 0; i < sides; i++) {
			this.commands.add(new ForwardCommand(t, this.length));
			this.commands.add(new TurnRightCommand(t, angle));
		}
	}
	
	/**
	 * @return The side length of the square drawn by the turtle.
	 */
	public double getLength() {
		return this.length;
	}

	
}
