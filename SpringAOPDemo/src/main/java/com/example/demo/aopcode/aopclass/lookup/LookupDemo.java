package com.example.demo.aopcode.aopclass.lookup;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

	public LookupDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");
		ctx.refresh();
		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);
		displayInfo("abstractLookupBean", abstractBean);
		displayInfo("standardLookupBean", standardBean);
		ctx.close();

	}

	public static void displayInfo(String beanName, DemoBean bean) {
		Singer singer1 = bean.getMySinger();
		Singer singer2 = bean.getMySinger();
		System.out.println("" + beanName + ": Singer Instances the Same? " + (singer1 == singer2));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		for (int x = 0; x < 100000; x++) {
			Singer singer = bean.getMySinger();
			singer.sing();
		}
		stopWatch.stop();
		System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
	}

}
