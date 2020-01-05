package c3_2;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class Exam3_7 {
    public static void main(String[] args) throws Exception {
        System.out.println("start");

        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        System.out.println(Thread.currentThread().getName() + ": " + aLong);
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
        System.out.println("end");
        Thread.sleep(1000L);
    } // interval method로 생산자(flowable)을 생성했기 때문에 별도의 스레드로 작동.
}
