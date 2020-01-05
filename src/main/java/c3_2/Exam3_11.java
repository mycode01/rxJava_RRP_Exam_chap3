package c3_2;

import io.reactivex.Flowable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Exam3_11 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E", "F")
                .concatMap(d -> Flowable.just(d).delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(d -> System.out.format("%s : data=%s : time=%s\n"
                , Thread.currentThread().getName(), d, DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now())));

        Thread.sleep(5000L);
//        RxComputationThreadPool-1 : data=A : time=06.540
//        RxComputationThreadPool-2 : data=B : time=07.559
//        RxComputationThreadPool-3 : data=C : time=08.575
//        RxComputationThreadPool-4 : data=D : time=09.577
        // 모든 데이터의 순환도 끝마치지 못함
    }
}
