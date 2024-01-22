package Things;

import Interface.Wearable;

public class Trousers extends Clothe implements Wearable {
    public Trousers(int barCode){
        super(barCode);
    }
    @Override
    public String getTitle(){
        return "trousers";
    }
}
