package Interface;
import Place.Place;
public interface MoveInterface {
    void goTo(Place place);
    void run(Place place);
    void climbTo(Place fromWhere, Place toWhere);
}
