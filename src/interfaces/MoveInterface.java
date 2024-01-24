package interfaces;
import exceptions.PersonIsAlreadyInPlace;
import place.Place;
public interface MoveInterface {
    void goTo(Place place) throws PersonIsAlreadyInPlace;
    void run(Place place);
    void climbTo(Place fromWhere, Place toWhere);
}