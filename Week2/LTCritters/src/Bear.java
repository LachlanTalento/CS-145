import java.awt.*;

public class Bear extends Critter {

    // Initializing variables
    private boolean flip;
    private boolean polar;

    public Bear(boolean polar) {


    } // End of constructor

    public Color getColor() {

        polar = !polar;

        if (polar) {

            return Color.WHITE;

        } else {

            return Color.BLACK;

        } // End of else statement

    } // End of getColor method

    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT; // Infect the critter in front of them

        } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {

            return Action.LEFT; // Turns left

        }else {

            return Action.HOP; // Moves forward

        } // End of else statement

    } // End of getMove method

    // Changes what character the bear will represent
    public String toString() {

        flip = !flip; // Toggle between both characters

        if (flip) {

            return "/";

        } else {

            return "\\";

        } // End of else statement

    } // End of toString method

} // End of class