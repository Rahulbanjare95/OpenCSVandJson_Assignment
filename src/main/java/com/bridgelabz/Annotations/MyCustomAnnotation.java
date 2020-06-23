package com.bridgelabz.Annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface MyCustomAnnotation {
    String name() default "Rahul";
    String created();
    int updates() default 1;
    String comments();

}
