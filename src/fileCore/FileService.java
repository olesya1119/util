package fileCore;

import java.util.ArrayList;

public interface FileService {

    ArrayList<String> readLinesFromFile(String fileName);

    void writeLinesToFile(String fileName, String path, ArrayList<String> lines, boolean append);
}
