package javase;

import java.util.Scanner;

public class Fortest {

    public static void main(String[] arg) {

        Scanner ageScan = new Scanner(System.in);

        // 初始化数组 改进可扩容
        Integer[] ages = new Integer[10];
        // a的百分比
        int prep;
        // b的百分比
        int theFollowing;

        int current = 0;
        int count = 1; // 总人数
        int ageCounts = 0;
        double ageCountDouble = 0.00;

        // 结束录入人员标识 “n”
        System.out.println("温馨提示：如需结束录入人员，请输入N！！！");
        String ageFla = "";
        while (ageFla.equals("")) {
            System.out.println("请输入第" + count++ + "位顾客的年龄(或者输入“N”结束本次人员录入)：");
            String currentStr = ageScan.nextLine();

            if (isNumber(currentStr)) {
                ages[ageCounts] = Integer.parseInt(currentStr); // 将客人名字存入数组 进行统一管理
                    ageCounts++;
                continue;
            }
            if (!currentStr.equals("N") && !currentStr.equals("n")) {
                System.out.println("请按问题要求填写！！！");
                count--;
                continue;
            } else if (currentStr.equals("N") || currentStr.equals("n")) {
                break;
            }

        }

        if (ages.length < 1 ){
            System.out.println("没有输入人数，本次不做统计");
            return;
        }
        // 通过人员库操作人员数据 （统计30岁以上、30岁以下的人员百分比）
        Integer[] age30s = new Integer[10];
        Integer[] age30x = new Integer[10];
        int ageCount = 0;
        int age30sCount = 0;
        int age30xCount = 0;
        for (Integer agesStr : ages) {
            if (agesStr == null || agesStr.equals("")) {
                break;
            }
            // 取出30岁以上的人
            if (agesStr > 30) {
                age30s[++ageCount] = agesStr;
                age30sCount++;
            } else { // 取出30岁以下的人
                age30x[++ageCount] = agesStr;
                age30xCount++;
            }
        }
        // 计算百分比
        ageCountDouble = ageCounts;
        prep = (int) ((age30sCount / ageCountDouble) * 100);
        theFollowing = (int) ((age30xCount / ageCountDouble) * 100);

        // 输出
        System.out.println("30岁以上的年龄占比为：" + prep + "%");
        System.out.println("30岁以上的年龄占比为：" + theFollowing + "%");
    }

    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumber(String str) {
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
