package cn.umbrella.intelli.pattern;


public class FutureData implements Data{
    // FutureData是RealData的包装。
    private RealData realData = null;
    private boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        // RealData已经被注入，通知getResult。
        notifyAll();
    }

    @Override
    public String getResult() {
        // 会等待RealData构造完成
        while (!isReady){
            try {
                // 一直等待， 直到RealData被注入
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 由RealData实现
        return realData.getResult();
    }
}
