package Interface;
import Place.PlacesName;
import Place.Place;
public interface MoveInterface {
    public void goTo(Place place);
    public void go(Place place);
    public void climbTo(Place fromWhere, Place toWhere);
    public void standUp();
}
