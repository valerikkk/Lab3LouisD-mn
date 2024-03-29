package things;

import exceptions.ShirtStatusException;
import interfaces.Wearable;

public class Shirt extends Clothe implements Wearable {
    private ShirtStatus shirtStatus;
    public Shirt(int barCode){
        super(barCode);
        setShirtStatus(ShirtStatus.refueled);
    }
    public enum ShirtStatus{
            refueled, outwards, takenOff
    }
    public ShirtStatus getShirtStatus() {
        return shirtStatus;
    }

    public void setShirtStatus(ShirtStatus shirtStatus) {
        this.shirtStatus = shirtStatus;
    }

    public void climbOut(){
        try{
            if(this.getShirtStatus() == ShirtStatus.outwards){
                throw new ShirtStatusException("Shirt is already in trousers.");
            }
            setShirtStatus(ShirtStatus.outwards);
        }
        catch(ShirtStatusException exception){
            System.out.println("Shirt cannot climb out second time");
        }
    }
    @Override
    public int getBarCodes(){
        return getBarCode();
    }
}