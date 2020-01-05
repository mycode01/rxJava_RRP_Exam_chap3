package c3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Exam3_13 {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation()) // 비동기 처리
                .observeOn(Schedulers.computation()) // 비동기 처리
                .subscribe(d -> counter.increment(),
                        e -> System.out.println("error=" + e),
                        () -> System.out.println("counter.get()=" + counter.get()));

        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation()) // 비동기 처리
                .observeOn(Schedulers.computation()) //비동기 처리
                .subscribe(d -> counter.increment(),
                        e -> System.out.println("error=" + e),
                        () -> System.out.println("counter.get()=" + counter.get()));

        Thread.sleep(1000L);

//        counter.get()=17980
//        counter.get()=19980
        // 예상대로라면 각각 10000, 20000이 되어야 하지만 그렇지 못함

    }

    static class Counter {
        private volatile int count;

        void increment() { // increment를 호출하는 두 소비자가 동시에 접근이 가능하기 때문에 순차성이 지켜지지 않음
            count++;
        }

        int get() {
            return count;
        }
    }
}