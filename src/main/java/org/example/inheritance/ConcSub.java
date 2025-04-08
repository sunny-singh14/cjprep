package org.example.inheritance;

public class ConcSub extends AbSuper {
    ConcSub() {
        super(10);
    }

    public int getNum() {
        return num1;
    }

    public void setNum(int num) {
        super.num1 = num;
    }
}
