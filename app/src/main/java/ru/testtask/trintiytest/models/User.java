package ru.testtask.trintiytest.models;

/**
 * Created by nfedorov on 15.03.17.
 */

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("age")
    private int age;

    @SerializedName("id")
    private int id;

    @SerializedName("lastSeen")
    private String lastSeen;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("unreadMessages")
    private int unreadMessages;

    public User(int age, int id, String lastSeen, String name, String status, int unreadMessages) {
        this.age = age;
        this.id = id;
        this.lastSeen = lastSeen;
        this.name = name;
        this.status = status;
        this.unreadMessages = unreadMessages;
    }


    public int getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(int unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
