package Things;
import Interface.Locatable;
import Place.PlacesName;
import Things.Bark.*;


public class Tree extends Thing implements Locatable{
    private final String title;
    public Tree(String title, PlacesName place){
        super(place);
        this.title = title;
    }
    @Override
    public String toString(){
        return "Tree: "+ getTitle();
    }
    public void showerBark(){
        Bark.stateBark = StateBark.showered;
    }
    @Override
    public String getTitle(){
        return title;
    }
}
