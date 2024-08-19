package statistics;

import java.util.ArrayList;

public class FloatStatistics implements Statistics {
    private float min, max, sum;
    private int count;

    @Override
    public void addValue(String value) {
        float floatValue = Float.parseFloat(value);
        if (count == 0){
            min = floatValue;
            max = floatValue;
        }
        else {
            if (floatValue > max) max = floatValue;
            if (floatValue < min) min = floatValue;
        }
        sum += floatValue;
        count++;
    }

    @Override
    public String getFullStatistics() {
        if (count != 0)
        return "Количество вещественных чисел: " + count + "\nМинимальное значение: " + min + "\nМаксимальное значение: " + max +
                "\nСумма значений: " + sum + "\nСреднее значение: " + String.format("%.3f",sum / count) + "\n";
        else
            return "Количество вещественных чисел: 0\nМинимальное значение: 0\nМаксимальное значение: 0\nСумма значений: 0\nСреднее значение: 0\n";
    }

    @Override
    public String getShortStatistics() {
        return "Количество вещественных чисел: " + count + "\n";
    }
}
