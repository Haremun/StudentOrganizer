package kamilbieg.studentorganizer;

public class Note {

    private String mClassType = "";
    private String mName = "";
    private String mStartDate = "";
    private String mEndDate = "";
    private String mStartHour = "";
    private String mStopHour = "";
    private String mDescription = "";
    private String mNoteType = "";

    public static Builder builder() {
        return new Builder();
    }

    public String getNoteType() {
        return mNoteType;
    }

    public String getClassType() {
        return mClassType;
    }

    public String getName() {
        return mName;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getStartHour() {
        return mStartHour;
    }

    public String getEndHour() {
        return mStopHour;
    }

    public String getDescription() {
        return mDescription;
    }

    public static final class Builder {

        private String mClassType = "";
        private String mName = "";
        private String mStartDate = "";
        private String mEndDate = "";
        private String mStartHour = "";
        private String mStopHour = "";
        private String mDescription = "";
        private String mNoteType = "";

        public Builder classType(String type){
            this.mClassType = type;
            return this;
        }
        public Builder name(String name){
            this.mName = name;
            return this;
        }
        public Builder startDate(String date){
            this.mStartDate = date;
            return this;
        }
        public Builder endDate(String date){
            this.mEndDate = date;
            return this;
        }
        public Builder startHour(String start){
            this.mStartHour = start;
            return this;
        }
        public Builder endHour(String stop){
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
            note.mClassType = this.mClassType;
            note.mName = this.mName;
            note.mStartDate = this.mStartDate;
            note.mEndDate = this.mEndDate;
            note.mStartHour = this.mStartHour;
            note.mStopHour = this.mStopHour;
            note.mDescription = this.mDescription;
            note.mNoteType = this.mNoteType;

            return note;
        }
    }
}
