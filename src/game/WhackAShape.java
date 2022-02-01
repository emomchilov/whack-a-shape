package game;

import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;
import CS2114.CircleShape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Shape;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This provides the WhackAShape class which creates the
 * WhackAShape game.
 * 
 * @author meden97
 * @version 19.09.2018
 *
 */
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private Button quitButton;


    /**
     * The constructor for the WhackAShape class.
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        Shape one = buildShape("red circle");
        Shape two = buildShape("blue circle");
        Shape three = buildShape("red square");
        Shape four = buildShape("blue square");

        bag.add(one);
        bag.add(two);
        bag.add(three);
        bag.add(four);

        window.addShape(bag.pick());
    }


    /**
     * The overridden constructor for the WhackAShape class.
     * 
     * @param inputs
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        quitButton = new Button("Quit");

        try {
            for (int i = 0; i < inputs.length; i++) {
                Shape shapeAdd = buildShape(inputs[i]);
                bag.add(shapeAdd);
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        window.addShape(bag.pick());
    }


    /**
     * Parses the provided input to determine whether to create
     * a CircleShape or SquareShape
     * 
     * @param shape
     * @return Shape shape
     */
    public Shape buildShape(String str) {

        TestableRandom rand = new TestableRandom();
        int size = rand.nextInt(101) + 100;

        TestableRandom width = new TestableRandom();
        TestableRandom height = new TestableRandom();
        int x = width.nextInt(window.getGraphPanelWidth() - size);
        int y = height.nextInt(window.getGraphPanelHeight() - size);

        // throw exceptions to check for red, blue, circle, square
        if ((!str.contains("red") && !str.contains("blue")) && (!str.contains(
            "circle") && !str.contains("square"))) {
            throw new IllegalArgumentException();
        }

        Shape currentShape;

        // build circle shape
        if (str.contains("circle")) {
            if (str.contains("red")) {
                currentShape = new CircleShape(x, y, size, Color.RED);
            }
            else {
                currentShape = new CircleShape(x, y, size, Color.BLUE);
            }
        }
        // build square shape
        else {
            if (str.contains("red")) {
                currentShape = new SquareShape(x, y, size, Color.RED);
            }
            else {
                currentShape = new SquareShape(x, y, size, Color.BLUE);
            }
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }


    /**
     * This method helps the user click the shape.
     * 
     * @param shape
     *            the shape being clicked
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();

        if (nextShape == null) {
            TextShape text = new TextShape(window.getGraphPanelWidth() / 2,
                window.getGraphPanelHeight() / 2, "You win!");
            window.addShape(text);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * This method helps the user quit the program.
     * 
     * @param quitButton
     *            the quit button
     */
    public void clickedQuit(Button quitButton) {
        this.quitButton = quitButton;
        System.exit(0);

    }


    /**
     * The getter method for the Window.
     */
    public Window getWindow() {
        return window;
    }


    /**
     * The getter method for the bag of shapes.
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }

}
