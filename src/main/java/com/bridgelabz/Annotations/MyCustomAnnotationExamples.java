package com.bridgelabz.Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyCustomAnnotationExamples {
    @Override
    @MyCustomAnnotation(name = "Rahul",comments = "Main method",created = "June 23 2020",updates = 1)
    public  String toString(){
        return "Overriden toString method";
    }
    @Deprecated
    @MyCustomAnnotation(comments = "depricated",created = "June 23 2020")
    public  static void  oldAnnotations(){
        System.out.println("Old method dont use it");
    }

    public static void main(String[] args) {
        try {
            for (Method method :MyCustomAnnotationExamples.class.getMethods()){
                if (method.isAnnotationPresent(MyCustomAnnotation.class)){
                    try {
                        for(Annotation anno : method.getDeclaredAnnotations()){
                            System.out.println("Annotion in method "+method+" : "+anno);
                        }
                        MyCustomAnnotation methodanno=method.getAnnotation(MyCustomAnnotation.class);
                        if(methodanno.updates()==1){
                            System.out.println("method with revision = "+method);
                        }

                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
