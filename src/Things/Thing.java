package Things;
import Place.PlacesName;
public class Thing {
    private final String title;
    private final PlacesName location;
    protected Thing(String title, PlacesName location){
        this.title = title;
        this.location = location;
    }
    public String getTitle(){
        return title;
    }
    public PlacesName getLocation(){
        return location;
    }
}
