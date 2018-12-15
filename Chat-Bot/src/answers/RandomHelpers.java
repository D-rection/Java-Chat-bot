package answers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomHelpers {
    public static <T> T pickRandom(T[] elements) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return elements[random.nextInt(elements.length)];
    }
}

