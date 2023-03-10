import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileWorker {
    private static  Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void write(String path, T data){
        try(FileWriter fw = new FileWriter(path)){
            String jsonStr = gson.toJson(data);
            fw.append(jsonStr);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static <T> T read(String path, Class<T> obj){
        File file = new File(path);
        if(!file.exists()) {
            try {
            file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        String jsonStr;
        StringBuilder SB = new StringBuilder();
        try(FileReader fr = new FileReader(path)){
            int ch;
            while((ch = fr.read()) != -1){
                SB.append((char) ch);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        jsonStr = SB.toString();
        return gson.fromJson(jsonStr, obj);
    }
}
