package phenomena;
import humans.Person;
import place.Place;
import place.PlacesName;

public abstract class Phenomena{
    private final PlacesName placesName;
    public Phenomena(PlacesName placesName){
        this.placesName = placesName;
    }
    public PlacesName getPlace(){
        return placesName;
    }
    public abstract void begin(Place place, Person person);
}

