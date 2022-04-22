import java.awt.*;

public class Orca extends Critter {

    // Initializing variables
    private int steps = 0;
    private final int count = 4000;

    public Orca(){


    }

    public Color getColor() {

        return Color.MAGENTA;

    } // End of getColor method

    public String toString() {

        return "y";

    } // End of toString method

    public Action getMove(CritterInfo info) {

        this.steps = steps;
        System.out.println(steps);

        if (info.getFront() == Neighbor.OTHER) {

            this.steps++;
            return Action.INFECT;

            } else if (this.steps <= count / 4 && info.getFront() == Neighbor.EMPTY &&
                info.getDirection() != Direction.WEST) {

                this.steps++;
                return Action.LEFT;

            } else if (this.steps > count / 4 && this.steps <= count / 4 * 2 && info.getFront() ==
                Neighbor.EMPTY && info.getDirection() != Direction.SOUTH) {

                this.steps++;
                return Action.LEFT;

            } else if (this.steps > count / 4 * 2 && this.steps <= count / 4 * 3 && info.getFront() == Neighbor.EMPTY &&
                info.getDirection() != Direction.EAST) {

                this.steps++;
                return Action.LEFT;

            } else if (this.steps > count / 4 * 3 && this.steps <= count && info.getFront() == Neighbor.EMPTY &&
                info.getDirection() != Direction.NORTH) {

                this.steps++;
                return Action.LEFT;

            } else if (this.steps > count && info.getFront() == Neighbor.EMPTY &&
                info.getDirection() != Direction.WEST) {

                this.steps = 0;
                return Action.LEFT;

            } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {

                this.steps++;
                return Action.LEFT;

            } else {

                this.steps++;
                return Action.HOP;

        } // End of else statement

    } // End of getMove method

} // End of class
