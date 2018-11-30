import java.util.concurrent.locks.Lock;

/**
 * Докладчик.
 * При запуске произносит фразу для записывающего устройства.
 */
public class Speaker implements Runnable {
    private String name;
    private String phrase;
    private Recorder recorder;

    public Speaker(String name, String phrase, Recorder recorder) {
        this.name = name;
        this.phrase = phrase;
        this.recorder = recorder;
    }


    @Override
    public void run() {
        synchronized (recorder) {
            System.out.println("Слово получает " + name);

            recorder.reset();   // Так как Записывающее устройство одно на всех, нужно очистить его память перед записью фразы.
            recorder.recordAmplified(phrase);

            System.out.println(name + " записал: " + recorder.play());

        }
    }
}