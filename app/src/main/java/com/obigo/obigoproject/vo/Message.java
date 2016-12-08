package com.obigo.obigoproject.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by O BI HE ROCK on 2016-12-01
 * 김용준, 최현욱
 * Message Class
 * 세부정보
 */

public class Message implements Parcelable {
    public int userMessageNumber;
    public String title;
    public String content;
    public String sendDate;
    public String uploadFile;

    public Message(int userMessageNumber, String title, String content, String sendDate, String uploadFile) {
        this.userMessageNumber = userMessageNumber;
        this.title = title;
        this.content = content;
        this.sendDate = sendDate;
        this.uploadFile = uploadFile;
    }

    protected Message(Parcel in) {
        userMessageNumber = in.readInt();
        title = in.readString();
        content = in.readString();
        sendDate = in.readString();
        uploadFile = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public int getUserMessageNumber() {
        return userMessageNumber;
    }

    public void setUserMessageNumber(int userMessageNumber) {
        this.userMessageNumber = userMessageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userMessageNumber=" + userMessageNumber +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", uploadFile='" + uploadFile + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userMessageNumber);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(sendDate);
        parcel.writeString(uploadFile);
    }
}