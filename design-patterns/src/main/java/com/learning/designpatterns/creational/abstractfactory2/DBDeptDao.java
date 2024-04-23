package com.learning.designpatterns.creational.abstractfactory2;

public class DBDeptDao implements Dao {

	@Override
	public void save() {
		System.out.println("Saving Department to DB");
	}

}
