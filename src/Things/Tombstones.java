package Things;

import Place.PlacesName;

public class Tombstones extends Thing {
    public Tombstones(String title){
        super(title, PlacesName.lawn);
    }
    @Override
    public String toString() {
        return "Tombstone: " + getTitle();
    }
}
