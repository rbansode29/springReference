package com.spring.javajee.custompropertyeditorregistrar;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.spring.javajee.propertyeditor.ExoticType;
import com.spring.javajee.propertyeditor.ExoticTypeEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());
	}

}
