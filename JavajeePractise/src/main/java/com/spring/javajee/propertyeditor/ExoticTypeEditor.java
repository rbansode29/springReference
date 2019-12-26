package com.spring.javajee.propertyeditor;
import java.beans.PropertyEditorSupport;

import com.spring.javajee.propertyeditor.ExoticType;

public class ExoticTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		setValue(new ExoticType(text.toUpperCase()));
	}

}
