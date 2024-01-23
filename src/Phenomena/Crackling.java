package Phenomena;
import Enums.NoiseLevel;
import Humans.Person;
import Place.PlacesName;
import Place.Place;

public class Crackling extends Phenomena{
    public Crackling(){
        super(PlacesName.forest);
    }
    public void begin(Place place, Person person){
        if(place.getPlace() == PlacesName.pit | place.getPlace() == PlacesName.lawn){
            System.out.printf("%nCshse... Tschz...");
            if(person.getLocation().equals(place)){
                place.setNoiseLevel(NoiseLevel.high);
                person.toHear();
            }else{
                System.out.printf("%n%s can't hear this", person.getName());
            }
        } else{
            System.out.printf("%n rang out in other place");
        }
    }
}
