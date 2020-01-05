package c3_2;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class Exam3_5_test {
    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                    .doOnNext(d -> System.out.println("emit: " + System.currentTimeMillis() + " 밀리초: " + d + "thread name: " + Thread.currentThread().getName()))
                    .subscribe(d -> Thread.sleep(500L));

            try {
                Thread.sleep(6000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//        runnable.run();
//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(1000L);
//            System.out.println(Thread.currentThread().getName());
//        }
        Runnable runnable2 = () -> {
            Flowable.just(1, 2, 3, 4, 5, 6, 7)
                    .subscribe(new ResourceSubscriber<Integer>() {
                        @Override
                        public void onNext(Integer integer) {
                            System.out.println(Thread.currentThread().getName() + ": " + integer);
                        }

                        @Override
                        public void onError(Throwable t) {
                            t.printStackTrace();
                        }

                        @Override
                        public void onComplete() {
                            System.out.println(Thread.currentThread().getName() + ": 완료");

                        }
                    });
        };
        runnable.run();
        System.out.println("ddd");
        runnable2.run();
    }
}
