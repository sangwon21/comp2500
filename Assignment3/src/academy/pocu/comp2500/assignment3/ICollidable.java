package academy.pocu.comp2500.assignment3;

public interface ICollidable {
    void collide(Unit unit);

    IntVector2D getPosition();
}
