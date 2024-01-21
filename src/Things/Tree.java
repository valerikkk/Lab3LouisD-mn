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
                Bark.stateBark = StateBark.showered.stateBark;
    }
    @Override
    public String getTitle(){
        return super.getTitle();
    }
}
