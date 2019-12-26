package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.example.demo.expression.ExpressionParserDemo;
import com.example.demo.expression.Inventor;
import com.example.demo.expression.NumberGuess;
import com.example.demo.expression.ShapeGuess;

@SpringBootApplication
public class SpringCommonProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCommonProjectApplication.class, args);

		ExpressionParserDemo expressionParserDemo = (ExpressionParserDemo) context.getBean("expressionParserDemo");
		try {
			ExpressionParser parser = expressionParserDemo.getExpressionParser();
			Expression exp = parser.parseExpression("'Hello World'.concat('!')");
			String message = (String) exp.getValue();
			
			System.out.println(message);
			
			inventorExample();
			guessExample(context);

			
		} catch (ParseException px) {
			System.out.println(px.getMessage());
		} catch (EvaluationException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void inventorExample() {
		Inventor inventor = new Inventor("Hyundai","KIA");
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		String name = (String) exp.getValue(inventor);
		exp = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp.getValue(inventor, Boolean.class);		
		System.out.println(name);
		System.out.println(result);
	}
	
	private static void guessExample(ApplicationContext context ) {
		NumberGuess number = (NumberGuess)context.getBean("numberGuess");	
		ShapeGuess shapeGuess = (ShapeGuess)context.getBean("shapeGuess");
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("randomNumber");
		
		Expression exp1 = parser.parseExpression("initialShapeSeed");
		
		Integer randomNumber = (Integer) exp.getValue(number);
		String initialShapeSeed = (String) exp1.getValue(shapeGuess);
		
		System.out.println(randomNumber);
		System.out.println(initialShapeSeed);
	}

}