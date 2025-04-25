public class EqualSidesOfAnArray {

    public static int findEvenIndex(int[] arr) {
        var defaultResult = -1;

        if (arr.length == 0) {
            return 0;
        } else {

            int leftSideSum;
            int rightSideSum;

            for (int i = 0; i < arr.length - 1; i++) {

                leftSideSum = sumOfArraySlice(arr, 0, i - 1);
                rightSideSum = sumOfArraySlice(arr, i + 1, arr.length - 1);

                if (leftSideSum == rightSideSum) {
                    return i;
                }
            }
        }
        return defaultResult;
    }

    private static int sumOfArraySlice(int[] arr, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
