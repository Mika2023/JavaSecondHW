import java.util.HashMap;
import java.util.Map.Entry;

public class Dict {
    private HashMap<String, Integer> dict;

    public Dict(){
        this.dict = new HashMap<>();
        for (char letter = 'A'; letter<='Z';++letter) {
            this.dict.put(Character.toString(letter), 0);
        }
        for (char letter = 'a'; letter<='z';++letter) {
            this.dict.put(Character.toString(letter), 0);
        }
    }

    public void incValue(String key){
        if(this.dict.get(key)!=null) this.dict.put(key, this.dict.get(key)+1);
    }

    public String getDictAString(){
        String res = "";
        for (Entry<String, Integer> entry : this.dict.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            res+= "The letter \"" + key + "\" appears " + value + " times\n";
        }
        return res;
    }
}
