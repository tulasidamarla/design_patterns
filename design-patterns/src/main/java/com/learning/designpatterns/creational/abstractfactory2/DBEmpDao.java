package com.learning.designpatterns.creational.abstractfactory2;

public class DBEmpDao implements Dao {

	@Override
	public void save() {
		System.out.println("Saving Employee to DB");
	}

}
