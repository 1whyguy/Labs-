package lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        // Укажи здесь пути к реальным файлам, если они есть.
        // Сейчас программа выдаст ошибку, так как source.txt не существует — это и есть проверка исключения!
        String sourceFile = "source.txt";
        String destFile = "dest.txt";

        // try-with-resources сам закроет потоки
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int length;

            // Читаем из одного и пишем в другой
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка доступа: Файл не найден или нет прав на запись. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: Проблема при чтении или записи файла. " + e.getMessage());
        }
    }
}