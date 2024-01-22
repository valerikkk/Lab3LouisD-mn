package Things;

import Place.PlacesName;

public class Bark extends Thing{
    public Bark(){
        super("bark", PlacesName.pit);
        stateBark = StateBark.onTree;
    }
    public static StateBark stateBark;
    public StateBark getStateBark(){
        return stateBark;
    }
    public enum StateBark{
        onTree, showered;
    }
    @Override
    public String toString(){
        return getTitle() +
                " from tree.";
    }
}
