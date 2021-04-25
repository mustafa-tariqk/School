package a5.commands;

import a5.Turtle;

/**
 * Abstract base class for all commands that cause a turtle to
 * walk in a straight line.
 *
 */
public abstract class WalkCommand extends Command {
	protected double distance; // The distance to walk the turtle by.
	
	/**
	 * Specifies the turtle that responds to this command and the distance to walk the turtle by.
	 * @param t The turtle that responds to this command.
	 * @param The distance to walk by.
	 * @throws IllegalArgumentException If the angle is negative.
	 */
	public WalkCommand(Turtle t, double distance) {
		super(t);
		this.distance = distance;
		if (t.getHeading() < 0) {
			throw new IllegalArgumentException("The angle cannot be negative.");
		}
	}
	
	/**
	 * @return The distance that the turtle walks by.
	 */
	public double getDistance() {
		return this.distance;
	}
	
    
}
