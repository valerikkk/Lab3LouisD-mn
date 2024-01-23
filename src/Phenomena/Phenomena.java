package Phenomena;
import Humans.Person;
import Place.Place;
import Place.PlacesName;

import java.util.Objects;

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

