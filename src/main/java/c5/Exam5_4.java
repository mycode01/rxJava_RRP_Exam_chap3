package c5;

import io.reactivex.Scheduler;
import io.reactivex.processors.ReplayProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import subscriber.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class Exam5_4 {
    public static void main(String[] args) { // 1 2 3 4 5 를 차례로 통지, ReplayProcessor는 모든 항목을 캐시하여 구독자에게 통지함.
        ReplayProcessor<Integer> processor = ReplayProcessor.create(); // 모든 통지 데이터 캐시
//        ReplayProcessor<Integer> processor = ReplayProcessor.create(2); // 캐시 크기를 설정, 하지만 초기값을 넘으면 캐시크기도 같이 증가함. 무슨의미가?
//        ReplayProcessor<Integer> processor = ReplayProcessor.createWithSize(2); // 캐시 크기를 제한, 오래된 캐시는 삭제됨.
        processor.subscribe(new DebugSubscriber<>("no.1"));

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);

        System.out.println("subscriber no.2 added");
        processor.subscribe(new DebugSubscriber<>("--- no.2")); // 앞서 통지된 모든데이터(캐시됨) 1 2 3을 통지받음.

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete();

        System.out.println("subscriber no.3 added");
        processor.subscribe(new DebugSubscriber<>("--- no.3")); // 통지가 끝났지만 캐시된 데이터를 통지받음.
    }

}
