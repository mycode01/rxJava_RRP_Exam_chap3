package c3_1;

import io.reactivex.Flowable;

import java.util.Arrays;
import java.util.List;

public class Exam3_3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c"); // 데이터 집합체
        Flowable<String> flowable = Flowable.fromIterable(list); // aggregate임과 함께 iterator

        flowable.subscribe(d -> System.out.println(d));
    }
}
