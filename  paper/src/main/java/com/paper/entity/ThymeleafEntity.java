package com.paper.entity;


public class ThymeleafEntity {

	public String id;
	public String name;
	public String age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ThymeleafEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public ThymeleafEntity(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public ThymeleafEntity()
	{}
	
}