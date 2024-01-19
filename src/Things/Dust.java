package Things;

import Place.PlacesName;

public class Dust extends Thing{
    private final String color;
    public Dust(String color){
        super("dust", PlacesName.forest);
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
