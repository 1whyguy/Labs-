package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3Variant3 {
    public static void main(String[] args) {
        // Специально указываем несуществующий файл
        String filePath = "missing_document.txt";

        try {
            readFile(filePath);
        } catch (CustomFileNotFoundException e) {
            System.out.println("Перехвачено пользовательское исключение: " + e.getMessage());

            // Вызываем наш логгер, чтобы он записал ошибку в exceptions_log.txt
            ExceptionLogger.log(e);
            System.out.println(">>> Информация об ошибке успешно записана в лог-файл.");
        }
    }

    // Метод, который выбрасывает НАШЕ исключение (throws CustomFileNotFoundException)
    public static void readFile(String path) throws CustomFileNotFoundException {
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Если вылезла стандартная Java-ошибка, мы её ловим и бросаем свою
            throw new CustomFileNotFoundException("Моя ошибка: Файл '" + path + "' испарился или никогда не существовал!");
        }
    }
}