package Phenomena;

import Humans.Person;
import Interface.StartingInterface;
import Place.PlacesName;

import Things.Thing;
import Things.Tombstones;
import Place.Place;
public class Fog extends Phenomena implements StartingInterface {
    public Fog() {
        super("Fog", PlacesName.lawn);
    }
    @Override
    public void begin(Place place, Person person) {
        if (getPlace() == PlacesName.lawn){
            place.setHumidityCoefficient(1);
            place.setVisibilityCoefficient(0.2);
        }
        create();
    }
    public void create(){
        class Stonehendge extends Thing {
            public Stonehendge() {
                super("Stonehendge", PlacesName.lawn);
            }
            void interactWithPerson(Person person){
                person.getConscience().addTrigger("Damn, what a Fog, is it Stonehendge?");
            }
        }
        Stonehendge stonehendge = new Stonehendge();
    }
}
//import Humans.Person;
//import Place.PlacesName;
//
//public class Stonehendge extends Thing{
//    public Stonehendge(){
//        super("Stonehendge", PlacesName.lawn);
//    }
//    public void interactWithPerson(Person person){
//        person.getConscience().addTrigger("");
//    }
//}