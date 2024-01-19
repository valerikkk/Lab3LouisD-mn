package Things;

public class Clothe {
    protected String title;
    private final int barCode;
    public Clothe(int barCode){
        this.barCode = barCode;
    }
    @Override
    public int hashCode(){
        return this.barCode;
    }
    public String getTitle() {
        return title;
    }
}
