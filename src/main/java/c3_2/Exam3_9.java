package c3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class Exam3_9 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable =
                Flowable.interval(300L, TimeUnit.MILLISECONDS) // 0.3초마다 시퀀스번호 생성
                        .onBackpressureDrop(); // 배압설정, 버퍼크기 이상은 파기

        flowable.observeOn(Schedulers.computation(), false, 1) // 버퍼 크기 1
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        try {
                            Thread.sleep(1000L); // 처리에 1초대기 가정, 1초를 대기하면 0.3초마다 생성되는 데이터를 설정에 따라 못받게 됨.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + aLong);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Thread.sleep(7000L);
    }
}
