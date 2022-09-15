import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(4);
        EvenOrOddThread thread=new EvenOrOddThread();
        for (int i=1;i<=10000;i++){
            executorService.execute(thread);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(thread.getEvenList().size());
        System.out.println(thread.getOddList().size());

    }
}
