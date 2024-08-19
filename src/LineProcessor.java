import fileCore.FileService;
import fileCore.FileServiceImpl;
import statistics.FloatStatistics;
import statistics.IntegerStatistics;
import statistics.Statistics;
import statistics.StringStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum Type {Int, Float, String}

public class LineProcessor {

    private Map<Type, Statistics> stats;
    private Map<Type, ArrayList<String>> data;
    private Map<Type, String> filesName;


    private FileService fileService;
    private Config config;

    public LineProcessor(Config config){
        this.config = config;
        fileService = new FileServiceImpl();

        stats = new HashMap<>();
        stats.put(Type.Int, new IntegerStatistics());
        stats.put(Type.Float, new FloatStatistics());
        stats.put(Type.String, new StringStatistics());

        data = new HashMap<>();
        data.put(Type.Int, new ArrayList<String>());
        data.put(Type.Float, new ArrayList<String>());
        data.put(Type.String, new ArrayList<String>());

        filesName = new HashMap<>();
        filesName.put(Type.Int, config.getPrefix() + "integers.txt");
        filesName.put(Type.Float, config.getPrefix() + "floats.txt");
        filesName.put(Type.String, config.getPrefix() + "strings.txt");

        readFiles();
        writeInFiles();
    }

    public String getStatistics(){
        String result = "";
        if (!config.getOptionF() && config.getOptionS()){
            for (Type t: stats.keySet()){
                result += "\n" + stats.get(t).getShortStatistics();
            }
        }

        if (config.getOptionF() && !config.getOptionS()){
            for (Type t: stats.keySet()){
                result += "\n" + stats.get(t).getFullStatistics();
            }
        }

        return result;
    }


    private void readFiles(){
        ArrayList<String> values;
        for (int i = 0; i < config.getFilesName().size(); i++) {
            values = fileService.readLinesFromFile(config.getFilesName().get(i));

            for (int j = 0; j < values.size(); j++) {
                stats.get(getType(values.get(j))).addValue(values.get(j)); //Обновляем статистику
                data.get(getType(values.get(j))).add(values.get(j)); //Добавляем в список новые элементы
            }
        }
    }

    private void writeInFiles(){
        for (Type t: data.keySet()){
            if (!data.get(t).isEmpty()) {
                fileService.writeLinesToFile(filesName.get(t), config.getPath(), data.get(t), config.getOptionA());
            }
        }

    }

    private Type getType(String value){
        try {
            Long.parseLong(value);
            return Type.Int;
        }
        catch (NumberFormatException _){}

        try{
            Float.parseFloat(value);
            return Type.Float;}
        catch (NumberFormatException e){
            return Type.String;
        }

    }
}
