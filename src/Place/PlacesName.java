package Place;

public enum PlacesName {
    pathway("pathway"), pit("pit"), forest("forest"), lawn("lawn"), house("house"),thicket("thicket"), bedroom("bedroom");
    private final String titlePlace;
    PlacesName(String titlePlace){
        this.titlePlace = titlePlace;
    }
    public String getTitlePlace(){
        return titlePlace;
    }
}
