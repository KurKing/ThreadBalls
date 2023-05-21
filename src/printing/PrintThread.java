package printing;

import java.util.concurrent.Semaphore;

public class PrintThread extends Thread {

    private String symbol;
    private boolean shouldPrintEnter;

    private Semaphore currentSemaphore;
    private Semaphore nextSemaphore;

    public PrintThread(String symbol, boolean shouldPrintEnter, Semaphore currentSemaphore, Semaphore nextSemaphore) {

        this.symbol = symbol;
        this.shouldPrintEnter = shouldPrintEnter;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            if (shouldPrintEnter) {

                System.out.println("");
            }

            for (int j = 0; j < 50; j++) {

                try {

                    currentSemaphore.acquire();
                    System.out.print(symbol);
                    nextSemaphore.release();

                } catch (InterruptedException e) {

                    throw new RuntimeException(e);
                }
            }
        }
    }
}
