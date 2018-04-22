package kamilbieg.studentorganizer;

public class Note {

    private String mType = "";
    private String mName = "";
    private String mDate = "";
    private String mStartHour = "";
    private String mStopHour = "";
    private String mDescription = "";
    private String mNoteType = "";

    public static Builder builder() {
        return new Builder();
    }

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

    public static final class Builder {

        private String mType = "";
        private String mName = "";
        private String mDate = "";
        private String mStartHour = "";
        private String mStopHour = "";
        private String mDescription = "";
        private String mNoteType = "";

        public Builder type(String type){
            this.mType = type;
            return this;
        }
        public Builder name(String name){
            this.mName = name;
            return this;
        }
        public Builder date(String date){
            this.mDate = date;
            return this;
        }
        public Builder startHour(String start){
            this.mStartHour = start;
            return this;
        }
        public Builder stopHour(String stop){
            this.mStopHour = stop;
            return this;
        }
        public Builder description(String desc){
            this.mDescription = desc;
            return this;
        }
        public Builder noteType(String noteType){
            this.mNoteType = noteType;
            return this;
        }

        public Note build(){

            Note note = new Note();
            note.mType = this.mType;
            note.mName = this.mName;
            note.mDate = this.mDate;
            note.mStartHour = this.mStartHour;
            note.mStopHour = this.mStopHour;
            note.mDescription = this.mDescription;
            note.mNoteType = this.mNoteType;

            return note;
        }
    }
}
