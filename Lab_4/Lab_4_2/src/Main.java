/*
9. Создать класс Park (парк) с внутренним классом, с помощью объектов которого
 можно хранить информацию об аттракционах, времени их работы и стоимости.
 */

class Park {
    private String name;

    public class attrction{
        private String name, time, price;
        public void setInfo(String  name,String time,String price){
            this.name=name;
            this.time=time;
            this.price=price;
        }

        public void getInfo(){
            System.out.println(this.name +" "+
                            this.time+" "+
                            this.price+" ;");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}