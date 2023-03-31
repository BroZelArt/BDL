/*
8. Создать класс Computer (компьютер) с внутренним классом, с помощью объектов которого
можно хранить информацию об операционной системе, процессоре и оперативной памяти.
 */


 class Computer {
  private int price;

    public class Info{
        private String os, proc, operat;
        public void setInfo(String os,String pr,String oper){
            this.os=os;
            this.proc=pr;
            this.operat=oper;
        }

        public void getInfo(){
            System.out.println(
            this.os +" "+
            this.proc+" "+
            this.operat+" ;");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}