import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) {

        try {

            Class<?> clazz =
                    Class.forName("Student");

            Object obj =
                    clazz.getDeclaredConstructor()
                            .newInstance();

            Method[] methods =
                    clazz.getDeclaredMethods();

            System.out.println(
                    "Methods:"
            );

            for(Method method : methods) {

                System.out.println(
                        method.getName()
                );
            }

            Method display =
                    clazz.getDeclaredMethod(
                            "display"
                    );

            display.invoke(obj);

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}