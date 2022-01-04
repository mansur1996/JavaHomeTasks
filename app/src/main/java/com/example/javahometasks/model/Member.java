package com.example.javahometasks.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
    private int id;
    private String member;

    public Member(int id, String member){
        this.id = id;
        this.member = member;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", member='" + member + '\'' +
                '}';
    }

    protected Member(Parcel in) {
        id = in.readInt();
        member = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(member);
    }
}
