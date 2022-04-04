package com.dhm.uniontestapp.db;

public class RewardModel {
    private String title;
    private String sub_title;
    private boolean is_completed;
    private String expire_date;
    private String image;
    private String id;

    public RewardModel(String title, String sub_title, boolean is_completed, String expire_date, String image, String id) {
        this.title = title;
        this.sub_title = sub_title.substring(5);
        this.is_completed = is_completed;
        this.expire_date = expire_date;
        this.image = image;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSubTitle() {
        return sub_title;
    }

    public void setSubTitle(String value) {
        this.sub_title = value;
    }

    public boolean getIsCompleted() {
        return is_completed;
    }

    public void setIsCompleted(boolean value) {
        this.is_completed = value;
    }

    public String getExpireDate() {
        return expire_date;
    }

    public void setExpireDate(String value) {
        this.expire_date = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String value) {
        this.image = value;
    }

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }
}
