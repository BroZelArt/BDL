/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании.
Аргументировать принадлежность классу каждого создаваемого метода и корректно
 переопределить для каждого класса методы equals(), hashCode(), toString().

 8. Создать объект класса Пианино, используя класс Клавиша. Методы: настроить, играть на пианино, нажимать клавишу.
 */

import java.util.*;

import java.util.Scanner;

class Photo {
    String photo;
    public Photo(){}
    public Photo(String n){
        this.photo=n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo photo1)) return false;
        return photo == photo1.photo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photo=" + photo +
                '}';
    }
}
class PhotoAlbom extends Photo{
    ArrayList<Photo> photos=new ArrayList<Photo>();
    public PhotoAlbom(){}
    public void setName (String photo,int n) {
        if (this.photos.size() < n) {
            for (int i = photos.size() ; i < n -1; i++) {
                this.photos.add(new Photo("Zero photo"));
            }
            this.photos.add(n - 1, new Photo(photo));
        }
    }

    public void addPhoto (String photo){
        this.photos.add(new Photo(photo));
    }

    public int getCount (){
        return this.photos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoAlbom that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), photos);
    }

    @Override
    public String toString() {
        return "PhotoAlbom{" +
                "photos=" + photos +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("A) Введите название фотографии и её номер: ");
        String s= input.nextLine();
        int n = input.nextInt();
        PhotoAlbom photoAlbom=new PhotoAlbom();
        photoAlbom.setName(s, n);
        System.out.println("Б) Введите название для добавления: ");
        s= input.nextLine();
        s= input.nextLine();
        photoAlbom.addPhoto(s);
        System.out.println("B) Всего " + photoAlbom.getCount() +" фото в альбоме ");
        System.out.println("В) Все фото:"+ photoAlbom.toString());
    }
}