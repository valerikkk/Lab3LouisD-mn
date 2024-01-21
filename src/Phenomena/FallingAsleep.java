package Phenomena;

import Humans.Person;
import Place.PlacesName;
import Place.Place;

import java.util.concurrent.TimeUnit;

public class FallingAsleep extends Phenomena{
    public FallingAsleep(){
        super("falling asleep", PlacesName.house);
    }
    public void waitInTime(Person person){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("%n1 minute past. %s lay%n", person.getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("2 minutes past.%n");
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("3 minutes past. %s scratched his groin.%n", person.getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("4 minutes past.%n");
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("5 minutes past. %s thought about the concept of happiness.%n", person.getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("6 minutes past.%n");
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("7 minutes past.%n");
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("8th minute began. %s felt asleep%n", person.getName());
        }
        catch(InterruptedException exception){
            throw new RuntimeException(exception);
        }
    }
    @Override
    public void begin(Place place, Person person){
        waitInTime(person);
        person.setStatusSleeping(Person.StatusSleeping.sleeping);
    }
}
