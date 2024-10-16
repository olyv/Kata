public class SmashWords {

    //Example: ['hello', 'world', 'this', 'is', 'great']  =>  'hello world this is great'

    public static String smash(String... words) {
        return String.join(" ", words);
    }
}