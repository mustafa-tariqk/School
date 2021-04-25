package a5.commands;

import a5.Turtle;

/**
 * Commands a turtle to draw a circle of non-zero radius.
 * The circle is drawn in clockwise order starting from the
 * turtle's current position. After drawing the circle, the
 * turtle returns to its position and heading that it had
 * immediately before drawing the circle.
 * 
 * <p>
 * A turtle can draw only straight lines so drawing a circle
 * involves drawing a sequence of straight lines to approximate
 * a circle. 
 *
 */
public class CircleCommand extends CompositeCommand {
	private double radius;
	
	/**
	 * Specifies the turtle that responds to this command and the radius of the circle.
	 * @param The turtle that responds to this command.
	 * @param radius The radius of the circle.
	 * @throws IllegalArgumentException If the radius is zero or negative.
	 */
	public CircleCommand(Turtle t, double radius) {
		super(t);
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new IllegalArgumentException("Radius cannot be negative.");
		}
		
		double degrees = 0.5; // Calculates angle for chord length.
		int moves = (int) (360/degrees); // Finds how many chords need to be drawn.
		double chord = radius * Math.sin(Math.toRadians(degrees));
		
		for (int i = 0; i < moves; i++) { // Draws all of the chords.
			this.commands.add(new ForwardCommand(t, chord));
			this.commands.add(new TurnRightCommand(t, degrees));
		}
	}
	
	/**
	 * @return The radius of the circle drawn by the turtle.
	 */
	public double getRadius() {
		return this.radius;
	}

	
}
