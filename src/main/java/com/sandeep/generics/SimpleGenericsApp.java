/**
 * 
 */
package com.sandeep.generics;

import java.util.ArrayList;
import java.util.List;

public class SimpleGenericsApp {

	public static void main(String a[]) {

		
		SimpleGenerics<String> genericString = new SimpleGenerics<String>("MY-GENERICS");
		genericString.printType();
		
		SimpleGenerics<Integer> genericInteger = new SimpleGenerics<Integer>(10);
		genericInteger.printType();
	}

}

class SimpleGenerics<T> {

	private T myobj = null;
	private List<T> list = new ArrayList<T>();

	public SimpleGenerics(T t) {
		myobj = t;
	}

	public T getObject() {
		return myobj;
	}
	
	public void add(T t) {
		this.list.add(t);
	}
	
	public List<T> getList(T t) {
		return this.list;
	}

	public void printType() {
		System.out.println("Type: " + myobj.getClass().getName());
	}
}

class BoundedGenerics<T extends A> {
	private T objRef;

	public BoundedGenerics(T obj) {
		this.objRef = obj;
	}

	public void doRunTest() {
		this.objRef.printClass();
	}
}

class A {
	public void printClass() {
		System.out.println("I am in super class A");
	}
}

class B extends A {
	public void printClass() {
		System.out.println("I am in sub class B");
	}
}

class C extends A {
	public void printClass() {
		System.out.println("I am in sub class C");
	}
}


