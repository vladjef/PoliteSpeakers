import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Симулятор конференции.
 * Каждый Докладчик (Speaker) пытается произнести речь и записать ее с помощью Recorder.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        Recorder recorder = new Recorder();


        Speaker vasya = new Speaker("Вася", "-Я приветствую всех собравшихся здесь сегодня", recorder);
        Speaker petya = new Speaker("Петя", "-Нам нужно обсудить выход в продакшен", recorder);
        Speaker olya = new Speaker("Оля", "-Вчера была чудесная погода", recorder);

        exec.execute(vasya);
        exec.execute(petya);
        exec.execute(olya);

        exec.shutdown();
    }
}
