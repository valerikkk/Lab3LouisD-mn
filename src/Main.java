
import Humans.Person;
import Phenomena.Crackling;
import Phenomena.FallingAsleep;
import Phenomena.Fog;
import Place.Forest;
import Place.House;
import Place.PlacesName;
import Things.*;

public class Main {
    public static void main(String[] args) {
        //Создание объектов местностей
        Forest forest = new Forest();
        Forest.Lawn lawn = forest.new Lawn();
        Forest.Pit pit = new Forest.Pit();
        Forest.Pathway pathToThicket = new Forest.Pathway(forest.getX(), forest.getY(), forest.getZ(), forest.getMaxX()-40);
        House house = new House();
        Forest.Pathway pathToHouse = new Forest.Pathway(forest.getX(), 0, forest.getZ(), house.getMaxX()- forest.getX());
        House.Bedroom bedroom = house.new Bedroom();
        //Создание объектов персон
        Person louis = new Person("Louis", lawn, pit.getMaxX(), lawn.getY(), pit.getMaxZ());
        Person rachel = new Person("Rachel", house, house.getX()+4, house.getY(), house.getZ()+3);
        //Создание объектов вспомогательных предметов
        Tree tree = new Tree("beryozzzza", PlacesName.forest);
        Bark bark = new Bark();
        Tombstones tombstone = new Tombstones("tombstones");
        //Создание объектов явлений
        Crackling crackling = new Crackling();
        FallingAsleep fallingAsleep = new FallingAsleep();
        Fog fog = new Fog();
        Stonehendge stonehendge = new Stonehendge();
        Magazines magazines = new Magazines();
        tree.showerBark(bark);
        crackling.begin(lawn, louis);
        louis.lookAround(lawn, louis.getConscience());
        pathToThicket.toLead(PlacesName.thicket);
        louis.climbTo(louis.getLocation(), pit);
        crackling.begin(pit, louis);
        louis.climbTo(louis.getLocation(), lawn);
        louis.goTo(pathToHouse);
        louis.lookAround(lawn, louis.getConscience());
        fog.begin(lawn);
        fog.create(stonehendge);
        pathToHouse.toLead(PlacesName.house);
        louis.lookAround(lawn, louis.getConscience());
        louis.goTo(house);
        louis.beWake();
        rachel.sleep();
        louis.flipThrough(magazines);
        rachel.standUp();
        rachel.say("Lou? Darling, are you coming?");
        louis.say( "Now");
        louis.turnLight(bedroom);
        fallingAsleep.begin(house, louis);
    }
}