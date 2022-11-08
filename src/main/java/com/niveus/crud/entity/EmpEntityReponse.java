package com.niveus.crud.entity;

import java.util.List;

public class EmpEntityReponse {

	public String message;
	public List<EmpEntity> list;
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
