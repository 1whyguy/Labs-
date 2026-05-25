package lab4;

public class Srarifm {
    public static void main(String[] args) {
        // Массив строк, чтобы смоделировать ошибку неверного формата числа
        String[] arr = {"10", "20", "30", "ошибка", "50"};
        int sum = 0;
        int count = 0;

        try {
            // В условии i <= arr.length специально заложена ошибка выхода за пределы
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]); // Пытаемся превратить строку в число
                count++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата: Один из элементов не является числом. " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка границ: Выход за пределы массива. " + e.getMessage());
        }

        // Выводим среднее арифметическое элементов, которые успели посчитаться до ошибки
        if (count > 0) {
            System.out.println("Среднее арифметическое (до ошибки): " + ((double) sum / count));
        }
    }
}