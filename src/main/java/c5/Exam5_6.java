package c5;

import io.reactivex.processors.UnicastProcessor;
import org.reactivestreams.Subscriber;
import subscriber.DebugSubscriber;

public class Exam5_6 {
    public static void main(String[] args) throws InterruptedException {
//        UnicastProcessor<Integer> processor = UnicastProcessor.create(); // 오직 1개의 subscriber만 허용
//        UnicastProcessor<Integer> processor = UnicastProcessor.create(1); // 캐시 크기 지정, 캐시 크기를 넘으면 같이 증가.
        UnicastProcessor<Integer> processor = UnicastProcessor.create(1, ()-> System.out.println("cancelled")); // 캐시 크기 지정, 캐시 크기를 넘으면 같이 증가.

        processor.onNext(1);
        processor.onNext(2);

        System.out.println("Subscriber no.1 added");
        Subscriber<Integer> d = new DebugSubscriber<>("no.1");
        processor.subscribe(d);
        processor.onNext(3);

        System.out.println("Subscriber no.2 added");
        processor.subscribe(new DebugSubscriber<>("--- no.2")); // 이미 no.1가 있기때문에 IllegalStateException

        processor.onNext(4);
        processor.onNext(5);
        processor.onComplete(); // onCancelled 가 있을때 이 앞에서 실행됨. 구현이 그러함.

        processor.subscribe(new DebugSubscriber<>("---no.3"));
    }
}
