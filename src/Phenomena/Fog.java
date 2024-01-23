package Phenomena;

import Humans.Person;
import Interface.Locatable;
import Place.PlacesName;
import Things.Thing;
import Place.Place;
public class Fog extends Phenomena{
    public Fog() {
        super("Fog", PlacesName.lawn);
    }
    public void begin(Place place, Person person) {
        if (getPlace() == PlacesName.lawn){
            place.setHumidityCoefficient(1);
            place.setVisibilityCoefficient(0.2);
            class Silhouette extends Thing implements Locatable {
                private final String title;
                public Silhouette(String title) {
                    super(PlacesName.lawn);
                    this.title = title;
                }
                @Override
                public String getTitle(){
                    return title;
                }
            }
            Silhouette copyStonehendge = new Silhouette("Copy of Stonehendge");
            place.addContent(copyStonehendge);
        }
    }
}
