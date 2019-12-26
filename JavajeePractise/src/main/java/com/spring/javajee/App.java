package com.spring.javajee;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.javajee.autoconfig.DemoConfig;
import com.spring.javajee.autoconfig.JJWriter;
import com.spring.javajee.autoconfig.JJWriterComp;
import com.spring.javajee.beanwrapper.Company;
import com.spring.javajee.beanwrapper.Employee;
import com.spring.javajee.propertyeditor.DependsOnExoticType;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		JJWriter writer = context.getBean("jjwriter", JJWriter.class);

		JJWriterComp writercomp = context.getBean("writer", JJWriterComp.class);

		writercomp.write();

		callBeanWrapperImpl();

		callPropertyEditorSupport(context);

	}

	private static void callPropertyEditorSupport(ApplicationContext context) {
		DependsOnExoticType sample = (DependsOnExoticType) context.getBean("sample");
		System.out.println(sample.getType());
	}

	private static void callBeanWrapperImpl() {

		BeanWrapperImpl company = new BeanWrapperImpl(new Company());
		company.setPropertyValue("name", "SBS India");
		company.setPropertyValue("managingDirector", new Employee());

		System.out.println(company.getWrappedClass().toString());

		PropertyValue value = new PropertyValue("name", "Some Company Inc.");
		company.setPropertyValue(value);

		// ok, let's create the director and tie it to the company:
		BeanWrapper jim = new BeanWrapperImpl(new Employee());
		jim.setPropertyValue("name", "Jim Stravinsky");
		jim.setPropertyValue("salary", 55000);
		company.setPropertyValue("managingDirector", jim.getWrappedInstance());

		// retrieving the salary of the managingDirector through the company
		Float salary = (Float) company.getPropertyValue("managingDirector.salary");

		System.out.println(salary);
	}
}

/*
 * some of the important annotation as listed below ::
 * 
 * 1-@Configuration :You can use @Configuration to specify a Java configuration
 * file
 * 
 * 2-@Bean :is used to specify a bean instance definition
 * 
 * 3-@Component :can be used over a class to tell spring to consider it as a
 * bean component.
 * 
 * 4-@ComponentScan :annotation can be used to specify the packages that need to
 * be scanned for components and is usually used along with @Configuration
 * classes. You may also specify the same behaviour using
 * <context:component-scan in spring xml configuration
 * 
 * 5-@Repository, @Service and @Controller :can be used instead of @Component
 * based on actual application layer you are developing. However technically all
 * behave the same. If in doubt, use @Component.
 * 
 * 6-@Autowired :You can simply specify the @Autowired annotation over
 * properties, setter methods and constructors. Spring will then find a bean of
 * matching type and inject it. By default, it does autowiring by type and hence
 * if you have two matching beans (two beans of same type), your execution will
 * fail
 * 
 * 7-@Qualifier :annotation can be used along with @Autowired to do autowiring
 * by name. You can specify the name of the bean as @Qualifier("beanName")
 * 
 * 8-@Primary :allows to give preference to a bean when multiple beans match for
 * autowiring.
 * 
 * 9-@Resource and @Inject :are Java specific annotations that does almost the
 * same thing as Spring's @Autowired. However, when using @Resource, you can
 * specify autowiring by name instead of using @Qualifier annotation.
 */
