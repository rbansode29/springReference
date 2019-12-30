package com.example.demo.aopcode.aopclass.lookup;

public class StandardLookupDemoBean implements DemoBean {
	private Singer mySinger;

	public StandardLookupDemoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Singer getMySinger() {
		// TODO Auto-generated method stub
		return this.mySinger;
	}

	@Override
	public void doSomething() {
		mySinger.sing();
	}

	public void setMySinger(Singer mySinger) {
		this.mySinger = mySinger;
	}

}

/*
 @Component("standardLookupBean")
 public class StandardLookupDemoBean implements DemoBean {
  	private Singer mySinger;
  	@Autowired
	@Qualifier("singer")
	public void setMySinger(Singer mySinger) {
		this.mySinger = mySinger;
	}
	
	@Override
	public Singer getMySinger() {
		return this.mySinger;
	}
	
	@Override
	public void doSomething() {
		mySinger.sing();
	}
 
 */
