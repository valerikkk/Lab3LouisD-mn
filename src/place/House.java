package place;

import enums.NoiseLevel;

public class House extends Place{
    public House(){
        super(PlacesName.house, 100, 0, 100, 15);
        setLightCoefficient(1);
        setNoiseLevel(NoiseLevel.average);
    }
    public class Bedroom extends Place{
        public Bedroom(){
            super(PlacesName.bedroom, 102, 0, 102, 4);
            setLightCoefficient(1);
        }
    }
}