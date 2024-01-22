package Things;
import Place.PlacesName;
public class Thing{
    private final PlacesName location;
    public Thing(PlacesName location){
        this.location = location;
    }
    public PlacesName getLocation(){
        return location;
    }
}
