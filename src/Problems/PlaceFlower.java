package Problems;

/**
 * Created by shuhanliu on 10/20/18.
 */
public class PlaceFlower {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1};
        int n = 1;

        System.out.println(canPlaceFlower(arr, n));

    }

    public static boolean canPlaceFlower(int[] flowerbed, int n) {

        int result = 0;
        int count = 1;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count += 1;
            } else {
                result += (count - 1) / 2;
                count = 0;
            }
        }

        if (count > 0)
            result += count/2;

        return result >= count;
    }
}
