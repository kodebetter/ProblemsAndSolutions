package com.sandeep.generics;

public class BoundedExample {
	public static void main(String a[]) {

		BoundedGenerics<C> bec = new BoundedGenerics<C>(new C());
		bec.doRunTest();

		BoundedGenerics<B> beb = new BoundedGenerics<B>(new B());
		beb.doRunTest();

		BoundedGenerics<A> bea = new BoundedGenerics<A>(new A());
		bea.doRunTest();

	}
}
