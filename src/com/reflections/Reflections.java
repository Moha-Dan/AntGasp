package com.reflections;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.stream.Collectors;


public class Reflections {
	String packageName;
	public Reflections(String packageName) {
		this.packageName = packageName;
	}
	public Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation> class1) {
		try {
			Class.forName("org.reflections.Reflections");
			org.reflections.Reflections r = new org.reflections.Reflections(packageName);
			return r.getTypesAnnotatedWith(class1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Set<Class<?>> s = findAllClassesUsingClassLoader(packageName);
			return s.stream()
			.filter((clazz)->{
				return clazz.isAnnotationPresent(class1);
			})
			.collect(Collectors.toSet());
		}
	}
	public static Set<Class<?>> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
          .filter(line -> line.endsWith(".class"))
          .map(line -> getClass(line, packageName))
          .collect(Collectors.toSet());
    }
 
    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
              + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
