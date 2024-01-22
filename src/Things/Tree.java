package Things;
import Interface.Locatable;
import Place.PlacesName;
import Things.Bark.*;


public class Tree extends Thing{
    public Tree(String title, PlacesName place){
        super(title, place);
    }
    @Override
    public String toString(){
        return "Tree: "+ getTitle();
    }
    public void showerBark(Bark bark){
        bark.stateBark = StateBark.showered;
    }
    @Override
    public String getTitle(){
        return super.getTitle();
    }
}
