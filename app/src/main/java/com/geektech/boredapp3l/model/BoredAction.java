package com.geektech.boredapp3l.model;

import com.google.gson.annotations.SerializedName;

public class BoredAction {

    @SerializedName("key")
    private String key;

    @SerializedName("activity")
    private String title;

    @SerializedName("accessibility")
    private Float accessibility;

    @SerializedName("type")
    private EActionType type;

    @SerializedName("participants")
    private int participants;

    @SerializedName("price")
    private Float price;

    @SerializedName("link")
    private String link;

    public BoredAction(String key, String activity, Float accessibility, EActionType type, int participants, Float price, String link) {
        this.key = key;
        this.title = activity;
        this.accessibility = accessibility;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }

    public EActionType getType() {
        return type;
    }

    public void setType(EActionType type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
