/* Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель.
Пока производитель не поставит на склад продукт, покупатель не может его забрать.
Реализовать приход товара от производителя в магазин случайным числом.
В том случае, если товара в магазине не хватает– вывести сообщение.*/

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Random random = new Random();
        Shop shop = new Shop();
        Thread delivery = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                       try {
                        shop.delivery();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Товар поставлен в магазин. В наличие " + shop.get_count() + " штук.");

                }
            }
        });

        Thread buyer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String rez = shop.buyer(random.nextInt(0, 100));
                        Thread.sleep(5000);
                        System.out.println(rez);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

    //    buyer.start();
        delivery.start();
        buyer.start();
    }

    static class Shop {
        private int count_t;
        boolean aval_flg;
        Random random = new Random();

        public Shop() {
            this.count_t = 0;
            this.aval_flg = false;
        }

        public void delivery() {
            this.count_t =this.count_t + random.nextInt(1, 100);
            this.aval_flg = true;
        }
        public int get_count() {
            return this.count_t;
        }
        public String buyer(int c) {
            String ret;
            if (this.aval_flg = false) {
                ret = "Тавара нет в наличии. Дождитесь поставки!";
                return ret;
            } else {
                if (c > this.count_t) {
                    ret = "Тавара нет в наличии в данном объеме  " + c +" штук. " +
                            "Дождитесь поставки или запросите меньше! В наличие: " + this.count_t + " штук.";
                    return ret;
                }else {
                    this.count_t= this.count_t-c;
                    ret = "Тавар выдан  в запрошенном объеме " + c +" штук. " +
                            " В наличие осталось: " + this.count_t + " штук.";
                    return ret;
                }
            }
        }
    }
}