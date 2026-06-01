public class VirtualThreadExample {

    public static void main(String[] args)
            throws InterruptedException {

        for(int i = 1; i <= 100000; i++) {

            int id = i;

            Thread.startVirtualThread(
                    () -> {

                        System.out.println(
                                "Virtual Thread "
                                        + id
                        );
                    }
            );
        }

        Thread.sleep(3000);

        System.out.println(
                "Finished"
        );
    }
}