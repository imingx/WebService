package server;

import javax.xml.ws.Endpoint;
import javax.jws.WebService;

@WebService
public class StudentImpl implements StudentInterface {

    String name[]={
            " 姜倩云 "," 张丽梅 "," 吴美庆 "," 张忠敏 "," 王雅蓉 "," 葛红敏 "," 赵斌灿 "," 王严鑫 ",
            " 莫可宏 "," 王猛 ", " 侯勇军 "," 马铸辉 "," 易鹏 "," 罗路辉 "," 闫治鹏 "," 孙磊 "," 李佳玲 ",
            " 王勃博 "," 康尧 "," 张波 ", " 邓雷 "," 陈佳鑫 "," 唐炜宁 "," 葛龙 "," 倪赛杰 "," 陈成 ",
            " 刘浩浩 "," 周子轩 "," 宫蕊 "," 文云丽 "," 沈雪 "," 刘冬媛 "," 褚蓉 "," 钱苑 "," 董樟裕 ",
            " 马凌杰 "," 王京源 "," 陈辉云 "," 罗建兴 "," 陈晨 "," 赵文宇 "," 宗玮雯 "," 赵贝贝 ",
            " 黄豪琛 "," 娄宽 "," 任上海 "," 王康 "," 沈楠 "," 蒋宇 "," 吕阳 "," 王刚 "," 王扬 "," 吕中剑 ",
            " 张军 "," 卢惺鑫 "," 姚礼宗 "
    };

    @Override
    public String studentQuery(int number) {
        System.out.println("from client..." +" 学号 :" +number);
        String result = name[number];
        System.out.println("to client..." + " 姓名 :"+result);
        return result;
    }

    public static void main(String[] args) {
        //java jdk提供一个自带的类可以将java应用程序发布成webservice
        /**
         * Endpoint.publish(String address, Object implementor):
         * 参数1：提供服务对外的访问地址
         * 参数2：提供服务的类的对象
         *
         * */
//        Endpoint.publish("http://localhost:8080/servers/StudentImpl", new StudentImpl());
        System.out.println(" 发布成功 ...");
    }
}
