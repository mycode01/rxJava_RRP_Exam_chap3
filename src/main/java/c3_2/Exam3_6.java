package c3_2;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class Exam3_6 {
    public static void main(String[] args) {
        System.out.println("start");

        Flowable.just(1, 2, 3)
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
        System.out.println("end");
    } // 메인스레드에서 작동하기 때문에 차례로 메시지가 출력됨
}
