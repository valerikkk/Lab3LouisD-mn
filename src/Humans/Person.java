package Humans;
import Enums.NoiseLevel;
import Exceptions.LouisStackInTextureException;
import Interface.MoveInterface;
import Interface.Wearable;
import Place.Place;
import Things.*;
import Place.PlacesName;
import Things.Magazines;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements MoveInterface {
    private final String name;
    private Place location;
    private int x;
    private int y;
    private int z;
    private int Speed;
    private final Conscience conscience;
    private final Palms palms;
    private final List<Wearable> clothes = new ArrayList<>();
    private final Trousers trousers;
    private final Shirt shirt;
    private static int callCounter = 0;
    private StatusSleeping statusSleeping;
    private final List<Condition> condition;
    public Person(String name, Place location, int x, int y, int z){
        this.name = name;
        this.location = location;
        this.x = x;
        this.y = y;
        this.z = z;
        this.condition = new ArrayList<>();
        conscience = new Conscience();
        palms = new Palms();
        shirt = new Shirt(228);
        trousers = new Trousers(333);
        addClothe(shirt);
        addClothe(trousers);
    }
    public class Conscience{
        private final List<Object> triggers = new ArrayList<>();
        public void addTrigger(Object trigger){
            triggers.add(trigger);
        }
        public void removeTrigger(Object trigger){
            triggers.remove(trigger);
        }
        public List<Object> getTriggers(){
            return triggers;
        }
    }
    public class Palms{
        String statusPalms = "normal";
        public void getDirty(Dust dust, Bark bark){
            if (bark.getStateBark().equals(Bark.StateBark.showered)){
                setStatusPalms(dust.getColor());
            }
            else{
               setStatusPalms("clean");
            }
        }
        public String getStatusPalms(){
            return statusPalms;
        }
        public void setStatusPalms(String statusPalms){
            this.statusPalms = statusPalms;
        }
    }
    public enum Condition{
        scared, withoutIncident, hastily, depressed, nervous
    }
    public List<Condition> getCondition(){
        return condition;
    }
    public void addCondition(Condition condition){
        this.condition.add(condition);
    }
    public void removeCondition(Condition condition){
        this.condition.remove(condition);
    }
    public String getName(){
        return name;
    }
    public Place getLocation(){
        return location;
    }
    public void setLocation(Place location){
        setX(location.getX());
        setY(location.getY());
        setZ(location.getZ());
        this.location = location;
    }
    public int getX() {return x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setZ(int z){this.z = z;}
    public int getZ() {
        return z;
    }
    public int getSpeed() {
        return Speed;
    }
    public void setSpeed(int speed) {
        Speed = speed;
    }
    public void lookAround(Place place, Conscience conscience){
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            if(getCallCounter()== 0) {
                if (getLocation() == place){
                    conscience.addTrigger("I see in lawn:");
                    conscience.addTrigger(place.getContent());
                    conscience.addTrigger("Pathway to the thicket...");
                    think();
                    setCallCounter(getCallCounter()+1);
                }
            }else if (getCallCounter() == 1) {
                conscience.addTrigger("Palms are: " + getPalms().getStatusPalms());
                place.setNoiseLevel(NoiseLevel.silence);
                toHear();
                setCallCounter(getCallCounter()+1);
            }
            else if(callCounter == 2){
                if(place.getVisibilityCoefficient() <1){
                    conscience.addTrigger("Omg, why i can't see nothing?");
                    conscience.addTrigger("Louis, are you sure, that it's all?");
                }
            }
        }
        else{
            System.err.printf("%n%s is sleeping Zzzz", getName());
        }
    }
    public Conscience getConscience() {
        return conscience;
    }
    public List<Wearable> getClothes() {
        return clothes;
    }
    public void addClothe(Wearable clothe){
        if(!getClothes().contains(clothe)){
            clothes.add(clothe);
            shirt.setShirtStatus(Shirt.ShirtStatus.refueled);
            trousers.setTrousersStatus(Trousers.TrousersStatus.takedOff);
        }
    }
    public void removeClothe(Wearable clothe){
        if(getClothes().contains(clothe)){
            clothes.remove(clothe);
            trousers.setTrousersStatus(Trousers.TrousersStatus.takedOff);
            shirt.setShirtStatus(Shirt.ShirtStatus.takedOff);
        }
    }
    public Palms getPalms() {
        return palms;
    }
    public static int getCallCounter() {
        return callCounter;
    }
    public static void setCallCounter(int callCounter) {
        Person.callCounter = callCounter;
    }

    public StatusSleeping getStatusSleeping() {
        return statusSleeping;
    }

    public void setStatusSleeping(StatusSleeping statusSleeping) {
        this.statusSleeping = statusSleeping;
    }

    @Override
    public void goTo(Place place) {
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            setLocation(place);
            setX(place.getX());
            setY(place.getY());
            setZ(place.getZ());
        }
        else{
            System.err.printf("%n%s is sleeping", getName());
        }
    }
    @Override
    public void run(Place place){
        try{
            if(getStatusSleeping()!=StatusSleeping.sleeping){
                if(getLocation()!=place){
                    System.err.println("Louis isn't in this place");
                }
                else if(getX() == place.getMaxX() | getX() == place.getMinX() | getZ() == place.getMaxZ() | getZ() == place.getMinZ()){
                    System.out.printf("%s onTheEdgeOfTheLocation", getName());
                }
                else{
                    while(getX() <= place.getMaxX()){
                        setX(getX()+getSpeed());
                        if(getLocation().equals(place)&&(getX()>place.getMaxX() | getX()<place.getMinX())){
                            throw new LouisStackInTextureException("Louis stacked in textures.");
                        }
                    }
                }
            }
            else{
                System.err.printf("%n maybe %s could get up...", getName());
            }
        }
        catch(LouisStackInTextureException exception){
            System.out.printf("%n%s can't run out of limit %s", getName(), place.getPlace());
            setX(place.getMaxX());
        }
    }
    @Override
    public void climbTo(Place fromWhere, Place toWhere) {
        if(fromWhere.getPlace() == PlacesName.pit | toWhere.getPlace() == PlacesName.lawn &&getStatusSleeping()!=StatusSleeping.sleeping){
            run(fromWhere);
            getPalms().getDirty(new Dust("brown"), new Bark());
            shirt.climbOut();
            setLocation(toWhere);
        }
        else if(fromWhere.getPlace() == PlacesName.lawn | toWhere.getPlace() == PlacesName.pit) {
            setLocation(toWhere);
        }
        else{
            System.out.printf("%n%s can't climb now.", getName());
            System.exit(404);
        }
    }
    public void think(){
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            if(getCondition().contains(Condition.scared)){
                conscience.addTrigger(getName() + ",please ignore this horror");
            }
            if(getCondition().contains(Condition.nervous)){
                conscience.addTrigger("I'm sleepwalker? What if it will repeat?");
            }
        }
        else{
            System.err.printf("%n%s can't think while sleeping", getName());
        }
    }
    public enum StatusSleeping{
        sleeping, wakeUp, cantFallAsleep
    }
    public void sleep(){
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            removeClothe(shirt);
            removeClothe(trousers);
            setStatusSleeping(StatusSleeping.sleeping);
            conscience.getTriggers().removeAll(conscience.getTriggers());
            System.out.println("Zzz");
        }
    }
    public void beWake(){
        setStatusSleeping(StatusSleeping.cantFallAsleep);
        condition.removeAll(getCondition());
        addCondition(Condition.nervous);
        think();
    }
    public void flipThrough(Magazines magazines){
        if(magazines.getStatus().equals(Magazines.Status.unread) && getStatusSleeping()!=StatusSleeping.sleeping){
            magazines.setStatus(Magazines.Status.read);
        }
        else{
            System.out.printf("%nTry to turn over %s or to wake up.%n", magazines.getTitle());
        }
    }
    public void getUp(){
        if(getStatusSleeping()==StatusSleeping.sleeping){
            setStatusSleeping(StatusSleeping.wakeUp);
            addClothe(shirt);
            addClothe(trousers);
            conscience.addTrigger("I wake, i am alive");
        }else{
            System.err.printf("%n%s is already wake up", getName());
        }
    }
    public void say(String message){
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            System.out.printf("%n-%s",message);
        }
        else{
            System.err.printf("%n%s is sleeping", getName());
        }
    }
    public void toHear(){
        if(getStatusSleeping()!=StatusSleeping.sleeping){
            if(getLocation().getNoiseLevel() == NoiseLevel.high){
                removeCondition(Condition.depressed);
                addCondition(Condition.hastily);
                addCondition(Condition.scared);
                setSpeed(3);
            }else if (getLocation().getNoiseLevel() == NoiseLevel.silence) {
                removeCondition(Condition.hastily);
                addCondition(Condition.depressed);
                setSpeed(1);
            }
            else{
                condition.removeAll(getCondition());
                addCondition(Condition.withoutIncident);
                setSpeed(2);
            }
        }else{
            System.err.printf("%n%s is sleeping", getName());
        }
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    public void turnLight(Place place){
        if(place.getPlace() == PlacesName.bedroom && place.getLightCoefficient()==1){
            place.setLightCoefficient(0);
        }
        else{
            System.out.printf("%s can't turn light%n", getName());
        }
    }
    @Override
    public String toString(){
        return "Person {name = "
                + name + ", gender = "
                + ", place = "
                + location + "}";
    }
}
