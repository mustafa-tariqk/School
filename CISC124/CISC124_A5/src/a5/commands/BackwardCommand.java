package a5.commands;

import a5.Turtle;

/**
 * Command that walks the turtle backwards.
 *
 */
public class BackwardCommand extends WalkCommand {
	
	/**
	 * Specifies the turtle that responds to this command and the distance to walk the turtle by.
	 * @param t The turtle that responds to this command.
	 * @param distance The distance to walk by.
	 * @throws IllegalArgumentException If the distance is negative.
	 */
	public BackwardCommand(Turtle t, double distance) {
		super(t, distance);
		if (distance < 0) {
			throw new IllegalArgumentException("Distance must be positive.");
		}
		
	}

	
	/**
	 * Walks the turtle backward by <code>getDistance()</code> units.
	 */
	@Override
	public void execute() {
		this.turtle.backward(getDistance());
		
	}

	
}