package org.example.annotations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassUtils {
    private ClassUtils() {
    }

    public static Set<Class<?>> findClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(getClassName(className, packageName));
        } catch (ClassNotFoundException e) {
            System.out.printf("Error loading class %s", e.getMessage());
        }
        return null;
    }

    private static String getClassName(String className, String packageName) {
        return packageName + "." + className.substring(0, className.lastIndexOf('.'));
    }
}
