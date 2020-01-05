package c3_2;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Exam3_4 {
    public static void main(String[] args) throws Exception {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS) //1초마다 시퀀스 번호 통지
                .doOnNext(d -> System.out.println("emit: " + System.currentTimeMillis() + " 밀리초: " + d)) // 실제 통지받은 시각과 데이터 출력
                .subscribe(d -> Thread.sleep(2000L)); // 2초 대기

        Thread.sleep(6000L); //인터벌 작업이 가능하도록 스레드에게 6초 시간을 주고 작업이 끝나도록 함.
    }
}
