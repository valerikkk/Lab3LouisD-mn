package humans;
import enums.NoiseLevel;
import exceptions.LouisStackInTextureException;
import exceptions.PersonIsAlreadyInPlace;
import interfaces.CheckingAbilityAction;
import interfaces.MoveInterface;
import interfaces.Wearable;
import place.Place;
import things.*;
import place.PlacesName;
import things.Magazines;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements MoveInterface, CheckingAbilityAction {
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
        addCondition(Condition.withoutIncident);
    }
    public class Conscience{
        private final List<Object> triggers = new ArrayList<>();
        public void addTrigger(Object trigger){
            triggers.add(trigger);
        }
        public List<Object> getTriggers(){
            return triggers;
        }
    }
    public class Palms{
        String statusPalms = "normal";
        public void getDirty(Dust dust, Tree.Bark bark){
            if (bark.getStateBark().equals(Tree.Bark.StateBark.showered)){
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
        checkAbilityAction(this);
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
    public Conscience getConscience() {
        return conscience;
    }
    public List<Wearable> getClothes() {
        return clothes;
    }
    public void addClothe(Wearable clothe){
        if(!getClothes().contains(clothe)){
            if(shirt.getBarCodes()== clothe.getBarCodes() | trousers.getBarCodes()==clothe.getBarCodes() && trousers.getTrousersStatus() == Trousers.TrousersStatus.takenOff){
                clothes.add(clothe);
                shirt.setShirtStatus(Shirt.ShirtStatus.refueled);
                trousers.setTrousersStatus(Trousers.TrousersStatus.wearing);
            }
        }
    }
    public void removeClothe(Wearable clothe){
        if(getClothes().contains(clothe)){
            clothes.remove(clothe);
            trousers.setTrousersStatus(Trousers.TrousersStatus.takenOff);
            shirt.setShirtStatus(Shirt.ShirtStatus.takenOff);
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
    public void goTo(Place place) throws PersonIsAlreadyInPlace {
        if(getLocation()==place){
            throw new PersonIsAlreadyInPlace("Is already in this place");
        }
        else{
            checkAbilityAction(this);
            setLocation(place);
            setX(place.getX());
            setY(place.getY());
            setZ(place.getZ());
        }
    }
    @Override
    public void run(Place place){
        try{
                checkAbilityAction(this);
                if(getLocation()!=place){
                    System.err.println(this.getName() + " isn't in this place");
                }
                else if(getX() == place.getMaxX() | getX() == place.getMinX() | getZ() == place.getMaxZ() | getZ() == place.getMinZ() | getY()<-20){
                    System.out.printf("%s onTheEdgeOfTheLocation", getName());
                }
                else{
                    while(getX()<place.getMaxX()){
                        setX(getX()+getSpeed());
                        if(getLocation().equals(place)&&(getX()>place.getMaxX() | getX()<place.getMinX())){
                            throw new LouisStackInTextureException(this.getName() + " stacked in textures.");
                        }
                    }
                }
        }
        catch(LouisStackInTextureException exception){
            System.out.printf("%n%s can't run out of limit %s", getName(), place.getPlace());
            setX(place.getMaxX());
        }
    }
    @Override
    public void climbTo(Place fromWhere, Place toWhere) {
        checkAbilityAction(this);
        if(fromWhere.getPlace() == PlacesName.pit | toWhere.getPlace() == PlacesName.lawn){
            run(fromWhere);
            getPalms().getDirty(new Dust("brown"), new Tree.Bark());
            shirt.climbOut();
            setLocation(toWhere);
        }
        else if(fromWhere.getPlace() == PlacesName.lawn && toWhere.getPlace() == PlacesName.pit) {
            setLocation(toWhere);
        }
        else{
            System.err.printf("%n%s can't climb here.", getName());
        }
    }
    public void think(){
            checkAbilityAction(this);
            if(getCondition().contains(Condition.scared)){
                conscience.addTrigger(getName() + ",please ignore this horror");
            }
            if(getCondition().contains(Condition.nervous)){
                conscience.addTrigger("I'm sleepwalker? What if it will repeat?");
            }
    }
    public enum StatusSleeping{
        sleeping, wakeUp, cantFallAsleep
    }
    public void sleep(){
        checkAbilityAction(this);
            removeClothe(shirt);
            removeClothe(trousers);
            setStatusSleeping(StatusSleeping.sleeping);
            conscience.getTriggers().removeAll(conscience.getTriggers());
            System.out.println("Zzz");
    }
    public void beWake(){
        setStatusSleeping(StatusSleeping.cantFallAsleep);
        condition.removeAll(getCondition());
        addCondition(Condition.nervous);
        think();
    }
    public void flipThrough(Magazines magazines){
        checkAbilityAction(this);
        if(magazines.getStatus().equals(Magazines.Status.unread) && getLocation().getPlace() == magazines.getLocation()){
            magazines.setStatus(Magazines.Status.read);
        }
        else{
            System.out.printf("%nTry to turn over %s.%n", magazines.getTitle());
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
    public void sayTo(Person person, String message){
        checkAbilityAction(this);
        if(person.hashCode()!=this.hashCode()){
            System.out.printf("%n-%s",message);
        }
        else{
            System.err.printf("%n%s has schizophrenia", this.getName());
        }
    }
    public void toHear(){
            checkAbilityAction(this);
            if(getLocation().getNoiseLevel() == NoiseLevel.high){
                removeCondition(Condition.withoutIncident);
                if(!getCondition().contains(Condition.hastily) && !getCondition().contains(Condition.scared)){
                    addCondition(Condition.hastily);
                    addCondition(Condition.scared);
                }
                setSpeed(3);
            }else if (getLocation().getNoiseLevel() == NoiseLevel.silence){
                removeCondition(Condition.hastily);
                removeCondition(Condition.withoutIncident);
                if(!getCondition().contains(Condition.depressed)){
                    addCondition(Condition.depressed);
                }
                setSpeed(1);
            }
            else{
                condition.removeAll(getCondition());
                addCondition(Condition.withoutIncident);
                setSpeed(2);
            }
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    public void turnLight(Place place){
        checkAbilityAction(this);
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