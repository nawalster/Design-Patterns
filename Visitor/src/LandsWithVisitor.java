public class LandsWithVisitor extends EntityVisitor {

    Entity secondEntity;                                // second argument
    LandsWithVisitor(Entity secondEntity) {          // construct, remember second argument
        this.secondEntity = secondEntity;
    }

    public void visit(Asteroid asteroid) {              // asteroid lands with a ??
        secondEntity.land(asteroid);               // determine what secondEntity is
    }

    public void visit(Spaceship spaceship) {            // spaceship lands with a ??
        secondEntity.land(spaceship);              // determine what secondEntity is
    }

    public void visit(Moon moon){
        secondEntity.land(moon);
    }
}
