public class Test {

    public static void main(String args[]) {
        MyThread thread=new MyThread();
       Thread th=new Thread(thread);
       th.start();
    }

    public static class MyThread implements Runnable{
        String text;
        public void setText(String text){
            this.text=text;
        }
        @Override
        public void run() {
            System.out.println(text);
        }
    }

}