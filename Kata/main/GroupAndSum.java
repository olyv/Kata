import java.util.*;
import java.util.function.BiFunction;

/*
Background

Often times when working with raw tabular data, a common goal is to split the data into groups and perform an aggregation as a way to simplify and draw meaningful conclusions from it. The aggregation function can be anything that reduces the data (sum,mean,standard deviation,etc.). For the purpose of this kata, it will always be the sum function.
Task

Define a function that accepts two arguments, the first being a list of list that represents the raw data, and the second being a list of column indices. The return value should be a dictionary with the key being the groups as a tuple and the values should be a list containing the aggregated sums.
Example

arr = [
  [1, 6, 2, 10],
  [8, 9, 4, 11],
  [9, 8, 7, 12],
  [1, 6, 3, 20],
]

idx = [0, 1]

group(arr, idx) == {
  (1, 6): [5, 30],      # [2 + 3, 10 + 20]
  (8, 9): [4, 11],
  (9, 8): [7, 12]
}

Explanation

    Columns 0 and 1 are used for grouping, so columns 2 and 3 will be aggregated
    Rows 0 and 3 are grouped together because they have the same values in columns idx, so the columns which are not a part of idx are aggregated
    Row 1 and 2 have different values in columns idx, so they are not grouped, and the aggregated results will simply be their own values in the columns which are not a part of idx

Notes

    all inputs are valid
    arguments will never be empty


 */
public class GroupAndSum {

    private static final BiFunction<? super List<Integer>, ? super List<Integer>, ? extends List<Integer>> mergeFunction = (firstList, secondList) -> {
        var result = new ArrayList<Integer>();
        for (int i = 0; i < firstList.size(); i++) {
            result.add(firstList.get(i) + secondList.get(i));
        }
        return result;
    };

    public static Map<List<Integer>, List<Integer>> groupAndSum(final int[][] data, final int[] indices) {
        var result = new HashMap<List<Integer>, List<Integer>>();
        for (int[] row : data) {
            List<Integer> key = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            var indicesList = Arrays.stream(indices).boxed().toList();
            for (int i = 0; i < row.length; i++) {
                if (indicesList.contains(i)) {
                    key.add(row[i]);
                } else {
                    value.add(row[i]);
                }
            }
            result.merge(key, value, mergeFunction);
        }
        return result;
    }
}
