package com.wre.yin.whiterabbiteventapp.beans;

public class  ChatMessage {
    private boolean isImage, isMine;
    private String content,name,time;

    public ChatMessage(String message, boolean mine, boolean image,String cName,String cTime) {
        content = message;
        isMine = mine;
        isImage = image;
        name=cName;
        time=cTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }
}
