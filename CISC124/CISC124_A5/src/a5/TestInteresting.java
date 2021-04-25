package a5;

import java.awt.Color;

import a5.commands.Command;
import a5.commands.InterestingCommand;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;


/**
 * Simple test class for the final question in Assignment 5.
 */

public class TestInteresting {

	public static void main(String[] args) {
		
		StdDraw.clear(new Color(0, 0, 0));
		Turtle t = new Turtle(new Point2(0.5, 0.5), 0, Color.BLACK);
	    Command c = new InterestingCommand(t, 50);
	    c.execute();
	}

}
