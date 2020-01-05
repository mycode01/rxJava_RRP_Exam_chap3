package c3_2;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Exam3_10 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E", "F", "E", "F")
                .flatMap(d -> Flowable.just(d).delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(d -> System.out.println(Thread.currentThread().getName() + " : " + d));

        Thread.sleep(2000L);
//        RxComputationThreadPool-3 : C
//        RxComputationThreadPool-1 : A
//        RxComputationThreadPool-1 : B

    }
}
