package com.ubang.table;
/**
 * 接收帮助
 */
public class HelpInfomation {
    private int help_id;
    private int helper_id;
    private double position_lat;
    private double position_lng;
    private String create_time;
    private String end_time;
    private float rating;
    private String description;

    @Override
    public String toString() {
        return "{" +
                "\"help_id\":" + help_id +
                ", \"helper_id\":" + helper_id +
                ", \"position_lat\":" + position_lat +
                ", \"position_lng\":" + position_lng +
                ", \"create_time\":\'" + create_time + "\'" +
                ", \"end_time\":\'" + end_time + "\'" +
                ", \"rating\":" + rating +
                ", \"description\":\'" + description + "\'" +
                '}';
    }

    public int getHelp_id() {
        return help_id;
    }

    public void setHelp_id(int help_id) {
        this.help_id = help_id;
    }

    public int getHelper_id() {
        return helper_id;
    }

    public void setHelper_id(int helper_id) {
        this.helper_id = helper_id;
    }

    public double getPosition_lat() {
        return position_lat;
    }

    public void setPosition_lat(double position_lat) {
        this.position_lat = position_lat;
    }

    public double getPosition_lng() {
        return position_lng;
    }

    public void setPosition_lng(double position_lng) {
        this.position_lng = position_lng;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
