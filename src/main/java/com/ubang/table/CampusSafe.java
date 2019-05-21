package com.ubang.table;

public class CampusSafe {
	private double id;
	private String abstract_content;
	private String article_url;
	private String datetime;
	private String source;
	private String title;
	private String has_image;
	private String image_url;
	private String media_avatar_url;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getAbstract_content() {
		return abstract_content;
	}
	public void setAbstract_content(String abstract_content) {
		this.abstract_content = abstract_content;
	}
	public String getArticle_url() {
		return article_url;
	}
	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHas_image() {
		return has_image;
	}
	public void setHas_image(String has_image) {
		this.has_image = has_image;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getMedia_avatar_url() {
		return media_avatar_url;
	}
	public void setMedia_avatar_url(String media_avatar_url) {
		this.media_avatar_url = media_avatar_url;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"abstract_content\":\"" + abstract_content + "\", \"article_url\":\""
				+ article_url + "\", \"datetime\":\"" + datetime + "\", \"source\":\"" + source + "\", \"title\":\""
				+ title + "\", \"has_image\":\"" + has_image + "\", \"image_url\":\"" + image_url
				+ "\", \"media_avatar_url\":\"" + media_avatar_url + "\"}";
	}
	
	
}
