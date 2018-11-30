/**
 * Записывающее устройство.
 */
public class Recorder {
    /**
     * Внутренняя память записывающего устройства для сохранения фразы докладчика.
     */
    private StringBuilder buf = new StringBuilder();

    /**
     * Сброс - очистка внутренней памяти.
     */
    public void reset() {
        buf.setLength(0);
        buf.trimToSize();
    }

    /**
     * Записывает "речь" (фразу) докладчика посимвольно.
     * @param phrase фраза докладчика
     */
    public void recordAmplified(String phrase) {
        for (char symbol : phrase.toCharArray()) {
            buf.append(amplify(symbol));
        }
    }

    /**
     * Усиливает "сигнал".
     * @param character отдельный символ из фразы докладчика
     * @return символ, преобразованный к верхнему регистру
     */
    private char amplify(char character) {
        return Character.toUpperCase(character);
    }

    /**
     * Воспроизведение.
     * @return - записанная речь (строка)
     */
    public String play() {
        return buf.toString();
    }
}
