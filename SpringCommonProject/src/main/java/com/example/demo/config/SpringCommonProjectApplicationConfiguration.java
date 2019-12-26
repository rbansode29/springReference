package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.example.demo.expression.ExpressionParserDemo;
import com.example.demo.expression.NumberGuess;
import com.example.demo.expression.ShapeGuess;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringCommonProjectApplicationConfiguration {

	@Bean(name="expressionParserDemo")
	public ExpressionParserDemo expressionParserDemo() {
		return new ExpressionParserDemo() ;		
	}
	
	@Bean(name="spelExpressionParser")
	public SpelExpressionParser spelExpressionParser() {
		return new SpelExpressionParser();
	}
	@Bean(name="numberGuess")
	public NumberGuess numberGuess() {
		return new NumberGuess();
	}
	
	@Bean(name="shapeGuess")
	public ShapeGuess shapeGuess() {
		return new ShapeGuess();
	}
	
	
}
