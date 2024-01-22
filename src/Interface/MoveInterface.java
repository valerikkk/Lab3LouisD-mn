package Interface;
import Place.Place;
public interface MoveInterface {
    public void goTo(Place place);
    public void run(Place place);
    public void climbTo(Place fromWhere, Place toWhere);
    public void standUp();
}
