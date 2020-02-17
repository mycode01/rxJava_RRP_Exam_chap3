package subscriber;

import io.reactivex.subscribers.DisposableSubscriber;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DebugSubscriber<T> extends DisposableSubscriber<T>{
    private String label;

    public DebugSubscriber() {
        super();
    }

    public DebugSubscriber(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onNext(T data) {
        if (label == null) {
            System.out.println(Thread.currentThread().getName() + ": " + data);
//            System.out.format("%s : data=%s : time=%s\n"
//                    , Thread.currentThread().getName(), data, DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now()));
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + label + ": " + data);
//            System.out.format("%s : %s data=%s : time=%s\n"
//                    , Thread.currentThread().getName(), label, data,DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now()));
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if (label == null) {
            System.out.println(Thread.currentThread().getName() + ": error=" + throwable);
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + label + ": error=" + throwable);
        }
    }

    @Override
    public void onComplete() {
        if (label == null) {
            System.out.println(Thread.currentThread().getName() + ": complete");
//            System.out.format("%s : complete : time=%s\n"
//                    , Thread.currentThread().getName(), DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now()));
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + label + ": complete");
//            System.out.format("%s : %s complete : time=%s\n"
//                    , Thread.currentThread().getName(), label, DateTimeFormatter.ofPattern("ss.SSS").format(LocalTime.now()));
        }
    }
}
