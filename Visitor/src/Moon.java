public class Moon extends Entity {
    String name;
    java.util.Vector<String> people;

    public Moon(String name, java.util.Vector<String> ppl) {
        this.name = name;
        this.people = ppl;

    }

    public void accept(EntityVisitor v) { v.visit(this); }

    public void doCollision(Moon e) {                //
        //do nothing
    }

    public void doCollision(Asteroid e) {                 //
        //nothing
    }
    public void doCollision(Spaceship e) {                //
        e.doCollision(this);
    }

    //land
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