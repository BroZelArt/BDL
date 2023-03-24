/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании.
Аргументировать принадлежность классу каждого создаваемого метода и корректно
 переопределить для каждого класса методы equals(), hashCode(), toString().

 8. Создать объект класса Пианино, используя класс Клавиша. Методы: настроить, играть на пианино, нажимать клавишу.
 */

import java.text.DecimalFormat;
import java.util.*;

import java.util.Scanner;

class Key {
    int keyNom;
    public Key(){}
    public Key(int n){
        this.keyNom=n;
    }

    @Override
    public String toString() {
        return "Key{" +
                "keyNom=" + keyNom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return keyNom == key.keyNom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyNom);
    }
}
class Piano extends Key{
    Key[] keys;
    int noms;
    public Piano(){}
    public void Setup (int noms){
        if (noms>0) {
            this.keys=new Key[noms];
            this.noms=noms;
            for (int i = 0; i < noms; i++) {

                this.keys[i]=new Key(i+1);}

                System.out.println("Пианино настроен как " + noms + " клавишный!");
            }
        else {System.out.println("Пианино невохможно настроить!");}
    }

    public void playPiano (int[] key){
        for (int i=0;i<key.length;i++){
           if ((key[i]<=this.noms+1)&(key[i]>0)){
               System.out.print("Играет "+ key[i]+ " клавиша; ");
           } else System.out.print("Промах; ");
            System.out.println();
        }
    }

    public void playKey (int key){

            if ((key<=this.noms+1)&(key>0)) {
            System.out.println("Зажата " + key + " клавиша; ");
        }  else{ System.out.print("Нет такой клавиши; ");}
            System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Piano piano = (Piano) o;
        return noms == piano.noms && Arrays.equals(keys, piano.keys);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), noms);
        result = 31 * result + Arrays.hashCode(keys);
        return result;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "keys=" + Arrays.toString(keys) +
                ", noms=" + noms +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("A) Введите число клавиш: ");
       int n = input.nextInt();
       Piano piano=new Piano();
       piano.Setup(n);
        System.out.print("A) Введите длину мелодии: ");
        n = input.nextInt();
        System.out.print("B) Введите последовательность клавиш: ");
        int[] n1 = new int[n];
        for (int i=0;i<n;i++){
            n1[i]=input.nextInt();}
        piano.playPiano(n1);
        System.out.print("В) Введите клавишу для нажатия: ");
        n = input.nextInt();
        piano.playKey(n);
    }
}