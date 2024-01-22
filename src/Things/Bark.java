package Things;

import Interface.Locatable;
import Place.PlacesName;

public class Bark extends Thing implements Locatable{
    public static StateBark stateBark;
    public Bark(){
        super(PlacesName.pit);
        stateBark = StateBark.onTree;
    }
    public StateBark getStateBark(){
        return stateBark;
    }
    public enum StateBark{
        onTree, showered;
    }
    @Override
    public String getTitle(){
        return "bark";
    }
}
