import java.awt.*;

public class Bear extends Critter {

    public Bear(boolean polar) {



    }

    public Color getColor(boolean polar) {

        if (polar) {

            return Color.WHITE;

        } else {

            return Color.BLACK;

        }

    }

    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {

            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {

            return Action.LEFT;

        }else {

            return Action.HOP;

        }

    }

    public String toString() {

        return "/";

    }

}