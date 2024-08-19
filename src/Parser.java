/**
 * Класс парсер. Формирует класс конфигурации
 * */
public class Parser {
    String[] args;

    public Parser(String[] args) {
        this.args = args;
    }

    /**
     * Генерация экземпляра класса конфигурации
     * */

    public Config GenerateConfig() {
        Config config =  new Config();

        for (int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-a":
                    config .setOptionA(true);
                    break;
                case "-f":
                    config .setOptionF(true);
                    break;
                case "-s":
                    config .setOptionS(true);
                    break;
                case "-o":
                    config .setOptionO(true);
                    config .setPath(args[i+1]);
                    i++;
                    break;
                case "-p":
                    config .setOptionF(true);
                    config .setPrefix(args[i+1]);
                    i++;
                    break;
                default:
                    //Остальное либо названия файлов либо неверные аргументы
                    if (!args[i].endsWith(".txt")) throw new RuntimeException("Неизвестный аргумент: " + args[i]);
                    config.AddFileName(args[i]);
                    break;
            }
        }
        return config;
    }


}
