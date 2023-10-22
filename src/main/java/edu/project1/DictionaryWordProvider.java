package edu.project1;

class DictionaryWordProvider implements WordProvider {
    private static final String[] dictionary = {"okay", "hello", "goodbye", "thanks", "nope", "yeah"};

    @Override
    public char[] selectRandomWord() {
        return dictionary[(int) (Math.random() * dictionary.length)].toCharArray();
    }
}
