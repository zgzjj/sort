package com.sharewine;

//泊松分酒
public class ShareWine {
    private int Bottle1 = 12;
    private int Bottle2 = 8;
    private int Bottle3 = 5;
    private int m = 6;//目标酒量

    private void backBottle(int b1, int b2, int b3) {
        System.out.println("杯子1酒量：" + b1 + ", 杯子2酒量：" + b2 + ", 杯子3酒量：" + b3);
        if (b1 == m || b2 == m || b3 == m) {
            System.out.println("倒出目标酒量");
            return;
        }
        if (b2 != 0 && b3 != Bottle3) {
            if (b2 + b3 < Bottle3) {
                //到不满
                backBottle(b1, 0, b2 + b3);

            } else {
                backBottle(b1, b2 + b3 - Bottle3, Bottle3);
            }
        } else if (b3 == Bottle3) {
            //瓶子3满往瓶子1倒
            if (b3 + b1 < Bottle1) {
                //说明倒不满
                backBottle(b1 + b3, b2, 0);
            } else {
                backBottle(Bottle1, b2, b3 + b1 - Bottle1);
            }
        } else if (b2 == 0) {
            //从瓶子1往瓶子2倒酒
            if (b1 >= Bottle2) {
                backBottle(b1 - Bottle2, Bottle2, b3);
            } else {
                backBottle(0, b1, b3);
            }
        }
    }

    public static void main(String[] args) {
        ShareWine shareWine = new ShareWine();
        shareWine.backBottle(12, 0, 0);
    }
}
