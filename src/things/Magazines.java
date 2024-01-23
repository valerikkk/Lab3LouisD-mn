package things;

import Interface.Locatable;
import place.PlacesName;

public class Magazines extends Thing implements Locatable{
    private Status status;
    private final String title;
    public Magazines(String title){
        super(PlacesName.house);
        this.title = title;
        status = Status.unread;
    }
    public enum Status {
        read, unread
    }
    public Status getStatus() {
        return status;
    }
    @Override
    public String getTitle(){
        return title;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
