package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExceptionLogger {
    // Название файла, куда будут сохраняться ошибки
    private static final String LOG_FILE = "exceptions_log.txt";

    public static void log(Exception e) {
        // Открываем файл в режиме дозаписи (true)
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(LocalDateTime.now() + " - " + e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (IOException ioException) {
            System.out.println("Критическая ошибка: Не удалось записать лог-файл!");
        }
    }
}