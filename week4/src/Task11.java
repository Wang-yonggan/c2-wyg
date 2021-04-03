/**
 * t
 * * @ClassName : Task11
 * * @Auhor : wang-yonggan
 *
 * @Date: 2021-02-25 20:21
 */
class Massage {
    private String title;
    private String content;
    private boolean flag;

    public synchronized void set(String title, String content) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        this.content = content;
        this.flag = true;
        this.notify();
    }

    public synchronized void getMassage() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.flag = false;
        System.out.println(title + "------->" + content);
        this.notify();
    }


}

class Producer implements Runnable {
    Massage msg;

    public Producer(Massage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                msg.set("java", "intellij");
            } else msg.set("python", "pycharm");
            System.out.println("生产" + i);
        }
    }
}

class Consumer implements Runnable {
    Massage msg;

    public Consumer(Massage msg) {
        this.msg = msg;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            msg.getMassage();
        }
    }
}

public class Task11 {
    public static void main(String[] args) {
        Massage msg = new Massage();
        Producer p = new Producer(msg);
        Consumer c = new Consumer(msg);
        new Thread(p).start();
        new Thread(c).start();
    }
}
