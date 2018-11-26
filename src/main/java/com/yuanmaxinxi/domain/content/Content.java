package com.yuanmaxinxi.domain.content;

public class Content {
	private Long id;
	private String content;
	private int defaultUse;//0-不是默认内容  1-是默认内容
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
