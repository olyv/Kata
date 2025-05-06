import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntToIPConverterTest {

    @Test
    public void sampleTest() {
        assertEquals("128.114.17.104", IntToIPConverter.longToIP(2154959208L));
        assertEquals("0.0.0.0", IntToIPConverter.longToIP(0));
        assertEquals("128.32.10.1", IntToIPConverter.longToIP(2149583361L));
    }
}