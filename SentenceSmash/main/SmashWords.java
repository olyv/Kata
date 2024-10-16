import java.util.Arrays;
import java.util.Iterator;

public class SmashWords {

    //Example: ['hello', 'world', 'this', 'is', 'great']  =>  'hello world this is great'

    private static final String SPACE = " ";

    public static String smash(String... words) {
        var stringBuilder = new StringBuilder();
        Iterator<String> it = Arrays.stream(words).iterator();;
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(SPACE);
            }
        }
        return  stringBuilder.toString();
    }
}