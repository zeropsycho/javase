package javase.carrental;

/**
 * 轿车类的租金计算方式
 */
public class Car extends MotorVehicle {

    // 租金常量
     final String bkRent = "600";
     final String bmRent = "500";
     final String bklyddRent = "300";
     final String bk = "别克商务舱GL8";
     final String bm = "宝马550i";
     final String bklydd = "别克林荫大道";

    public static String[][] carStr = null;

    public String[] findCar() {
        return new String[]{bk,bkRent,bm,bmRent,bklydd,bklyddRent};
    }

    /**
     * 查询车型价格
     */
    public String[] indexCar(int number) throws Exception {
        if (number == 0) throw new Exception("编号不能为空");
        switch (number) {
            case 1:
                return new String[]{bk, bkRent};
            case 2:
                return new String[]{bm, bmRent};
            case 3:
                return new String[]{bklydd, bklyddRent};
                default:
                    throw new Exception("该编号不存在，请重新输入。");
        }
    }

    public String[][] insertCar(String[] model) {
        if (carStr == null) {
            carStr = new String[1][2];
            carStr[0] = model;
            return carStr;
        }

        String[][] carStr1 = carStr;
        for (int i = 0; i == carStr.length - 1; i++) {
            carStr = new String[i + 1][i + 2]; // 扩容
//            carStr = carStr1;
            System.arraycopy(carStr1, 0, carStr, 0, carStr1.length + carStr.length);
            carStr[i + 1] = model;
        }
        return carStr;
    }

    /**
     * 计算金额
     *
     * @param day
     * @param rents
     * @return
     */
    @Override
    public double rent(int day, double rents) {
        if (day != 0 && rents != 0.0) return 0.0;
        // 天数 * 租金 = 租赁价
        return day * rents;
    }
}
