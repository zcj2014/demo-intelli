package cn.umbrella.intelli;


import cn.umbrella.intelli.pattern.Client;
import cn.umbrella.intelli.pattern.Data;

public class Application {

    public static void main(String[] pars){
        Client client = new Client();
        // 这里立刻返回，因为得到的是FutureData，而不是RealData.
        Data data = client.request("hello:n");
        System.out.println("请求完毕：");
        try {
            // 这里可以用sleep代替其他业务处理。
            // 在处理业务逻辑的过程中，RealData被创建，则充分利用了等待时间。
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 使用真实的数据
        System.out.println("数据= " + data.getResult());
    }
}
