package Things;

import Exceptions.ShirtStatusException;

public class Shirt extends Clothe{
    private ShirtStatus shirtStatus = ShirtStatus.refueled;
    public Shirt(int barCode){
        super(barCode);
        title = ClothesName.shirt.getClotheTitle();
    }
    public enum ShirtStatus{
            refueled, outwards, takedOff
    }
    public ShirtStatus getShirtStatus() {
        return shirtStatus;
    }

    public void setShirtStatus(ShirtStatus shirtStatus) {
        this.shirtStatus = shirtStatus;
    }

    public void climbOut(Trousers trousers){
        try{
            if(this.getShirtStatus() == ShirtStatus.outwards){
                throw new ShirtStatusException("Shirt is already in trousers.");
            }
            setShirtStatus(ShirtStatus.outwards);
            System.out.printf("%n%s climbed out from %s.", getTitle(), trousers.getTitle());
        }
        catch(ShirtStatusException exception){
            System.out.println("Shirt cannot climb out second time");
        }
    }
}
