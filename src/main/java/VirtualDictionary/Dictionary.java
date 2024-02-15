package VirtualDictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> dictionary = new HashMap<>();

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String searchMeaning(String word) {
        return dictionary.get(word.toLowerCase());
    }
}
