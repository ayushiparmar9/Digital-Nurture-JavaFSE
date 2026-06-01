public class TypeCastingExample {

    public static void main(String[] args) {

        double d = 45.89;

        int num = (int)d;

        System.out.println("Double Value = " + d);
        System.out.println("Converted to int = " + num);

        int x = 100;

        double y = x;

        System.out.println("Int Value = " + x);
        System.out.println("Converted to double = " + y);
    }
}