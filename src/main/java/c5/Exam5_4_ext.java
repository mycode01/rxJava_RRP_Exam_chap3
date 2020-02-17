package c5;

import io.reactivex.processors.ReplayProcessor;
import io.reactivex.schedulers.TestScheduler;
import subscriber.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class Exam5_4_ext {
    public static void main(String[] args) { // 1 2 3 4 5 를 차례로 통지, ReplayProcessor는 모든 항목을 캐시하여 구독자에게 통지함.
        TestScheduler scheduler = new TestScheduler(); // 테스트용 스케쥴러, 시간 조정가능.
        ReplayProcessor<Integer> processor = ReplayProcessor.createWithTime(1, TimeUnit.SECONDS, scheduler); // 모든 데이터를 캐시하지만, 시간제한을 둠.
//        ReplayProcessor<Integer> processor = ReplayProcessor.createWithTimeAndSize(1, TimeUnit.SECONDS, scheduler, 3); // 시간제한, 갯수제한, 이상함

        processor.subscribe(new DebugSubscriber<>("no.1"));

        processor.onNext(1);
        processor.onNext(2);
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS); // 임의로 통지자의 1초를 앞당김
//        scheduler.advanceTimeTo(1, TimeUnit.SECONDS);
        processor.onNext(3);

        System.out.println("subscriber no.2 added");
        processor.subscribe(new DebugSubscriber<>("--- no.2")); // 캐시된 3만을 통지받음. 이 시점에서는 1 2는 삭제되었음.

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete();

        System.out.println("subscriber no.3 added");
        processor.subscribe(new DebugSubscriber<>("--- no.3")); // 통지가 끝났지만 캐시된 데이터를 통지받음. 1 2 를 제외
    }

}
