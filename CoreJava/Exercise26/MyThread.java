class MyThread extends Thread {

    private String message;

    public MyThread(String message) {

        this.message = message;
    }

    @Override
    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println(
                    message + " - " + i);
        }
    }
}