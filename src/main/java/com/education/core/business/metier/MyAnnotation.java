package com.education.core.business.metier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ FIELD, METHOD, CONSTRUCTOR })
public @interface MyAnnotation {
	
	String message() default "";

}
