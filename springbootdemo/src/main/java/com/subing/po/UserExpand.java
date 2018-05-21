package com.subing.po;

/**
 * Created by SUBING on 2018/4/4.
 */
public class UserExpand extends User {
    private int num;

    @Override
    public String toString() {
        return "UserExpand{" +
                "num=" + num +
                "} " + super.toString();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
