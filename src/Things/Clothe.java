package Things;
public class Clothe{
    private final int barCode;
    public Clothe(int barCode){
        this.barCode = barCode;
    }
    @Override
    public int hashCode(){
        return this.barCode;
    }
}
