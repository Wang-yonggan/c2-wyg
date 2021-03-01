public class Task10 implements Runnable {
    private int print = 10;
    private boolean a_b;//flase a print

    @Override
    public void run() {
        for (int i = 0; i < 13 && print >= 0; i++) {
            APrint();
        }
    }

    public synchronized void APrint() {
        System.out.printf("线程%s打印:%d\n", Thread.currentThread().getName(), 10 - print);
        print--;
        notifyAll();
        if (print >= 0)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        Runnable runnable = new Task10();
        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();

    }
}


/**
 * @ClassName : Task10
 * @Author : wang-yonggan
 * @Date: 2021-02-25 15:56
 * 100ms可忽略函数运行时间
 * time     A       B       此时print   print--        打印
 * 1000ms:  打印     sleep       2      1              8
 * /
 * /
 * 1100ms:  sleep   打印         1     0(退出while)    9
 * /
 * /
 * 1200ms:  打印     sleep       0     -1(退出while)   10
 * <p>
 * //public class Task10 implements Runnable {
 * //    private int print = 10;
 * //
 * //    public static void main(String[] args) {
 * //        Runnable runnable = new Task10();
 * //        new Thread(runnable, "A").start();
 * //        try {
 * //            Thread.sleep(1);
 * //        } catch (InterruptedException e) {
 * //            e.printStackTrace();
 * //        }
 * //        new Thread(runnable, "B").start();
 * //
 * //    }
 * //
 * //    @Override
 * //    public void run() {
 * //        for (int i = 0; i < 11; i++) {
 * //            try {
 * //                Thread.sleep(1);
 * //            } catch (InterruptedException e) {
 * //                e.printStackTrace();
 * //            }
 * //            ABPrint();
 * //        }
 * //    }
 * //
 * //    public synchronized void ABPrint() {
 * //        if (print >= 0) {
 * //            try {
 * //                Thread.sleep(1);
 * //            } catch (InterruptedException e) {
 * //                e.printStackTrace();
 * //            }
 * //            System.out.printf("线程%s打印:%d\n", Thread.currentThread().getName(), 10 - print);
 * //            print--;
 * //        }
 * //    }
 * //}
 * /**
 * 100ms可忽略函数运行时间
 * time     A       B       此时print   print--        打印
 * 1000ms:  打印     sleep       2      1              8
 * /
 * /
 * 1100ms:  sleep   打印         1     0(退出while)    9
 * /
 * /
 * 1200ms:  打印     sleep       0     -1(退出while)   10
 */

//public class Task10 implements Runnable {
//    private int print = 10;
//    private Integer time_a = 0;
//    private Integer time_b = 100;
//
//    public static void main(String[] args) {
//        Runnable runnable = new Task10();
//        new Thread(runnable, "A").start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(runnable, "B").start();
//
//    }
//
//    @Override
//    public void run() {
//        while (print > 0) {
//            String name = Thread.currentThread().getName();
//            try {
//                Thread.sleep(200);
//                int time = time_a;
//                if (name.equals("B")) {
//                    time_b += 200;
//                    time = time_b;
//                } else {
//                    time_a += 200;
//                    time = time_a;
//                }
//                System.out.printf("线程%s打印:%d---time-->%dms\n", name, 10 - print, time);
//                print--;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}