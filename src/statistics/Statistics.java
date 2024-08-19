package statistics;

/**
 *  Определяет методы для работы со статистикой
 * */
public interface Statistics {

    void addValue(String value);

    String getFullStatistics();

    String getShortStatistics();
}
