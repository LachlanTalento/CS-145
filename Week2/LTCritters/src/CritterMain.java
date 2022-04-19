// Original Authors: Stuart Reges and Marty Stepp
// Modified by:      Lachlan Talento
// Date:             4/19/2022
// Course:           CS&145
// Lab:              Critters
//
// This Program will do the following:
//
// I got all this working, but I couldn't do this...
//
// For my Orca AI I...

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);

        // uncomment each of these lines as you complete these classes
        // frame.add(30, Bear.class);
        // frame.add(30, Lion.class);
        // frame.add(30, Giant.class);
        // frame.add(30, Husky.class);

        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);

        frame.start();
    }
}
