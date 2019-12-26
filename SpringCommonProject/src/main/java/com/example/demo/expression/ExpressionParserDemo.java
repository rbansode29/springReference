package com.example.demo.expression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionParserDemo {

	private SpelExpressionParser expressionParser;

	public ExpressionParserDemo() {
		super();
	}

	@Autowired	
	@DependsOn("spelExpressionParser")
	public void setExpressionParser(SpelExpressionParser expressionParser) {
		this.expressionParser = expressionParser;
	}

	public SpelExpressionParser getExpressionParser() {
		return expressionParser;
	}

}
