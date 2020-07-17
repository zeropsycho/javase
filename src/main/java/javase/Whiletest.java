package javase;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 循环案列
 */
public class Whiletest {

    private static Logger logger = Logger.getLogger("log");

    public static void main(String[] strings){
        System.out.println("请选择商品编号：");
        System.out.println("1.T恤\t2.网球鞋\t3.网球拍");

        Scanner gscanner = new Scanner(System.in);

        // 定义账户余额
        double theAccountBalance = 0.0;
        // 定义是否继续购买标识
        boolean gbla = true;
        // 初始化商品数量
        int gnumber = 0;
        // 初始化商品金额
        double gme = 0.0;

        // 实际金额
        double sjsum = 0.0;
        int gnumbe = 0;
        int gnumbers = 0;
        int gnumbersInt = 0;

        double tnum = 245.0; // t恤的价格
        double wnum = 570.0; // 网球价格
        double pnum = 320.0; // 网球拍价格

        // 折扣价
        double discount = 0.8;
        while (gbla) {
            // 存储各物品总计
            double gmesum = 0.0;

            System.out.println("请输入商品编号：");
            gnumbe = Integer.valueOf(gscanner.nextLine()); // 存储编号
            System.out.println("请输入商品数量："); // 存储数量
            gnumbers = Integer.valueOf(gscanner.nextLine());
            try {
                gnumbersInt = Integer.valueOf(gnumbers);
            } catch (NumberFormatException ex) {
                logger.info("整型转换异常！");
            }

            if (gnumbe < 1 && gnumbe > 3) {
                System.out.println("请重新输入！！！");
                gbla = true;
                break;
            }

            // 判段商品类型
            if (gnumbe == 1) {
                gmesum =  tnum * gnumbersInt; // 单件物品总额
                System.out.println("T恤\t￥"+ tnum +"\t数量：" + gnumbers + "\t合计：" + gmesum);
            } else if (gnumbe== 2) {
                gmesum =  wnum * gnumbersInt; // 单件物品总额
                System.out.println("网球\t￥"+ wnum +"\t数量：" + gnumbers + "\t合计：" + gmesum);
            } else if (gnumbe == 3) {
                gmesum =  pnum * gnumbersInt; // 单件物品总额
                System.out.println("网球拍\t￥"+ pnum +"\t数量：" + gnumbers + "\t合计：" + gmesum);
            }
            // 累加实际总额
            sjsum += gmesum;

            // 规范输入的值
            String jx = "";
            while (true) {
                System.out.println("是否继续(y/n)：");
                jx = gscanner.nextLine();
                if ("n".equals(jx) || "N".equals(jx) || "y".equals(jx) || "Y".equals(jx)) {
                    break;
                }
                System.out.println("请重新选择“Y N”！！！");
            }

            if ("n".equals(jx) || "N".equals(jx)) {
                break;
            } else if ("y".equals(jx) || "Y".equals(jx)) {
                gbla = true;
            }
        }

        // 显示账单信息
        double doDiscount = discount * sjsum;

        while (true) {
            if (doDiscount > theAccountBalance) {
                // 够金额 买单成功
                break;
            }
            System.out.println("账户余额不足，请充值：");
            theAccountBalance = gscanner.nextDouble();
            theAccountBalance += theAccountBalance;
        }

        System.out.println("折扣：" + discount);
        System.out.println("实际价格：" + sjsum);
        System.out.println("应付金额：" + doDiscount);
        System.out.println("支付成功！！！");
    }
}
