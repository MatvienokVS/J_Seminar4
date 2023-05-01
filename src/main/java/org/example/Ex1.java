package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;


public class Ex1 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        // Записываем строку в файл
        String text = "Hello, world!";
        FileWriter writer = new FileWriter("test.txt");
        writer.write(text);
        writer.close();

        // Читаем строку из файла и выводим ее в консоль
        FileReader reader = new FileReader("test.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Читаем данные из файла db.sql и разбиваем по строкам
        reader = new FileReader("db.sql");
        bufferedReader = new BufferedReader(reader);
        while ((line = bufferedReader.readLine()) != null) {
            String[] sb = line.split(" ");
            family.add(sb[0] + " ");
            name.add(sb[1].substring(0, 1) + ".");
            soname.add(sb[2].substring(0, 1) + "." + " ");
            age.add(Integer.valueOf(sb[3]));
            gender.add(sb[4].equals("M"));
            index.add(index.size());
        }
        reader.close();

        // Сортируем по возрасту, используя дополнительный список индексов
        index.sort(Comparator.comparingInt(age::get));

        // Выводим данные в формате "Иванов И.И. 32 М"
        for (int i : index) {
            System.out.printf("%s%s%s%d %s%n", family.get(i), name.get(i), soname.get(i), age.get(i),
                    gender.get(i) ? "М" : "Ж");
        }
    }
}