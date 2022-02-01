package game;

/**
 * Provides the project runner class for the WhackAShape game.
 * 
 * @author meden97
 * @version 20.09.18
 */
public class ProjectRunner {

    /**
     * The constructor for the Project runner class.
     */
    public ProjectRunner() {
        // default constructor
    }


    /**
     * The main method for the project runner class.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape collection = new WhackAShape(args);
        }
        else {
            WhackAShape collection1 = new WhackAShape();
        }
    }
}
