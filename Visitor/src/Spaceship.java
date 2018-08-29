public class Spaceship extends Entity {
    String name;                                                    // name of spaceship
    java.util.Vector<String> passengers;                            // names of passengers
    public Spaceship(String name, java.util.Vector<String> pass) {  // create a Spaceship
        this.name = name;
        this.passengers = pass;
    }
    public void accept(EntityVisitor v) { v.visit(this); }

    public void doCollision(Asteroid e) {                           // spaceship-asteroid collision
        e.doCollision(this);                                          // call asteroid-spaceship collision
    }
    public void doCollision(Spaceship e) {                          // spaceship-spaceship collision
        //System.out.println("Collision between the spaceships " + this.name + " and " + e.name + ". Casualties:");

        if(this.passengers.size() > 0 || e.passengers.size() > 0) {
            System.out.println("*Catastrophic collision between spaceship " + this.name + " and spaceship" + e.name + ".");
            //concatenate lists?
            System.out.println("Casualties: " + (this.passengers.size() + e.passengers.size()));
            for (String p : this.passengers) System.out.print("\t" + p.toString());
            for (String p : e.passengers) System.out.print("\t" + p.toString());
            System.out.println();

        }
       this.passengers.clear();
       e.passengers.clear();
    }

    public void doCollision(Moon e) {                          // spaceship-spaceship collision
        System.out.println("*Catastrophic collision between spaceship " + this.name + " and moon " + e.name + ".");

        java.util.Vector<String> corpses = this.passengers;
        if(e.people.size() > 0) {
            corpses.add(e.people.remove(0)); //remove moon death count and add to spaceship death count
            System.out.println("Casualties: " + corpses.size());
        }

        this.passengers.clear();
    }

    //land
    public void land(Asteroid e){
        System.out.println("*Spaceship " + this.name + " landed on asteroid made up of " + e.matter + ".");

        if(this.passengers.size() > 0){
            System.out.println("The passengers: [");
            for (String p : this.passengers) System.out.print("\t" + p.toString());
            System.out.print("] ");
            System.out.println("pick up some " + e.matter);
        }
    }

    public void land(Moon e){
        System.out.println("*Spaceship " + this.name + " landed on moon  " + e.name + ".");

        if(this.passengers.size() > 0){
            String defector = this.passengers.remove(0);
            System.out.println(defector + " has left the spaceship " + this.name + ", and is setting up a farm on the moon " + e.name);
            e.people.add(defector);
            System.out.println();
        }
    }

    public void land(Spaceship e){
        //do nothing
    }

    public void land (Entity e) {}




}
