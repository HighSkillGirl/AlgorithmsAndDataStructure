package high.skill.girl.prepare.interview.algorithms.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterestingJourneyYandex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] cityArray = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] coordinates = reader.readLine().split(" ");
            cityArray[i] = new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};
        }

        int k = Integer.parseInt(reader.readLine());
        String[] pointers = reader.readLine().split(" ");

        int count = 0;

        int x1 = cityArray[Integer.parseInt(pointers[0]) - 1][0];
        int x2 = cityArray[Integer.parseInt(pointers[1]) -1][0];
        int y1 = cityArray[Integer.parseInt(pointers[0]) - 1][1];
        int y2 = cityArray[Integer.parseInt(pointers[1]) -1][1];
        int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        if (dist > 0 && dist <= k) count++;

        System.out.println(count);
    }
}
