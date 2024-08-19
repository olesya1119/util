import java.util.ArrayList;
/**
 * Хранит кофигурацию запроса
 */
public class Config {
    /** Опция -a. Режим добавления в существующие файлы. */
    private boolean optionA;

    /** Опция -s. Вывод краткой статистики. */
    private boolean optionS;
    /** Опция -f. Вывод полной статистики. */
    private boolean optionF;

    /** Опция -o. Задание пути для результатов. */
    private boolean optionO;
    /** Путь для результатов. */
    private String path;

    /** Опция -p. Задание префикса для выходных файлов. */
    private boolean optionP;
    /** Префикс для выходных файлов. */
    private String prefix;

    /** Имена входных файлов */
    private ArrayList<String> filesName;

    public Config(boolean optionA, boolean optionS, boolean optionF, boolean optionO, String path, boolean optionP, String prefix, ArrayList<String> filesName) {
        this.optionA = optionA;
        this.optionS = optionS;
        this.optionF = optionF;
        this.optionO = optionO;
        this.path = path;
        this.optionP = optionP;
        this.prefix = prefix;
        this.filesName = filesName;
    }

    public Config() {
        optionA = false;
        optionS = false;
        optionF = false;
        optionO = false;
        path = "";
        optionP = false;
        prefix = "";
        filesName = new ArrayList<String>();
    }

    /** Проверка на валидность введной конфигурации. Если проверка не пройдена - выкинет исключение.*/
    public void isValid(){
        if (optionF && optionS) throw new RuntimeException("Нельзя использовать параметры -s и -f одновременно.");
    }

    public void AddFileName(String fileName){
        filesName.add(fileName);
    }

    public void setOptionA(boolean optionA) {
        this.optionA = optionA;
    }

    public void setOptionF(boolean optionF) {
        this.optionF = optionF;
        isValid();
    }

    public void setOptionS(boolean optionS) {
        this.optionS = optionS;
        isValid();
    }

    public void setOptionO(boolean optionO) {
        this.optionO = optionO;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setOptionP(boolean optionP) {
        this.optionP = optionP;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setFilesName(ArrayList<String> filesName) {
        this.filesName = filesName;
    }

    public boolean getOptionA() {
        return optionA;
    }

    public boolean getOptionS() {
        return optionS;
    }

    public boolean getOptionF() {
        return optionF;
    }

    public boolean getOptionO() {
        return optionO;
    }

    public String getPath() {
        return path;
    }

    public boolean getOptionP() {
        return optionP;
    }

    public String getPrefix() {
        return prefix;
    }

    public ArrayList<String> getFilesName() {
        return filesName;
    }
}
