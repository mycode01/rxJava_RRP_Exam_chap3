package c3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import static c3_2.Exam3_13.Counter;

public class Exam3_15 {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Flowable<Integer> f1 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable<Integer> f2 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable.merge(f1, f2) // 두개의 Flowable을 merge로 묶어 순차성을 지킴
                .subscribe(d -> counter.increment(),
                        e -> System.out.println("error=" + e),
                        () -> System.out.println("counter.get()=" + counter.get()));

        Thread.sleep(1000L);
    }
}
