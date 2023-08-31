package binarytree;
//Задание: бинарное дерево с балансировкой, добавление, удалением элементов

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // С помощью дебагера проверяем балансируется ли дерево, добавляются ли правильно элементы
    // Для этого вводим с клавиатуры цифры и отслеживаем в дебагере текущий состав дерева
    public static void main(String[] args) {
        final BinaryTree binaryTree01 = new BinaryTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    binaryTree01.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//        Проверка дерева на добавление и удаление элементов
//        BinaryTree binaryTree01 = new BinaryTree();
//        binaryTree01.add(7);
//        binaryTree01.add(8);
//        binaryTree01.add(5);
//        binaryTree01.add(15);
//        binaryTree01.add(20);
//        System.out.println(binaryTree01.containsNode(7));
//        binaryTree01.delete(7);
//        System.out.println(binaryTree01.containsNode(7));


