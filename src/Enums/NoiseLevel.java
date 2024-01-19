package Enums;

public enum NoiseLevel {
    average("average"), high("high"), silence("silence");
    private final String noiseLevel;
    NoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
        public String getNoiseLevel() {
        return noiseLevel;
    }
}
