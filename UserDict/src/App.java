import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String nameSrc = scan.nextLine();
        String nameDest = scan.nextLine();
        scan.close();
        try {
            FileDict fileDict = new FileDict(nameSrc,nameDest);
            fileDict.readFileToDict();
            fileDict.writeDictToFile();
            
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
