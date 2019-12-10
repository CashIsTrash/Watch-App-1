package model;

public class Timer {

    private long h;
    private long min;
    private long sec;


    public Timer(long h, long min, long sec) {
        this.sec = sec;
        this.min = min;
        this.h = h;
    }

    public long getH() {
        return h;
    }

    public long getMin() {
        return min;
    }

    public long getSec() {
        return sec;
    }
}
