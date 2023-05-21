package counter;

public class CounterThread extends Thread {

    private Counter counter;
    private boolean shouldDecrement;

    public CounterThread(Counter counter, boolean shouldDecrement) {

        this.counter = counter;
        this.shouldDecrement = shouldDecrement;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {

            if (shouldDecrement) {

                counter.decrement();
            } else {

                counter.increment();
            }
        }
    }
}
