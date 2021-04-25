package a5.commands;

import a5.Turtle;

/**
 * Command that changes the pen radius.
 */
public class PenRadiusCommand extends Command {
	private float radius;

	/**
	 * Specifies the turtle that responds to this command and the pen radius to change to.
	 * @param t The turtle that responds to this command.
	 * @param radius The pen radius to change to
	 */
	public PenRadiusCommand(Turtle t, float radius) {
		super(t);
		this.radius = radius;
	}
	
	/**
	 * @return The radius to change the pen to.
	 */
	public float getRadius() {
		return this.radius;
	}
	
	/**
	 * Commands the turtle to change its pen radius to <code>getRadius()</code>.
	 */
	@Override
	public void execute() {
		this.turtle.setPenRadius(this.radius);
	}

	
}
