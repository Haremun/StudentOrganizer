package kamilbieg.studentorganizer;

public class Note {

    private String mType = "";
    private String mName = "";
    private String mDate = "";
    private String mStartHour = "";
    private String mStopHour = "";
    private String mDescription = "";
    private String mNoteType = "";

    public void setType(String type){
        mType = type;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public void setStartHour(String mStartHour) {
        this.mStartHour = mStartHour;
    }

    public void setStopHour(String mStopHour) {
        this.mStopHour = mStopHour;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmNoteType(String mNoteType) {
        this.mNoteType = mNoteType;
    }

    public String getmNoteType() {
        return mNoteType;
    }

    public String getType() {
        return mType;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        return mDate;
    }

    public String getStartHour() {
        return mStartHour;
    }

    public String getStopHour() {
        return mStopHour;
    }

    public String getDescription() {
        return mDescription;
    }
}
