package myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//Retention: Defines how long the annotation is retained (Source, Class, or Runtime).
@Target(ElementType.METHOD)
//Specifies where the annotation can be applied (Class, Method, Field, etc.).
public @interface MyAnnotation {
    String value() default "Default Message";
    int k();
}
