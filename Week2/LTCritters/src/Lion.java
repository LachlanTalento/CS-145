import java.awt.*;

public class Lion extends Critter{

    // Initializing variables
    // private int count;
    private int toggle;

    public Lion() {


    } // End of constructor

    public Color getColor() {

        toggle++; // Cycles between all the colors every three turns

        if (toggle < 4) {

            return Color.RED;

        } else if (toggle < 7) {

            return Color.GREEN;

        } else if (toggle < 10) {

            return Color.BLUE;

        } else {

            toggle = 1;
            return Color.RED;

        } // End of else statement

    } // End of getColor method

    public String toString() {

        return "L";

    } // End of toString method

    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT; // Infect the critter in front of them

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {

            return Action.LEFT; // Turn left

        } else if (info.getFront() == Neighbor.SAME) {

            return Action.RIGHT; // Turn Right

        } else { // End of else statement

            return Action.HOP; // Move forward

        } // End of else statement

    } // End of getMove method

} // End of Class
