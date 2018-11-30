package com.yuanmaxinxi.domain.person;

public class PersonType {
	private Long id;
	private String name;//类别名称  1-借款人  2-紧联人  3-担保人  4-出借人
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PersonType [id=" + id + ", name=" + name + "]";
	}
}
