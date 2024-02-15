package VirtualDictionary;

public class DictionaryController {
    static Dictionary dictionary = new Dictionary();
    private DictionaryView gui;

    public DictionaryController(DictionaryView gui) {
        this.gui = gui;
    }
    public String dictionarySearch(String word) {
        if (word == null) {
            return "Type field is empty";
        }
        String meaning = dictionary.searchMeaning(word);
        if (meaning == null) {
            return "Word not found from dictionary, perhaps you should add it.";
        }
        return meaning;
    }

    public String dictionaryAdd(String word, String meaning) {
            if (word.length() == 0 || meaning.length() == 0) {
                return "Field is empty";
            }else {
            dictionary.addWord(word, meaning);
            return "Word added to dictionary";
            }
    }

    public static void main(String[] args) {
        dictionary.addWord("clock", "Shows time, can be analog or digital.");
        dictionary.addWord("mouse", "Small rodent, that likes cheese.");
        DictionaryView.launch(DictionaryView.class);

    }

}
