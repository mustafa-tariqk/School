package a5.commands;

import java.awt.Color;

import a5.Turtle;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;

/**
 * Commands a turtle to draw a rainbow hexagonal spiral.
 * The hexagonal structure is drawn in counterclockwise order
 * starting from the turtle's current position. After drawing 
 * the circle the turtle returns back to its position that
 * it had immediately before drawing the structure.
 *
 */
public class InterestingCommand extends CompositeCommand {
	private int layers;
	
	/**
	 * Specifies the turtle that responds to this command and the layers of the structure.
	 * @param t The turtle that responds to this command.
	 * @param layers The layers of the structure.
	 */
	public InterestingCommand(Turtle t, int layers) {
		super(t);
		this.layers = layers;
		
		Point2 position = t.getPosition(); // Keep original position to go back to.
		
		if (this.layers < 0) {
			throw new IllegalArgumentException("Layers cannot be negative.");
		}
		
		int layerLimit = 6; // Hexagon has 6 sides, if you want to have fun change this to whatever.
		int angle = 360/layerLimit - 1; // Need to be under regular hexagon angles in order to form spiral.
		float thickness = 0.005f; // Thickness coefficient, change this for fun too.
		double length = thickness / 5;
		
		// Colors that form spiral.
		Color[] colors = {Color.RED, Color.MAGENTA, Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW};
		
		for (int i = 0; i < this.layers * layerLimit; i++) {
			this.commands.add(new PenColorCommand(t, colors[i % 6])); // Picks color based on move.
			this.commands.add(new PenRadiusCommand(t, thickness * i)); // Thickness scales with moves.
			this.commands.add(new ForwardCommand(t, length * i)); // Length scales with moves.
			this.commands.add(new TurnLeftCommand(t, angle)); // Angle stays consistent.
		}
		this.commands.add(new TeleportCommand(t, position)); // Go back to original position.
	}
	
	/**
	 * @return Number of layers.
	 */
	public int getLayers() {
		return this.layers;
	}
	

	
}
