package Things;

public class Trousers extends Clothe{
    public Trousers(int barCode){
        super(barCode);
        title = ClothesName.trousers.getClotheTitle();
    }
}
