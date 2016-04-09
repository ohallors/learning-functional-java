package net.functional.learning_functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Chapter1 
{
    public static void main( String[] args )
    {
        Integer arr[] = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(arr);
        list.forEach(x->System.out.println(x));
        System.out.println( "Hello World!" );
        
        // function compose
        Function<Integer, Integer> absThenNegate =
            ((Function<Integer, Integer>)Math::negateExact).compose(Math::abs);
        
        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(25));
        
        // Function andThen
        Function<Integer, Integer> negateThenAbs =
            ((Function<Integer, Integer>)Math::negateExact).andThen(Math::abs);
        System.out.println(negateThenAbs.apply(-25));
        System.out.println(negateThenAbs.apply(25));
        
        // streams
        System.out.println("Stream");
        Random random = new Random();
        random.ints()
            .limit(5)
            .sorted()
            .forEach(x->System.out.println(x));

        // each element of the stream
        System.out.println("Stream of ints");
        Stream<Integer> stream = Stream.of(12, 52, 34, 65, 90);
        stream.map(x->x*2).forEach(x->System.out.println(x));

        System.out.println("Parallel stream");
        Stream<Integer> parStream = Stream.of(12, 52, 34, 65, 90);
        parStream.parallel().map(x->x*2).forEach(x->System.out.println(x));

        System.out.println("Default methods in interface");
        Computable computeImpl = new ComputableImpl();
        System.out.println(computeImpl.doubleNumber(2));

        System.out.println("forEach default method added to list interface");
        List<String> foreachlist = new ArrayList<>();
        foreachlist.add("cat");
        foreachlist.add("dog");
        foreachlist.add("horse");
        foreachlist.forEach(f->System.out.println(f));

        System.out.println("Thread as a lambda");
        new Thread(()-> {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("val: " + i);
            }
        }).start();

        System.out.println("method referencing");
        Stream<Integer> streamOfInts = Stream.of(12, 52, 32, 46, 94, 12);
        streamOfInts.map(x -> x * 2).forEach(System.out::println);
//        streamOfInts.map(Math::sin).forEach(System.out::println);

        System.out.println("list as stream");
        List<String> stringlist = new ArrayList<>();
        stringlist.add("cat");
        stringlist.add("dog");
        stringlist.add("horse");
        stringlist.forEach(name -> System.out.println(name + " " + name.length()));
    }
}
