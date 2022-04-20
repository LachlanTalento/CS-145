import java.awt.*;

public class Giant extends Critter{

    // Initializing variables
    private int count;

    public Giant() {


    } // End of constructor

    public Color getColor() {

        return Color.GRAY;

    } // End of getColor method

    public Action getMove(CritterInfo info){

        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT; // Infect the critter in front of them

        } else if (info.getFront() == Neighbor.EMPTY) {

            return Action.HOP; // Moves forward

        }else {

            return Action.RIGHT; // Turns right

        } // End of else statement

    } // End of getMove method

    public String toString() {

        count++;

        if (count <= 6) {

            return "fee";

        } else if (count <= 12) {

            return "fie";

        } else if (count <= 18) {

            return "foe";

        } else if (count <= 24) {

            return "fum";

        } else {

            count = 0;
            return "fee";

        } // End of else statement

    } // End of toString method

} // End of Class