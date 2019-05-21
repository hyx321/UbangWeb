package com.ubang.table;


public class FeedBack {
    private int id;
    private int name;
    private String content;
    private String type;
    private String time;
    private String status;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":" + name +
                ", \"content\":\'" + content + "\'" +
                ", \"type\":\'" + type + "\'" +
                ", \"time\":\'" + time + "\'" +
                ", \"status\":\'" + status + "\'" +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
