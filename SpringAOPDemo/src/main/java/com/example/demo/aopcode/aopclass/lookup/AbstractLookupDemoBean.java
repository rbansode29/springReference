package com.example.demo.aopcode.aopclass.lookup;

public abstract class AbstractLookupDemoBean implements DemoBean {

	public AbstractLookupDemoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Singer getMySinger();

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub

	}

}

/*
 using configuration:
 
 @Component("abstractLookupBean")
 public class AbstractLookupDemoBean implements DemoBean {
	@Lookup("singer")
	public Singer getMySinger() {
		return null; //  dynamically
	}
	@Override
	public void doSomething() {
		getMySinger().sing();
	}
}
*/ 
