package statistics;

import java.util.ArrayList;

public class IntegerStatistics implements Statistics {
    private long min, max, sum, count;

    @Override
    public void addValue(String value) {
        long intValue = Long.parseLong(value);
        if (count == 0){
            min = intValue;
            max = intValue;
        }
        else {
            if (intValue > max) max = intValue;
            if (intValue < min) min = intValue;
        }
        sum += intValue;
        count++;
    }

    @Override
    public String getFullStatistics() {
        if (count != 0)
        return "Количество целых чисел: " + count + "\nМинимальное значение: " + min + "\nМаксимальное значение: " + max +
                "\nСумма значений: " + sum + "\nСреднее значение: " + String.format("%.3f",(double)sum / count) + "\n";
        else
            return "Количество целых чисел: 0\nМинимальное значение: 0\nМаксимальное значение: 0\nСумма значений: 0\nСреднее значение: 0\n";
    }

    @Override
    public String getShortStatistics() {
        return "Количество целых чисел: " + count + "\n";
    }
}
