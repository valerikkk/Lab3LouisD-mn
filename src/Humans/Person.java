package Humans;
import Enums.NoiseLevel;
import Exceptions.ShirtStatusException;
import Interface.MoveInterface;
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
    private final Clothe[] clothes = new Clothe[2];
    private final Trousers trousers;
    private final Shirt shirt;
    private static int callCounter = 0;
    private StatusSleeping statusSleeping;
    public Person(String name, Place location, int x, int y, int z){
        this.name = name;
        this.location = location;
        this.x = x;
        this.y = y;
        this.z = z;
        conscience = new Conscience();
        palms = new Palms();
        shirt = new Shirt(228);
        trousers = new Trousers(333);
        clothes[0] = shirt;
        clothes[1] = trousers;
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
            if (bark.getStateBark().equals(Bark.StateBark.showered.stateBark)){
                setStatusPalms(dust.getColor());
            }
            else{
               setStatusPalms("clean");
            }
        }
        public String getTitle(){
            return "palms";
        }
        public String getStatusPalms(){
            return statusPalms;
        }
        public void setStatusPalms(String statusPalms){
            this.statusPalms = statusPalms;
        }
    }
    public enum Condition{
        scared("scared"), withoutIncident("without incident"), hastily("hastily"), depressed("depressed"), nervous("nervous");
        public final String condition;
        Condition(String condition){
            this.condition = condition;
        }
        public String getCondition(){
            return condition;
        }
    }
    private final List<String> condition = new ArrayList<>();
    public List<String> getCondition(){
        return condition;
    }
    public void addCondition(String condition){
        this.condition.add(condition);
    }
    public void removeCondition(String condition){
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
        if(getCallCounter()== 0) {
            if (getLocation() == place) {
                conscience.addTrigger(place.getContent());
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
    public Clothe[] getClothes() {
        return clothes;
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
            setLocation(place);
            setX(place.getX());
            setY(place.getY());
            setZ(place.getZ());
    }
    @Override
    public void go(Place place){
        try{
            if(getLocation()==place&&(getX()>place.getMaxX() | getX()<place.getMinX() | getZ()>place.getMaxZ() | getZ()< place.getMinZ())){
                throw new ShirtStatusException("Louis stacked in textures");
            }
            if(getX() == place.getMaxX() | getX() == place.getMinX() | getZ() == place.getMaxZ() | getZ() == place.getMinZ()){
                System.out.printf("%s onTheEdgeOfTheLocation", getName());
            }
            else{
                while(getX() != place.getMaxX()){
                    setX(getX()+getSpeed());
                }
            }
        }
        catch(ShirtStatusException exception){
            System.out.printf("%n%s outside of %s", getName(), place.getPlace());
        }
    }
    @Override
    public void climbTo(Place fromWhere, Place toWhere) {
        if(fromWhere.getPlace() == PlacesName.pit | toWhere.getPlace() == PlacesName.lawn){
            go(fromWhere);
//            System.out.printf("%s began to climb.", getName());
            getPalms().getDirty(new Dust("brown"), new Bark());
            shirt.climbOut(trousers);
            setLocation(toWhere);
        }
        else if(fromWhere.getPlace() == PlacesName.lawn | toWhere.getPlace() == PlacesName.pit) {
//            System.out.printf("%s began to go down.%n", getName());
            setLocation(toWhere);
        }
        else{
            System.out.printf("%n%s can't climb here.", getName());
            System.exit(404);
        }
    }
    public void think(){
        if(getCondition().contains(Condition.scared.getCondition())){
            conscience.addTrigger(getName() + ",please ignore this horror");
        }
        if(getCondition().contains(Condition.nervous.getCondition())){
            conscience.addTrigger("I'm sleepwalker? What if it will repeat?");
        }
    }
    public enum StatusSleeping{
        sleeping, wakeUp, cantFallAsleep
    }
    public void sleep(){
        shirt.setShirtStatus(Shirt.ShirtStatus.takedOff);
        setStatusSleeping(StatusSleeping.sleeping);
        conscience.getTriggers().removeAll(conscience.getTriggers());
        System.out.println("Zzz");
    }
    public void beWake(){
        setStatusSleeping(StatusSleeping.cantFallAsleep);
        condition.removeAll(getCondition());
        addCondition(Condition.nervous.getCondition());
        think();
    }
    public void flipThrough(Magazines magazines){
        magazines.setStatus(Magazines.Status.read);
    }
    @Override
    public void standUp(){
        setStatusSleeping(StatusSleeping.wakeUp);
        conscience.addTrigger("I wake, i am alive");
    }
    public void say(String message){
        System.out.printf("%n-%s",message);
    }
    public void toHear(){
        if(getLocation().getNoiseLevel() == NoiseLevel.high){
            condition.removeAll(getCondition());
            addCondition(Condition.hastily.getCondition());
            addCondition(Condition.scared.getCondition());
            setSpeed(3);
        }else if (getLocation().getNoiseLevel() == NoiseLevel.silence) {
            condition.removeAll(getCondition());
            addCondition(Condition.depressed.getCondition());
            setSpeed(1);
        }
        else{
            condition.removeAll(getCondition());
            addCondition(Condition.withoutIncident.getCondition());
            setSpeed(2);
        }
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    public void turnLight(Place place){
        if(place.getPlace() == PlacesName.bedroom){
            place.setLightCoefficient(0);
        }
        else{
            System.out.printf("%s can't turn light here%n", getName());
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
