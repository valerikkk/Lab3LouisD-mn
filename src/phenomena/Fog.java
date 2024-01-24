package phenomena;

import enums.NoiseLevel;
import humans.Person;
import interfaces.Locatable;
import place.PlacesName;
import things.Thing;
import place.Place;
public class Fog extends Phenomena{
    public Fog() {
        super(PlacesName.lawn);
    }
    public void begin(Place place, Person person) {
        if (getPlace() == PlacesName.lawn){
            if(place.getHumidityCoefficient()<1){
                place.setHumidityCoefficient(1);
            }
            place.setVisibilityCoefficient(0.2);
            place.setNoiseLevel(NoiseLevel.silence);
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
            Silhouette copyStonehenge = new Silhouette("Copy of Stonehenge");
            place.addContent(copyStonehenge);
        }
    }
}