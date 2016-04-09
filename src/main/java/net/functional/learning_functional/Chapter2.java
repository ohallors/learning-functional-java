package net.functional.learning_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Chapter2 {
    public static void main(String[] args) {
        List<String> stringlist = new ArrayList<>();
        stringlist.add("cat");
        stringlist.add("dog");
        stringlist.add("horse");

        System.out.println("assign lambda to variable");
        Consumer<String> consumer = t -> System.out.println(t);
        stringlist.forEach(consumer);
        
        System.out.println("high order function");
        stringlist.forEach(s -> System.out.println(processString(t -> t.toLowerCase(), s)));
        System.out.println("high order function with method reference");
        stringlist.forEach(s -> System.out.println(processString(String::toLowerCase, s)));
    }

    public static String processString(Function<String, String> operation, String target) {
        return operation.apply(target);
    }

}
