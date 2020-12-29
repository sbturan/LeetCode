public class PrintFooBarAlternately {
    class FooBar {
        private int n;
        boolean first;
        public FooBar(int n) {
            this.n = n;
            this.first=true;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while(!this.first){
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                this.first=false;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while(this.first){
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.first=true;
                notifyAll();
            }
        }
    }
}
