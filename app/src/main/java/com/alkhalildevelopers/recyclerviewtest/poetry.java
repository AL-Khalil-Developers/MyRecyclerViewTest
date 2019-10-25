package com.alkhalildevelopers.recyclerviewtest;

import android.os.Parcel;
import android.os.Parcelable;

import org.w3c.dom.Text;

public class poetry implements Parcelable {
    private Text titleTxt;
    public poetry(Text titleTxt){
        this.titleTxt=titleTxt;
    }

    protected poetry(Parcel in) {
    }

    public static final Creator<poetry> CREATOR = new Creator<poetry>() {
        @Override
        public poetry createFromParcel(Parcel in) {
            return new poetry(in);
        }

        @Override
        public poetry[] newArray(int size) {
            return new poetry[size];
        }
    };

    @Override
    public String toString() {
        return "poetry{" +
                "titleTxt=" + titleTxt +
                '}';
    }

    public Text getTitleTxt() {
        return titleTxt;
    }

    public void setTitleTxt(Text titleTxt) {
        this.titleTxt = titleTxt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
