package things;
import Interface.Locatable;
import place.PlacesName;
public class Tree extends Thing implements Locatable{
    private final String title;
    public Tree(String title, PlacesName place){
        super(place);
        this.title = title;
    }
    public static class Bark extends Thing implements Locatable{
        public static StateBark stateBark = StateBark.onTree;
        public Bark(){
            super(PlacesName.pit);
        }
        public StateBark getStateBark(){
            return stateBark;
        }
        public void setStateBark(StateBark stateBark){
            Tree.Bark.stateBark = stateBark;
        }
        public enum StateBark{
            onTree, showered
        }
        @Override
        public String getTitle(){
            return "bark";
        }
    }

    @Override
    public String toString(){
        return "Tree: "+ getTitle();
    }
    public void showerBark(){
       Bark.stateBark = Bark.StateBark.showered;
    }
    @Override
    public String getTitle(){
        return title;
    }
}
