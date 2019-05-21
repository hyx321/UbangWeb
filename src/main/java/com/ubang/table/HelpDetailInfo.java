package com.ubang.table;

/**
 * Created by huang on 2019/5/2.
 * @author huang
 * 求助的详细信息
 */

public class HelpDetailInfo {
    private String name;
    private String avatar;
    private int helper_id;
    private String create_time;
    private String end_time;
    private String publish_time;
    private String content;
    private String has_picture;
    private int id;
    private String type;
    private double start_position_lat;
    private double start_position_lng;
    private double end_position_lat;
    private double end_position_lng;
    private int rating;
    private String description;
    private double helper_position_lat;
    private double helper_position_lng;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHas_picture() {
        return has_picture;
    }

    public void setHas_picture(String has_picture) {
        this.has_picture = has_picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getStart_position_lat() {
        return start_position_lat;
    }

    public void setStart_position_lat(double start_position_lat) {
        this.start_position_lat = start_position_lat;
    }

    public double getStart_position_lng() {
        return start_position_lng;
    }

    public void setStart_position_lng(double start_position_lng) {
        this.start_position_lng = start_position_lng;
    }

    public double getEnd_position_lat() {
        return end_position_lat;
    }

    public void setEnd_position_lat(double end_position_lat) {
        this.end_position_lat = end_position_lat;
    }

    public double getEnd_position_lng() {
        return end_position_lng;
    }

    public void setEnd_position_lng(double end_position_lng) {
        this.end_position_lng = end_position_lng;
    }

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"avatar\":\"" + avatar + "\", \"helper_id\":\"" + helper_id
				+ "\", \"create_time\":\"" + create_time + "\", \"end_time\":\"" + end_time + "\", \"publish_time\":\""
				+ publish_time + "\", \"content\":\"" + content + "\", \"has_picture\":\"" + has_picture
				+ "\", \"id\":\"" + id + "\", \"type\":\"" + type + "\", \"start_position_lat\":\"" + start_position_lat
				+ "\", \"start_position_lng\":\"" + start_position_lng + "\", \"end_position_lat\":\""
				+ end_position_lat + "\", \"end_position_lng\":\"" + end_position_lng + "\", \"rating\":\"" + rating
				+ "\", \"description\":\"" + description + "\", \"helper_position_lat\":\"" + helper_position_lat
				+ "\", \"helper_position_lng\":\"" + helper_position_lng + "\"}";
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHelper_position_lat() {
		return helper_position_lat;
	}

	public void setHelper_position_lat(double helper_position_lat) {
		this.helper_position_lat = helper_position_lat;
	}

	public double getHelper_position_lng() {
		return helper_position_lng;
	}

	public void setHelper_position_lng(double helper_position_lng) {
		this.helper_position_lng = helper_position_lng;
	}

	public int getHelper_id() {
		return helper_id;
	}

	public void setHelper_id(int helper_id) {
		this.helper_id = helper_id;
	}
}
