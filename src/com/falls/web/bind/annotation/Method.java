package com.falls.web.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Method {
	String value();
	String method() default "GET";
	public static String GET = "GET";
	public static String POST = "POST";
	
}
