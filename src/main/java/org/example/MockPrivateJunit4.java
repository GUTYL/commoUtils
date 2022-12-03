package org.example;

public class MockPrivateJunit4 {

    public void meaningfulPublicApi() {
        if (doTheGamble("Whatever", 1)) {
            throw new RuntimeException("boom");
        }
    }

    private boolean doTheGamble(String whatever, int binary) {
        return true;
    }

    public void publicMethod() {
        Integer c = 1;
        System.out.println(privateMethod(c));
    }

    private int privateMethod(Integer c) {
        System.out.println("print private method");
        return c - 1;
    }
}