import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main
{
    public static List<Entity> pickNRandom(ArrayList<Entity> list, int n) {

        ArrayList<Entity> copy = new ArrayList<Entity>(list);
        Collections.shuffle(copy);

        return copy.subList(0, n);

    }

    public static void execute_collisions(ArrayList<Entity> things_to_destroy) {

        for (int i = 0; i < 6; i++) {
            List<Entity> things = pickNRandom(things_to_destroy, 2);
            Entity e1 = things.get(0);
            Entity e2 = things.get(1);
            EntityVisitor ev = new CollidesWithVisitor(e2);
            e1.accept(ev);
        }
    }

    public static void execute_landings(ArrayList<Entity> things_to_conquer) {


        for(int i = 0; i < 6; i++) {
            List<Entity> things = pickNRandom(things_to_conquer, 2);
            Entity e1 = things.get(0);
            Entity e2 = things.get(1);
            EntityVisitor ev = new LandsWithVisitor(e2);
            e1.accept(ev);
        }
    }

    public static void main(String[] args) {

        ArrayList<Entity> objects1 = new ArrayList<Entity>();

        java.util.Vector<String> pass1 = new java.util.Vector<String>();
        java.util.Vector<String> pass2 = new java.util.Vector<String>();
        java.util.Vector<String> pp1 = new java.util.Vector<String>();
        java.util.Vector<String> pp2 = new java.util.Vector<String>();

        pass1.add("Mr. X"); pass1.add("Ms. Y");
        pass2.add("Mr. Q"); pass2.add("Ms. R");
        pp1.add("Mr. M"); pp1.add("Ms. N");
        pp2.add("Mr. J"); pp2.add("Ms. K");

        objects1.add(new Asteroid("rock")); objects1.add(new Asteroid("ice and dirt"));
        objects1.add(new Spaceship("Relativity", pass1)); objects1.add(new Spaceship("Endaevour", pass2));
        objects1.add(new Moon("Phobos", pp1)); objects1.add(new Moon("Deimos", pp2));

        //randomly apply collisions
        execute_collisions(objects1);

        System.out.println("--------------------------------------------------------");
        System.out.println();

        ArrayList<Entity> objects2 = new ArrayList<Entity>();

        java.util.Vector<String> pass3 = new java.util.Vector<String>();
        java.util.Vector<String> pass4 = new java.util.Vector<String>();
        java.util.Vector<String> pp3 = new java.util.Vector<String>();
        java.util.Vector<String> pp4 = new java.util.Vector<String>();

        pass3.add("Qbert"); pass3.add("Marvin");
        pass4.add("Mr. Q"); pass4.add("Ms. R");
        pp3.add("Pacman"); pp3.add("Inky");
        pp4.add("Neo"); pp4.add("Trinity");

        objects2.add(new Asteroid("diamond")); objects2.add(new Asteroid("uranium"));
        objects2.add(new Spaceship("Andromeda", pass3)); objects2.add(new Spaceship("Steve", pass4));
        objects2.add(new Moon("Phobos", pp3)); objects2.add(new Moon("Deimos", pp4));

        //randomly apply landings
        execute_landings(objects2);



    }
}
