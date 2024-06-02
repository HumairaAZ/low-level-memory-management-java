package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowLevelMemoryManagementTest {

    @Test
    public void testMemoryAllocationAndFree() {
        LowLevelMemoryManagement memory = new LowLevelMemoryManagement(1024);
        memory.setMemory((byte) 1, 1024);

        for (int i = 0; i < 1024; i++) {
            assertEquals(1, memory.getByte(i));
        }

        memory.freeMemory();
    }
}
