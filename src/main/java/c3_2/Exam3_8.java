package c3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Exam3_8 {
    public static void main(String[] args) throws InterruptedException {
        Flowable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation()) // 기본 computation 이하 subscribeOn은 무시됨 RxComputationThreadPool
                .subscribeOn(Schedulers.io()) // io 스케줄러 RxCachedThreadScheduler
                .subscribeOn(Schedulers.single()) // single RxSingleScheduler
                .subscribe(d -> System.out.println(Thread.currentThread().getName()));

        Thread.sleep(500L);
    }
}
