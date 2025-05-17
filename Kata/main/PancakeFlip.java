import java.util.ArrayList;
import java.util.List;

public class PancakeFlip {

    private static List<Integer> indexes = new ArrayList<>();
    private static int flipsCounter = 0;

    public static List<Integer> flipPancakes(List<Integer> stack) {
        System.out.println("stack " + stack);

        if(isStackSorted(stack)) {
            return indexes;
        } else {
            List<Integer> unsortedHead = getSubList(stack, 0, stack.size() - flipsCounter);
            List<Integer> sortedTail = getSubList(stack, stack.size() - flipsCounter, stack.size());

            int maxElementInUnsortedHead = getMaxElement(unsortedHead);
            int indexOfMaxElementInUnsortedHead = indexOfElement(unsortedHead, maxElementInUnsortedHead);

            List<Integer> fromStartToMaxElementOfUnsortedHead = getSubList(unsortedHead, 0, indexOfMaxElementInUnsortedHead + 1);
            List<Integer> fromMaxToEndOfUnsortedHead = getSubList(unsortedHead, indexOfMaxElementInUnsortedHead + 1, unsortedHead.size());

            List<Integer> subListOfHeadWithMaxElementAtStart = reverse(fromStartToMaxElementOfUnsortedHead);

            List<Integer> wholeHeadWithMaxAtStart = concatLists(subListOfHeadWithMaxElementAtStart, fromMaxToEndOfUnsortedHead);

            List<Integer> sortedHead = reverse(wholeHeadWithMaxAtStart);

            stack = concatLists(sortedHead, sortedTail);

            //increment counter of flips
            flipsCounter++;

            System.out.println("stack after " + flipsCounter + " iteration: " + stack);

            flipPancakes(stack);
        }
        return indexes;
    }

    private static int getMaxElement(List<Integer> list) {
        return list.stream().max(Integer::compareTo).get();
    }

    private static int indexOfElement(List<Integer> list, int element) {
        return list.lastIndexOf(element);
    }

    private static List<Integer> reverse(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);
        List<Integer> reversedList = newList.reversed();
        return reversedList;
    }

    private static List<Integer> getSubList(List<Integer> list, int startIndexInclusive, int endIndexExclusive) {
        return list.subList(startIndexInclusive, endIndexExclusive);
    }

    private static List<Integer> concatLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    private static boolean isStackSorted(List<Integer> stack) {
        List<Integer> sortedStack = stack.stream().sorted().toList();
        return stack.equals(sortedStack);
    }
}
