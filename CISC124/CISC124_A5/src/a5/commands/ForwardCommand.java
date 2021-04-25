package a5.commands;

import a5.Turtle;

/**
 * Command that walks the turtle forwards.
 *
 */
public class ForwardCommand extends WalkCommand {

	/**
	 * Specify the turtle that responds to this command and the distance to walk the turtle by.
	 * @param t The turtle that responds to this command.
	 * @param distance The distance to walk by.
	 * @throws IllegalArgumentException If the distance is negative.
	 */
	public ForwardCommand(Turtle t, double distance) {
		super(t, distance);
		if (distance < 0) {
			throw new IllegalArgumentException("Distance must be positive.");
		}
	}
	
	/**
	 * Walks the turtle forward by <code>getDistance()</code> units.
	 */
	@Override
	public void execute() {
		this.turtle.forward(getDistance());
		
	}

	
}