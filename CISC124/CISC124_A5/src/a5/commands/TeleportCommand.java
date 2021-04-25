package a5.commands;

import a5.Turtle;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;

/**
 * Command that teleports the turtle to a position.
 *
 */
public class TeleportCommand extends Command {
	private Point2 position;
	
	/**
	 * Specifies the turtle that responds to this command and the point to teleport the turtle to.
	 * @param t The turtle that responds to this command.
	 * @param position The point to teleport the turtle to.
	 */
	public TeleportCommand(Turtle t, Point2 position) {
		super(t);
		this.position = position;
	}
	
	/**
	 * Gets a copy of the position that this turtle teleports to.
	 * @return a copy of the position that this turtle teleports to.
	 */
	public Point2 getPosition() {
		return this.position;
	}
	
	/**
	 * Teleports the turtle to <code>getPosition()</code>.
	 */
	@Override
	public void execute() {
		this.turtle.teleport(this.position);
		
	}

	
}