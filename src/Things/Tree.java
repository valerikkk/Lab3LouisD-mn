package Things;
import Things.Bark.*;


public class Tree {
    private final String title;
    public Tree(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return "Tree: "+ title;
    }
    public void showerBark(Bark bark){
                Bark.stateBark = StateBark.showered.stateBark;
    }

}
