package Place;
import Enums.NoiseLevel;
import Things.Bark;
import Things.Dust;
import Things.Tombstones;
import Things.Tree;
public class Forest extends Place{
    private Tree[] trees = new Tree[15];
    public Forest() {
        super(PlacesName.forest, 0, 0, 0, 100);
        for(int i=0; i< trees.length; i++){
            trees[i] = new Tree(("fir"));
        }
        setNoiseLevel(NoiseLevel.average);
        addContent("Forest: ");
        addContent(trees);
    }
    public class Pit extends Place{
        public Pit(){
            super(PlacesName.pit, 3, -12, 3, 6);
            addContent("Seeing in Pit: ");
            if(Bark.stateBark.equals(Bark.StateBark.showered.getStateBark())){
                addContent(new Tree("brushwood"));
               addContent(new Bark());
               addContent(new Dust("brown"));
            }
        }
    }
    public class Pathway extends Place{
        public Pathway(int x, int y, int z, int radius){
            super(PlacesName.pathway, x, y, z, radius);
        }
        public void toLead(PlacesName place){

        }
    }
    public class Lawn extends Place{
        Tombstones[] tombstones = new Tombstones[6];
        Tree[] trees = new Tree[6];
        public Lawn (){
            super(PlacesName.lawn, 9, 0, 0, 30);
            addContent("Seeing in Lawn: ");
           for(int i = 0; i<tombstones.length; i++){
               tombstones[i] = new Tombstones("tombstone");
               trees[i] = new Tree("brushwood");
           }
            addContent(tombstones);
            addContent(trees);
            addContent("Pathway to the thicket...");
        }
        public Tombstones[] getTombstones() {
            return tombstones;
        }
        public Tree[] getTrees() {
            return trees;
        }
    }
}

