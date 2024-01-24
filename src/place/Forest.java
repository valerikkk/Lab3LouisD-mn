package place;
import enums.NoiseLevel;
import things.Dust;
import things.Tombstones;
import things.Tree;

public class Forest extends Place{
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
            if(Tree.Bark.stateBark.equals(Tree.Bark.StateBark.showered)){
                addContent(new Tree("brushwood", PlacesName.pit));
               addContent(new Tree.Bark());
               addContent(new Dust("brown"));
            }
        }
    }
    public static class Pathway extends Place{
        public Pathway(int x, int y, int z, int radius){
            super(PlacesName.pathway, x, y, z, radius);
        }
        public void toLead(PlacesName place){
            if(place.hashCode() == this.hashCode()){
                System.err.printf("%n%s can't lead to itself", getPlace());
            }
        }
    }
    public static class Lawn extends Place{
        public Lawn (){
            super(PlacesName.lawn, 9, 0, 0, 30);
            for (int i=0; i<5;i++){
               addContent(new Tombstones("Unknown person"));
               addContent(new Tree("brushwood", PlacesName.lawn));
            }
        }
    }
}

