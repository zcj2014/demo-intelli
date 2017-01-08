package cn.umbrella.intelli;


    public class HelloWorld {
        public static void main(String[] args) {
            Thread10_Entity entity = new Thread10_Entity();
            Thread10_1 t10_1 = new  Thread10_1(entity);
            t10_1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(entity.get());

        }
    }

    class Thread10_1 extends Thread {
        private Thread10_Entity thread10_Entity;

        public Thread10_1(Thread10_Entity t10) {
            this.thread10_Entity = t10;
        }
        @Override
        public void run() {
            thread10_Entity.set("admin", "admin");
        }
    }
    class Thread10_Entity {
        private String username = "user";
        private String password = "user";
        private byte[] lock = new byte[0];

         void set(String username, String password) {
             synchronized(this.password) {
                 this.username = username;
                 try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
                 this.password = password;
             }
        }

         String get() {
             synchronized(this.password) {
                 System.out.println("你好！");
                 return username + "   " + this.password;
             }
        }
    }

