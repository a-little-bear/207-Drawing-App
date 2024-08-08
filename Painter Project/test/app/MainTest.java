package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {
    @Test
    void testMainRunsWithoutExceptions() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
