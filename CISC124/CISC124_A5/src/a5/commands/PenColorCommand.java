package a5.commands;

import java.awt.Color;
import java.util.Objects;

import a5.Turtle;

/**
 * Command that changes the pen color.
 */
public class PenColorCommand extends Command {
	private Color c;
	
	/**
	 * Specifies the turtle that responds to this command and the pen color to change to.
	 * @param t The turtle that responds to this command.
	 * @param c The color to change to.
	 */
	public PenColorCommand(Turtle t, Color c) {
		super(t);
		this.c = c;
	}
	
	/**
	 * @return The color to change the pen to.
	 */
	public Color getColor() {
		return this.c;
	}
	
	/**
	 * Commands the turtle to change its pen color to <code>getColor()</code>.
	 */
	@Override
	public void execute() {
		this.turtle.setPenColor(this.c);
	}

	
}
