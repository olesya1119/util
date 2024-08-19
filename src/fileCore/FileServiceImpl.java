package fileCore;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileServiceImpl implements FileService {

    /**Чтение из файла. Возвращает список прочитанных строк.*/
    @Override
    public ArrayList<String> readLinesFromFile(String fileName) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        FileReader reader;

        try {
            reader = new FileReader(fileName);
            int c, k = 0;
            while((c=reader.read())!=-1){
                if (!String.valueOf((char) c).matches(".")){ //Если символ -  перевод строки
                    k++;
                    arrayList.add("");
                    continue;
                }
                arrayList.set(k, arrayList.get(k) + (char) c);
            }
        } catch (IOException e ) {
            throw new RuntimeException("Файл по пути " + System.getProperty("user.dir") + "\\" + fileName + " не найден.");
        }
        return arrayList;
    }

    /**Запись в файл.*/
    @Override
    public void writeLinesToFile(String fileName, String path, ArrayList<String> lines, boolean append) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < lines.size(); i++)
            data.append(lines.get(i)).append("\r");

        try {
            FileOutputStream fos = new FileOutputStream(path + fileName, append);
            fos.write(data.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
            throw new RuntimeException("Директория " + path + " не найдена.");
        }
    }
}
