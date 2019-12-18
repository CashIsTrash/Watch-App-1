package sample.model;

public class WatchTimer {

    private long h;
    private long min;
    private long sec;


    public WatchTimer(long h, long min, long sec) {
        this.sec = sec;
        this.min = min;
        this.h = h;
    }

    public void setH(long h) {
        this.h = h;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setSec(long sec) {
        this.sec = sec;
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
