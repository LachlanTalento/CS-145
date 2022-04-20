import java.awt.*;

public class Orca extends Critter {

    public Orca(){


    }

    public Color getColor() {

        return Color.MAGENTA;

    } // End of getColor method

    public String toString() {

        return "y";

    } // End of toString method

    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT;

            } else if (info.getFront() == Neighbor.EMPTY && info.getDirection() != Direction.WEST) {

                return Action.LEFT;

            } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {

                return Action.LEFT;

            } else {

                return Action.HOP;

        } // End of else statement

    } // End of getMove method

} // End of class
