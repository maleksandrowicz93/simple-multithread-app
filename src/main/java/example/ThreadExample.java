package example;

public class ThreadExample {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 999; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 999; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });

        t1.setPriority(1);
        t2.setPriority(10);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

    }

}
