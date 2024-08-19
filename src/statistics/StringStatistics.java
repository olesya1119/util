package statistics;

import java.util.ArrayList;

public class StringStatistics implements Statistics {
    int count, min, max;

    @Override
    public void addValue(String value) {
        int len = value.length();
        if (count == 0){
            min = len;
            max = len;
        }
        else {
            if (len > max) max = len;
            if (len < min) min = len;
        }
        count++;
    }

    @Override
    public String getFullStatistics() {
        return "Количество строковых элементов: " + count + "\nРазмер самой короткой строки: " + min + "\nРазмер самой длинной строки: " + max+ "\n";
    }

    @Override
    public String getShortStatistics() {
        return "Количество строковых элементов: " + count + "\n";
    }
}
