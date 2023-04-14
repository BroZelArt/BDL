/*
8 Задана строка, состоящая из символов '(', ')', '[', ']', '{', '}'.
Проверить правильность расстановки скобок. Использовать стек.
 */

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("А) Введите строку: ");
        StringBuilder s = new StringBuilder(input.nextLine());
        Stack<Character> stac = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '{') || (s.charAt(i) == '[') || (s.charAt(i) == '(')) {
                stac.add(s.charAt(i));
            }
            if ((s.charAt(i) == '}') || (s.charAt(i) == ']') || (s.charAt(i) == ')')) {
                if ((s.charAt(i) == '}') && (stac.peek() == '{')) stac.pop();
                if ((s.charAt(i) == ']') && (stac.peek() == '[')) stac.pop();
                if ((s.charAt(i) == ')') && (stac.peek() == '(')) stac.pop();
            }
        }
        if (stac.isEmpty()) System.out.print("Все скобки расставленный верно");
        else System.out.print("Скобки расставленный неверно");
    }
}