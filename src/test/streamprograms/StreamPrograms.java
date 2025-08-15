package streamprograms;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPrograms {

    @Test
    public static void count() {

        int count = 0;
        List<String> words = new ArrayList<>();
        words.add("Pavan");
        words.add("Gagan");
        words.add("Abhijit");
        words.add("Aman");
        words.add("Aurang");
        words.add("Rupesh");
        words.add("Apple");

        for (String name : words) {
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);

    }

    @Test
    void countWithStream() {
        List<String> words = new ArrayList<>();
        words.add("Pavan");
        words.add("Gagan");
        words.add("Abhijit");
        words.add("Ama");
        words.add("Aurang");
        words.add("Rupesh");
        words.add("Apple");

        long count = words.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        words.stream().filter(s->s.length()>4).forEach(System.out::println);
    }

    //Words ends with "a" convert it into upper case
    @Test
    void streamUpperCaseWithMap(){
        Stream.of("Gagan", "Punita", "Gunita", "Puran").filter(s -> s.endsWith("a"))
                .map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    void evenOddInOneList(){

        List<Integer> list =  Arrays.asList(4,6,7,2,5,9,7,0);

        List<Integer> even = list.stream().filter(s->s%2==0).collect(Collectors.toList());

        List<Integer> odd = list.stream().filter(s->s%2 != 0).collect(Collectors.toList());

        Stream.concat(even.stream(), odd.stream()).forEach(s-> System.out.print(s +" "));

        //System.out.println(newList);
    }

    @Test
    //print unique number in array and sort
    void uniqueAndSort(){
        List<Integer> list =  Arrays.asList(4,6,7,2,5,9,7,0);
        list.stream().distinct().sorted().forEach(s-> System.out.print(s+ " "));
    }
}
