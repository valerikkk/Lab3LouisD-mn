package Things;

import Place.PlacesName;

public class Clothe extends Thing{
    private final int barCode;
    public Clothe(int barCode){
        super("ekvnek", PlacesName.lawn);
        this.barCode = barCode;
    }
    @Override
    public int hashCode(){
        return this.barCode;
    }
}
