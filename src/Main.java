import humans.Person;
import phenomena.Crackling;
import phenomena.Fog;
import phenomena.Phenomena;
import place.Forest;
import place.House;
import place.Place;
import place.PlacesName;
import things.*;

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        Forest.Lawn lawn = new Forest.Lawn();
        Tree tree = new Tree("brushwood", PlacesName.lawn);
        tree.showerBark();
        Forest.Pit pit = new Forest.Pit();
        Forest.Pathway pathToThicket = new Forest.Pathway(forest.getX(), forest.getY(), forest.getZ(), forest.getMaxX()-40);
        House house = new House();
        Forest.Pathway pathToHouse = new Forest.Pathway(forest.getX(), 0, forest.getZ(), house.getMaxX()- forest.getX());
        House.Bedroom bedroom = house.new Bedroom();
        Person louis = new Person("Louis", lawn, pit.getMaxX(), lawn.getY(), pit.getMaxZ());
        Person rachel = new Person("Rachel", house, house.getX()+4, house.getY(), house.getZ()+3);
        Crackling crackling = new Crackling();
        Fog fog = new Fog();
        Magazines magazines = new Magazines("Medical journey");

        crackling.begin(lawn, louis);
        louis.lookAround(lawn, louis.getConscience());
        pathToThicket.toLead(PlacesName.thicket);
        louis.climbTo(louis.getLocation(), pit);
        crackling.begin(pit, louis);
        louis.climbTo(louis.getLocation(), lawn);
        louis.goTo(pathToHouse);
        louis.lookAround(lawn, louis.getConscience());
        System.out.println(louis.getConscience().getTriggers());
        fog.begin(lawn, louis);
        pathToHouse.toLead(PlacesName.house);
        louis.lookAround(lawn, louis.getConscience());
        louis.goTo(house);
        louis.goTo(bedroom);
        louis.beWake();
        rachel.sleep();
        louis.flipThrough(magazines);
        rachel.getUp();
        rachel.say("Lou? Darling, are you coming?");
        louis.say("Now");
        louis.turnLight(bedroom);
        Phenomena fallingAsleep = new Phenomena(PlacesName.house) {
            @Override
            public void begin(Place place, Person person) {
                int time = 0;
                System.out.printf("%n%s lied", person.getName());
                while(time<8){
                    time++;
                    System.out.printf("%n%s minutes past",time);
                }
                System.out.printf("%n%s felt asleep%n", person.getName());
                person.sleep();
            }
        };
        fallingAsleep.begin(house, louis);
    }
}