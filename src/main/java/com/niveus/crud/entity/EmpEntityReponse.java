package com.niveus.crud.entity;

import java.util.List;

public class EmpEntityReponse {

	private String message;
	private List<EmpEntity> list;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<EmpEntity> getList() {
		return list;
	}
	public void setList(List<EmpEntity> list) {
		this.list = list;
	}
	
}
