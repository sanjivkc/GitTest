package com.vihaans.core.util;

import org.springframework.beans.factory.annotation.Autowired;

public enum AuditingActionType {

	CREATE("Record Inserted"), 
	UPDATE("Record Updated"), 
	DELETE("Record Deleted"), 
	
	CREATE_FAILED("Record Insert Failed"), 
	UPDATE_FAILED("Record Update Failed"), 
	DELETE_FAILED("Record Delete Failed"), 

	CUSTOM_LIST("Retrive the Custom List"),

	RETRIVE_RECORD("Retrive the Record"), 
	RETRIVE_LIST("Retrive the List"),

	RETRIVE_FAILED("Failed to fetch record"),
	
	GENERIC_FAIL("Generic Failure");

	
	private String description;

	@Autowired
	AuditingActionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
