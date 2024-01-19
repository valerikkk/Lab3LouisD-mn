package Things;

import Place.PlacesName;

public class Magazines extends Thing {
    private Status status = Status.unread;

    public Magazines() {
        super("magazines", PlacesName.house);
    }
    public enum Status {
        read, unread
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
