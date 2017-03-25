package cn.umbrella.intelli.pattern;


public class RealData implements Data{

    private  String result;

    public RealData(String para) {
        // RealData可能构造很慢，需要用户等待很久，这里使用sleep模拟。
        StringBuilder sb = new StringBuilder();
        for ( int i = 1 ; i <= 10 ; i++){
            sb.append(para);
            try {
                // 这里使用sleep，代替一个很慢的操作。
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        result = sb.toString();

    }

    @Override
    public String getResult() {
        return result;
    }
}
