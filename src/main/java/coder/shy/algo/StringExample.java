package coder.shy.algo;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = s1 + "World";
        String s4 = "Hello" + "World";
        String s5 = "HelloWorld";
        System.out.println(s1==s2);
        System.out.println(s3==s4);
        System.out.println(s4==s5);
    }
}
