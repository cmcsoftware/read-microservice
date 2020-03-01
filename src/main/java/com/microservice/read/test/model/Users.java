package com.microservice.read.test.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6755030260802711033L;

	private String name;
	
	private String surname;
}
