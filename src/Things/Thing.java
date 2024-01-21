package Things;
import Interface.Locatable;
import Place.PlacesName;
public class Thing implements Locatable{
    private final String title;
    private final PlacesName location;
    protected Thing(String title, PlacesName location){
        this.title = title;
        this.location = location;
    }
    @Override
    public String getTitle(){
        return title;
    }
    public PlacesName getLocation(){
        return location;
    }
}
