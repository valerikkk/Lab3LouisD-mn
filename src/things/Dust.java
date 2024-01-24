package things;

import interfaces.Locatable;
import place.PlacesName;

public class Dust extends Thing implements Locatable{
    private final String color;
    public Dust(String color){
        super(PlacesName.forest);
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    @Override
    public String getTitle(){
        return getColor() + " dust";
    }
}