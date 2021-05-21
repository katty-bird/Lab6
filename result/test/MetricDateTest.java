package result.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import result.main.JulianDate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

class MetricDateTest {

    private JulianDate julianDate;

    @BeforeEach
    public void setUp() throws Exception {
        julianDate = new JulianDate(1582, 10, 15);
    }

    @Test
    @DisplayName("Test if the tomorrow method works correctly")
    void testTomorrow() {
        //TODO Test erstellen
    }

}
