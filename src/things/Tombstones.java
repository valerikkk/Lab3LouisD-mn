package things;

import interfaces.Locatable;
import place.PlacesName;

public class Tombstones extends Thing implements Locatable{
    private final String title;
    public Tombstones(String title){
        super(PlacesName.lawn);
        this.title = title;
    }
    @Override
    public String toString() {
        return "Tombstone: " + getTitle();
    }
    @Override
    public String getTitle(){
        return title;
    }
}