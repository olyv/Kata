import java.util.ArrayList;

class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {

        int passengersCount = 0;

        for (int[] stop : stops) {
            passengersCount += stop[0];
            passengersCount -= stop[1];
        }
        return passengersCount;

    }
}