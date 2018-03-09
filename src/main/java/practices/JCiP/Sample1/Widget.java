package practices.JCiP.Sample1;

/**
 * Reentry lock.
 */
public class Widget {

    public synchronized void doSomething() {

    }

}

class LoggingWidget extends Widget {

    public synchronized void doSomething() {
        super.doSomething();
    }

}
