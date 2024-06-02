package com.example;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class LowLevelMemoryManagement {
    private static final Unsafe unsafe;
    private long address;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LowLevelMemoryManagement(long size) {
        address = unsafe.allocateMemory(size);
    }

    public void setMemory(byte value, long size) {
        unsafe.setMemory(address, size, value);
    }

    public byte getByte(long offset) {
        return unsafe.getByte(address + offset);
    }

    public void freeMemory() {
        unsafe.freeMemory(address);
    }

    public static void main(String[] args) {
        LowLevelMemoryManagement memory = new LowLevelMemoryManagement(1024);
        memory.setMemory((byte) 1, 1024);

        for (int i = 0; i < 1024; i++) {
            if (memory.getByte(i) != 1) {
                throw new RuntimeException("Memory set incorrectly at offset " + i);
            }
        }

        memory.freeMemory();
        System.out.println("Memory management completed successfully.");
    }
}
