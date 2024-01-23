package Interface;
import Exceptions.PersonIsAlreadyInPlace;
import Place.Place;
public interface MoveInterface {
    void goTo(Place place) throws PersonIsAlreadyInPlace;
    void run(Place place);
    void climbTo(Place fromWhere, Place toWhere);
}
