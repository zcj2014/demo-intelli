package cn.umbrella.intelli.pattern;


public class Client {
    public Data request(final String queryStr){
        final  FutureData futureData = new FutureData();
        new Thread(){
            @Override
            public void run() {
                // RealData构建很慢，所以在单独的线程中进行。
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);

            }
        }.start();
        // FutureData会被立即返回。
        return futureData;
    }
}
