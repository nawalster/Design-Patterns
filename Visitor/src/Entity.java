public abstract class Entity {
    public abstract void accept(EntityVisitor v);       // Used to accept visits
    public abstract void doCollision(Asteroid e);       // collide with Asteroid
    public abstract void doCollision(Spaceship e);      // collide with Spaceship
    public abstract void doCollision(Moon e);      // collide with Spaceship
    public abstract void land(Asteroid e);       // land on Asteroid
    public abstract void land(Spaceship e);      // land on Spaceship
    public abstract void land(Moon e);      // land on Spaceship



}
