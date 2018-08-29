public class Asteroid extends Entity {
    String matter;                                        // what is the asteroid made of?
    public Asteroid(String matter) {                      // create an Asteroid
        this.matter = matter;
    }
    public void accept(EntityVisitor v) { v.visit(this); }

    public void doCollision(Asteroid e) {                 // asteroid-asteroid collision
        System.out.println("*Collision between the asteroid " + this.matter + " and asteroid " + e.matter + ".");
    }
    public void doCollision(Spaceship e) {                // asteroid-spaceship collision
        System.out.println("*Collision between the asteroid " + this.matter + " and the spaceship " + e.name);
    }

    public void doCollision(Moon e) {

    }
    //lands
    public void land(Spaceship e){

        e.land(this);
    }
    public void land(Asteroid e){
        //do nothing
    }
    public void land(Moon e){
        //do nothing
    }

    public void land (Entity e) {}

    public void doCollision (Entity e) {}



}