package Phenomena;

import Interface.StartingInterface;
import Place.PlacesName;
import Things.Stonehendge;
import Things.Tombstones;
import Place.Place;
public class Fog extends Phenomena implements StartingInterface {
    public Fog() {
        super("Fog", PlacesName.lawn);
    }
    @Override
    public void begin(Place place) {
        if (getPlace() == PlacesName.lawn){
            place.setHumidityCoefficient(1);
            place.setVisibilityCoefficient(0.2);
        }
    }
    public void create(Stonehendge stonehendge){
        Stonehendge copyStonehendge = new Stonehendge();
    }
}
