package kamilbieg.studentorganizer;

public class Note {

    private String mType = "";
    private String mName = "";
    private int mDate = 0;
    private int mStartHour = 0;
    private int mStopHour = 0;
    private String mDescription = "";

    public void setType(String type){
        mType = type;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDate(int mDate) {
        this.mDate = mDate;
    }

    public void setStartHour(int mStartHour) {
        this.mStartHour = mStartHour;
    }

    public void setStopHour(int mStopHour) {
        this.mStopHour = mStopHour;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
