package c3_1.observer;

public interface Observer {
    void update(Generator generator);  // 관찰대상과의 동기화를 위한 통지 메서드
}