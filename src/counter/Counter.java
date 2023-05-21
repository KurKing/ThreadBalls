package counter;

public class Counter {

    private int count = 0;

    synchronized public void increment() {

        count += 1;
    }

    synchronized public void decrement() {

        count -= 1;
    }

//    public void increment() {
//
//        count += 1;
//    }
//
//    public void decrement() {
//
//        count -= 1;
//    }

    public int getCount() { return count; }
}
