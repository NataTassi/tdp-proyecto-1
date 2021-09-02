package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new SimplePresentationScreen(
        			new Student(
	        			113547,
	        			"Tassi",
	        			"Nataniel",
	        			"natanieltassi@gmail.com",
	        			"https://github.com/NataTassi",
	        			"/images/113547.jpeg"
	        		)
    			);
            }
        });
    }
}