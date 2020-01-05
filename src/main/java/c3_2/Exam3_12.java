package c3_2;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Exam3_12 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E", "F")
                .concatMapEager(d -> Flowable.just(d).delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(d -> System.out.format("%s : data=%s : time=%s\n"
                , Thread.currentThread().getName(), d, DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now())));

        Thread.sleep(2000L);
//        RxComputationThreadPool-1 : data=A : time=05.855
//        RxComputationThreadPool-1 : data=B : time=05.870
//        RxComputationThreadPool-1 : data=C : time=05.870
//        RxComputationThreadPool-1 : data=D : time=05.870
//        RxComputationThreadPool-1 : data=E : time=05.871
//        RxComputationThreadPool-1 : data=F : time=05.871
        // 거의 동시에 처리됨
    }
}
