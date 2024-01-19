package Things;

import Place.PlacesName;

public class Bark extends Thing{
    public Bark(){
        super("bark", PlacesName.pit);
    }
    public static String stateBark = StateBark.onTree.stateBark;
    public String getStateBark(){
        return stateBark;
    }
    public enum StateBark{
        onTree("all bark on the tree, no on the ground"), showered("part of bark has showered, part on the tree");
        public final String stateBark;
        StateBark(String stateBark){
            this.stateBark = stateBark;
        }
        public String getStateBark(){
            return stateBark;
        }
    }
    @Override
    public String toString(){
        return getTitle() +
                " from tree.";
    }
}
