package com.company;

import com.company.encription.EncryptionService;
import com.company.encription.RusConverter;
import com.company.encription.XOREncryption;

import java.util.Scanner;
/**
 * Класс для тестирования шифрования через консоль.
 * @author Андрей Нагорный
 */
public class Main {
    /**
     * Отображает в консоли меню с опциями: задания ключей, шифрования и дешифрования.
     */
    public static void showMenu(){
        System.out.println("----------------------------------");
        System.out.println("(1) Задать числовой ключ");
        System.out.println("(2) Задать строковый ключ");
        System.out.println("(3) Зашифровать строку");
        System.out.println("(4) Расшифровать строку");
        System.out.println("(5) Выйти");
        System.out.println("----------------------------------");
        System.out.print("Ввод:");
    }

    /**
     * Внутри точки входа задаются конвертер и кодировщик, которые будут использоваться. Затем управление передается
     * пользователю. Пользователь может задавать ключи для шифрования, шифровать и дешифровать сообщения.
     * @param args
     */
    public static void main(String[] args) {
      //  В зависимости от передоваемого класса меняется метод шифровки
        EncryptionService encryptionService = new EncryptionService(new XOREncryption(new RusConverter()),new RusConverter());
        Scanner scanner = new Scanner(System.in);
        int glChoice = 0;
        while (glChoice!=5) {
            showMenu();
            glChoice = scanner.nextInt();
            scanner.nextLine();
            int choice;
            String result;
            switch (glChoice) {
                case 1:
                    System.out.print("Введите любое число от 0 до 31:");
                    int numKey = scanner.nextInt();//Ключ от 0 до 31
                    scanner.nextLine();
                    encryptionService.setNumKey(numKey);
                    break;
                case 2:
                    System.out.print("Введите любое слово без пробелов:");
                    String strKey = scanner.nextLine(); //Любое слово без пробелов
                    encryptionService.setStrKey(strKey);
                    break;
                case 3:
                    System.out.print("Введите сообщение для шифровки:");
                    String message = scanner.nextLine();
                    System.out.println("Как зашифровать:");
                    System.out.println("(1) Числом");
                    System.out.println("(2) Строкой");
                    System.out.print("Ввод:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) result = encryptionService.encryptMessageWithNumKey(message);
                    else result = encryptionService.encryptMessageWithStrKey(message);
                    System.out.println("Ваш результат:" + result);
                    break;
                case 4:
                    System.out.print("Введите сообщение для расшифровки:");
                    String message1 = scanner.nextLine();
                    System.out.println("Как зашифровать:");
                    System.out.println("(1) Числом");
                    System.out.println("(2) Строкой");
                    System.out.print("Ввод:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) result = encryptionService.deEncryptMessageWithNumKey(message1);
                    else result = encryptionService.deEncryptMessageWithStrKey(message1);
                    System.out.println("Ваш результат:" + result);
                    break;
                default:
                    break;
            }
        }
    }
}
