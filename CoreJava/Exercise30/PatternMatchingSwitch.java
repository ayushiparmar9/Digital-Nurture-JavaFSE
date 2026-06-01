public class PatternMatchingSwitch {

    public static void printType(
            Object obj
    ) {

        switch(obj) {

            case Integer i ->

                    System.out.println(
                            "Integer: " + i
                    );

            case String s ->

                    System.out.println(
                            "String: " + s
                    );

            case Double d ->

                    System.out.println(
                            "Double: " + d
                    );

            case null ->

                    System.out.println(
                            "Null Value"
                    );

            default ->

                    System.out.println(
                            "Unknown Type"
                    );
        }
    }

    public static void main(String[] args) {

        printType(100);

        printType("Ayushi");

        printType(99.99);

        printType(null);
    }
}public class PatternMatchingSwitch {

    public static void printType(
            Object obj
    ) {

        switch(obj) {

            case Integer i ->

                    System.out.println(
                            "Integer: " + i
                    );

            case String s ->

                    System.out.println(
                            "String: " + s
                    );

            case Double d ->

                    System.out.println(
                            "Double: " + d
                    );

            case null ->

                    System.out.println(
                            "Null Value"
                    );

            default ->

                    System.out.println(
                            "Unknown Type"
                    );
        }
    }

    public static void main(String[] args) {

        printType(100);

        printType("Ayushi");

        printType(99.99);

        printType(null);
    }
}