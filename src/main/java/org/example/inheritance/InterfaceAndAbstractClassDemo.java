package org.example.inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Animal is an abstract class with shared attributes: name and lifeExpectancy and abstract methods:
 * remember() and protectOwner(). Dog and Cat are Animals that have implemented the remember() and
 * protectOwner() methods.
 * <p>
 * Cat can climb() but Dog cannot. Dog can think() but Cat cannot. These specific capabilities are added to Cat
 * and Dog by implementation.
 * <p>
 * Man is not an Animal, but he can Think , Learn, Apply, and Climb.
 * Cat is not a Man but it can Climb.
 * Dog is not a Man, but it can Learn
 * Man is neither a Cat nor a Dog but can have some of the capabilities of the latter two without extending
 * Animal, Cat, or Dog. This is done with Interfaces.
 * <p>
 * Even though Animal is an abstract class, it has a constructor, unlike an interface.
 * <p>
 * TL;DR:
 * Unrelated classes can have capabilities through interfaces, but related classes change the behaviour through extension of
 * base classes.
 */
public class InterfaceAndAbstractClassDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("sparky", 12);
        Cat cat = new Cat("twinkle", 20);
        System.out.println(dog);
        System.out.println(cat);

        dog.remember();
        dog.protectOwner();
        dog.learn();

        cat.remember();
        cat.protectOwner();
        cat.climb();

        Man man = new Man("Jack", 25);
        System.out.println(man);
        man.think();
        man.learn();
        man.apply();
        man.climb();


        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("ro", 1));
        animals.add(new Cat("mi", 2));

        List<Dog> dogs = new ArrayList<>();

        List<? extends Animal> animals1 = dogs;
        System.out.println(animals);
    }
}

abstract class Animal {
    String name;
    int lifeExpectancy;

    protected Animal(String name, int lifeExpectancy) {
        this.name = name;
        this.lifeExpectancy = lifeExpectancy;
    }

    protected abstract void remember();

    protected abstract void protectOwner();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }
}

interface Learn {
    void learn();
}

interface Think {
    void think();
}

interface Climb {
    void climb();
}

interface Apply {
    void apply();
}

class Dog extends Animal implements Learn {
    protected Dog(String name, int lifeExpectancy) {
        super(name, lifeExpectancy);
    }

    @Override
    protected void remember() {
        System.out.println("Dog can remember for 5 minutes");
    }

    @Override
    protected void protectOwner() {
        System.out.println("Dog will protect owner");
    }

    @Override
    public void learn() {
        System.out.println("Dog can learn");
    }
}

class Cat extends Animal implements Climb {
    protected Cat(String name, int lifeExpectancy) {
        super(name, lifeExpectancy);
    }

    @Override
    protected void remember() {
        System.out.println("Cat can remember for 10 minutes");
    }

    @Override
    protected void protectOwner() {
        System.out.println("Cat won't protect owner");
    }

    @Override
    public void climb() {
        System.out.println("Cat can climb");
    }
}

class Man implements Think, Learn, Apply, Climb {
    String name;
    int age;

    protected Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void learn() {
        System.out.println("Man can learn");
    }

    @Override
    public void think() {
        System.out.println("Man can think");
    }

    @Override
    public void climb() {
        System.out.println("Man can climb");
    }

    @Override
    public void apply() {
        System.out.println("Man can apply");
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
