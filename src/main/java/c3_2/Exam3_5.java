package c3_2;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Exam3_5 {
    public static void main(String[] args) throws Exception {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(d -> System.out.println("emit: " + System.currentTimeMillis() + " 밀리초: " + d))
                .subscribe(d -> Thread.sleep(500L));

        Thread.sleep(6000L);
    }
}

// 원래대로라면
// 인터벌 시간인 1초 + 소비시간인 0.5초 = 한 사이클에 걸리는 시간 1.5초가 되어야 하겠지만,
// api자체적으로 "기능을 제공" 한다고 하고있지만
