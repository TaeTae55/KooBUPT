package Util;

public class SituationRoomSend {
    private String id;
    private String flag;
    private int startSession;
    private int endSession;

    public int getStartSession() {
        return startSession;
    }

    public void setStartSession(int startSession) {
        this.startSession = startSession;
    }

    public int getEndSession() {
        return endSession;
    }

    public void setEndSession(int endSession) {
        this.endSession = endSession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
