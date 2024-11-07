import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileDict {
    private File src;
    private File dest;
    private Dict dict;

    public FileDict(String nameOfSrc, String nameOfDest){
        this.src = new File(nameOfSrc);
        this.dest = new File(nameOfDest);
        this.dict = new Dict();
    }
    public FileDict(String nameOfSrc){
        this(nameOfSrc, null);
    }
    public FileDict(){
        this(null, null);
    }

    public void readFileToDict() throws Exception{
        if(!(this.src.exists() && this.src.isFile())) throw new FileNotFoundException("This file does not exist!");
        else if (!this.src.canRead()) throw new Exception("This file is not readable!");
        else{
            Scanner scanner = new Scanner(this.src);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                char[] dataArr = data.toCharArray();
                for (char c : dataArr) {
                    this.dict.incValue(Character.toString(c));
                }
            }
            scanner.close();
        }
    }
    public void writeDictToFile() throws Exception{
        if(!(this.dest.exists() && this.dest.isFile())) throw new FileNotFoundException("This file does not exist!");
        else if (!this.dest.canWrite()) throw new Exception("This file is not writable!");
        else{
            boolean isAppend = (this.dest==this.src);
            FileWriter writer = new FileWriter(this.dest,isAppend);
            writer.write(this.dict.getDictAString());
            writer.close();
        }
    }
}
