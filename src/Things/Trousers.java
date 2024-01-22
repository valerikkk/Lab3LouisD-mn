package Things;

import Interface.Wearable;

public class Trousers extends Clothe implements Wearable {
    private TrousersStatus trousersStatus;
    public Trousers(int barCode){
        super(barCode);
        trousersStatus = TrousersStatus.wearing;
    }
    @Override
    public String getTitle(){
        return "trousers";
    }
    public enum TrousersStatus{
        wearing, takedOff
    }
    public TrousersStatus getTrousersStatus() {
        return trousersStatus;
    }
    public void setTrousersStatus(TrousersStatus trousersStatus) {
        this.trousersStatus = trousersStatus;
    }
}
