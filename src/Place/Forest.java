package Place;
import Enums.NoiseLevel;
import Things.Bark;
import Things.Dust;
import Things.Tombstones;
import Things.Tree;
import Interface.Locatable;

import java.util.ArrayList;
import java.util.List;

public class Forest extends Place{
    private final List<Locatable> trees = new ArrayList<>();
    public Forest() {
        super(PlacesName.forest, 0, 0, 0, 100);
        setNoiseLevel(NoiseLevel.average);
        for(int i =0; i<5;i++){
            addContent(new Tree("fir", PlacesName.forest));
        }
    }
    public static class Pit extends Place{
        public Pit(){
            super(PlacesName.pit, 3, -12, 3, 6);
            if(Bark.stateBark.equals(Bark.StateBark.showered)){
                addContent(new Tree("brushwood", PlacesName.pit));
               addContent(new Bark());
               addContent(new Dust("brown"));
            }
        }
    }
    public static class Pathway extends Place{
        public Pathway(int x, int y, int z, int radius){
            super(PlacesName.pathway, x, y, z, radius);
        }
        public void toLead(PlacesName place){

        }
    }
    public class Lawn extends Place{
        public Lawn (){
            super(PlacesName.lawn, 9, 0, 0, 30);
            for (int i=0; i<5;i++){
               addContent(new Tombstones("Unknown person"));
               addContent(new Tree("brushwood", PlacesName.lawn));
            }
        }
    }
    public List<Locatable> getTree() {
        return trees;
    }
    public void setTrees(Locatable tree){
        trees.add(tree);
    }
}

