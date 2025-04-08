package org.example.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Example {
    static final Scanner scanner = new Scanner(System.in);
    static final List<Class<?>> commandClasses;

    static {
        Set<Class<?>> classes = ClassUtils.findClasses("org.example.annotations");
        commandClasses = classes.stream()
                .filter(cls -> cls.getAnnotation(Command.class) != null)
                .sorted(Comparator.comparingInt(cls -> cls.getAnnotation(Command.class).order())).toList();
    }

    public static void main(String[] args) {
        printCommands();
        Session session = new Session();
        do {
            Optional<Class<?>> commandClass = readCommand();
            if (commandClass.isEmpty()) {
                printCommands();
                continue;
            }
            executeCommand(commandClass.get(), session);
        } while (session.isActive());
    }

    private static void printCommands() {
        for (Class<?> cls : commandClasses) {
            Command annotation = cls.getAnnotation(Command.class);
            System.out.printf("%-12s - %s%n", annotation.value(), annotation.description());
        }
    }

    private static Optional<Class<?>> readCommand() {
        String userInput = readInput();
        Optional<Class<?>> commandClass = Optional.empty();
        for (Class<?> cls : commandClasses) {
            Command annotation = cls.getAnnotation(Command.class);
            if (annotation.value().equals(userInput))
                commandClass = Optional.of(cls);
        }
        return commandClass;
    }

    private static String readInput() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    private static void executeCommand(Class<?> commandClass, Session session) {
        try {
            Constructor<?> constructor = commandClass.getDeclaredConstructor();
            Object obj = constructor.newInstance();
            Method method = commandClass.getMethod("execute", Session.class);
            method.invoke(obj, session);
        } catch (NoSuchMethodException | SecurityException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println("Unable to process request");
        }
    }
}


