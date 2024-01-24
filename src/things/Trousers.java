package things;

import interfaces.Wearable;

public class Trousers extends Clothe implements Wearable {
    private TrousersStatus trousersStatus;
    public Trousers(int barCode){
        super(barCode);
        trousersStatus = TrousersStatus.wearing;
    }
    @Override
    public int getBarCodes(){
        return getBarCode();
    }
    public enum TrousersStatus{
        wearing, takenOff
    }
    public TrousersStatus getTrousersStatus() {
        return trousersStatus;
    }
    public void setTrousersStatus(TrousersStatus trousersStatus) {
        this.trousersStatus = trousersStatus;
    }
}