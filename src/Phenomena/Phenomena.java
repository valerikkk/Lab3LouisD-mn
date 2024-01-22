package Phenomena;
import Humans.Person;
import Interface.StartingInterface;
import Place.Place;
import Place.PlacesName;

import java.util.Objects;

public abstract class Phenomena{
    private final String title;
    private PlacesName placesName;
    public Phenomena(String title, PlacesName placesName){
        this.title = title;
        this.placesName = placesName;
    }
    public String getTitle(){
        return title;
    }
    public PlacesName getPlace(){
        return placesName;
    }
    @Override
    public int hashCode(){
        return Objects.hash(title);
    }
}

