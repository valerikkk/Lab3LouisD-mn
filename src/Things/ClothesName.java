package Things;

public enum ClothesName {
    shirt("shirt"), trousers("trousers");
    private final String clotheTitle;
    ClothesName(String clotheTitle){
        this.clotheTitle = clotheTitle;
    }
    public String getClotheTitle() {
        return clotheTitle;
    }
}
