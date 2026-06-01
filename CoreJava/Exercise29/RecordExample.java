import java.util.List;

public class RecordExample {

    public static void main(String[] args) {

        List<Person> people =
                List.of(

                        new Person(
                                "Ayushi",
                                21
                        ),

                        new Person(
                                "Rahul",
                                17
                        ),

                        new Person(
                                "Anjali",
                                25
                        )
                );

        people.stream()
                .filter(
                        person ->
                                person.age() >= 18
                )
                .forEach(
                        System.out::println
                );
    }
}