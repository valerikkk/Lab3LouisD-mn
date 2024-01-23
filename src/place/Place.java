package place;

import enums.NoiseLevel;
import Interface.Locatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Place {
    private final PlacesName place;
    private NoiseLevel noiseLevel = NoiseLevel.average;
    private final int x;
    private final int y;
    private final int z;
    private final int radius;
    private static int humidityCoefficient = 0;
    private static int lightCoefficient;
    private static double visibilityCoefficient = 1;
    private final List<Locatable> content = new ArrayList<>();
    public Place(PlacesName place, int x, int y, int z, int radius){
        this.place = place;
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }
    public PlacesName getPlace(){
        return place;
}
    public void setNoiseLevel(NoiseLevel noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
    public NoiseLevel getNoiseLevel() {
        return noiseLevel;
    }
    public void addContent(Locatable object){
        content.add(object);
    }
    public List<Locatable> getContent(){
        return content;
    }
    public int getZ() {
        return z;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public int getRadius(){
        return radius;
    }
    public int getMaxX(){
    return getX() + getRadius();
}
    public int getMinX(){
        return getX() - getRadius();
   }
    public int getMaxZ(){
        return getZ() + getRadius();
    }
    public int getMinZ(){
        return getZ() - getRadius();
    }
    public int getHumidityCoefficient() {
        return humidityCoefficient;
    }
    public void setHumidityCoefficient(int humidityCoefficient) {
        Place.humidityCoefficient = humidityCoefficient;
    }
    public int getLightCoefficient() {
        return lightCoefficient;
    }
    public void setLightCoefficient(int lightCoefficient) {
        Place.lightCoefficient = lightCoefficient;
    }
    public double getVisibilityCoefficient() {
        return visibilityCoefficient;
    }
    public void setVisibilityCoefficient(double visibilityCoefficient) {
        Place.visibilityCoefficient = visibilityCoefficient;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Place place1 = (Place) object;
        return place == place1.place && noiseLevel == place1.noiseLevel;
    }
    @Override
    public int hashCode() {
        return Objects.hash(place, x, y, z);
    }
    @Override
    public String toString(){
        return "Place: " + getPlace()
                + ", NoiseLevel: "
                + getNoiseLevel();
    }
}

