package com.yuanmaxinxi.domain.content;

public class Content {
	private String id;
	private String content;
	private int defaultUse;//0-不是默认内容  1-是默认内容
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDefaultUse() {
		return defaultUse;
	}
	public void setDefaultUse(int defaultUse) {
		this.defaultUse = defaultUse;
	}
}
