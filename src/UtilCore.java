/**
 * Ядро утилиты.
 * Этот класс инцилизируется методом main, и с него начинается работа утилиты.
 * Вызывает необходимые сервисы для обработки строк и записи результатов.
*/
public class UtilCore {


    public UtilCore(String[] args){
        //try {
            Parser parser = new Parser(args);
            Config config = parser.GenerateConfig();
            LineProcessor lineProcessor = new LineProcessor(config);
            System.out.print(lineProcessor.getStatistics());
        //}
        //catch (Throwable e){
            //System.out.print(e.getMessage());
       // }

    }
}
