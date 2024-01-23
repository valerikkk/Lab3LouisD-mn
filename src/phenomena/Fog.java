package phenomena;

import humans.Person;
import Interface.Locatable;
import place.PlacesName;
import things.Thing;
import place.Place;
public class Fog extends Phenomena{
    public Fog() {
        super(PlacesName.lawn);
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
