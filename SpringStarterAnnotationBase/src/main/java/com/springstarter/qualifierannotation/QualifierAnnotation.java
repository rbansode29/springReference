package com.springstarter.qualifierannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class QualifierAnnotation {

	@Autowired
	@Qualifier("first")
	private MyQualification qualifier;

	public QualifierAnnotation() {
		// TODO Auto-generated constructor stub
	}

	public MyQualification getQualifier() {
		return qualifier;
	}

	public void setQualifier(MyQualification qualifier) {
		this.qualifier = qualifier;
	}

	public void getQualification() {
		qualifier.showQualification();
	}

}
