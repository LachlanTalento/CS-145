// Original Authors: Stuart Reges and Marty Stepp
// Modified by:      Lachlan Talento
// Date:             4/19/2022
// Course:           CS&145
// Lab:              Critters
//
// This Program will do the following: run a simulation full of different critters with
// unique set of directions to follow, and they are each trying to infect other critter
// until they are infected or they infect the rest.
//
// I got all this working, but I couldn't get the random color generator for the lion.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);

        // uncomment each of these lines as you complete these classes
        frame.add(30, Bear.class);
        frame.add(30, Lion.class);
        frame.add(30, Giant.class);
        frame.add(30, Orca.class);

        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);

        frame.start();
    }
}
