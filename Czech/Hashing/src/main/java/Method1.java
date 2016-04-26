import java.io.*;

/**
 * Created by mrnim on 26-Apr-16.
 */
public class Method1 {

    @FunctionalInterface
    public interface Function<One, Two, Return>{
        public Return apply(One one, Two two);
    }

    public static void invokeAndSaveToFile(String fileName, Function<Integer, Integer, Integer> function, int n, int a){
        int[] x = new int[a];
        for (int i = 0; i < a; i++) {
            x[i] = i;
        }

        int[] y = new int[a];

        for(int i = 0; i < n; i++){
            y[function.apply(i, a)]++;
        }

        try {
            saveToFile(fileName, x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHashCeilIndex(int number, int a){
        int square = number * number;

        int digitsSquare = getAmountOfDigits(square);
        int digitsA = getAmountOfDigits(a - 1);

        int leftShift = (int)Math.ceil(Math.max(0,(double)(digitsSquare - digitsA) / 2));

        String sqrStr = String.valueOf(square);
        return Integer.parseInt(sqrStr.substring(leftShift, Math.min(leftShift + digitsA, sqrStr.length())));
    }

    public static int getHashFloorIndex(int number, int a){
        int square = number * number;

        int digitsSquare = getAmountOfDigits(square);
        int digitsA = getAmountOfDigits(a - 1);

        int leftShift = (int)Math.floor(Math.max(0,(double)(digitsSquare - digitsA) / 2));

        String sqrStr = String.valueOf(square);
        return Integer.parseInt(sqrStr.substring(leftShift, Math.min(leftShift + digitsA, sqrStr.length())));
    }

    public static int getHashIndexCzech(int number, int a){
        int square = number + (number << 1) + (number << 2) + (number << 3) + (number << 4);

        int digitsSquare = getAmountOfDigits(square);
        int digitsA = getAmountOfDigits(a - 1);

        int leftShift = (int)Math.floor(Math.max(0,(double)(digitsSquare - digitsA) / 2));

        String sqrStr = String.valueOf(square);
        return Integer.parseInt(sqrStr.substring(leftShift, Math.min(leftShift + digitsA, sqrStr.length())));
    }

    public static int getHashIndexCzechBit(int number, int a){
        int square = number ^ (number << 1) ^ (number << 2) ^ (number << 3) ^ (number << 4);

        int digitsSquare = getAmountOfDigits(square);
        int digitsA = getAmountOfDigits(a - 1);

        int leftShift = (int)Math.floor(Math.max(0,(double)(digitsSquare - digitsA) / 2));

        String sqrStr = String.valueOf(square);
        return Integer.parseInt(sqrStr.substring(leftShift, Math.min(leftShift + digitsA, sqrStr.length())));
    }

    public static int getAmountOfDigits(int number){
        int max = 0;
        while(number != 0){
            max++;
            number /= 10;
        }

        return max;
    }

    public static void saveToFile(String fileName, int[] x, int[] y) throws IOException {
        FileWriter out = new FileWriter(fileName);

        out.write(String.format("x,y\n"));
        for (int i = 0; i < x.length; i++) {
            out.write(String.format("%d,%d\n", x[i], y[i]));
        }

        out.close();
    }

    public static void main(String[] args){
        int N = 100000;
        int A = 100;

        invokeAndSaveToFile("ceil.csv", (n,a) -> getHashCeilIndex(n,a), N, A);
        invokeAndSaveToFile("floor.csv", (n,a) -> getHashFloorIndex(n,a), N, A);
        invokeAndSaveToFile("czech.csv", (n,a) -> getHashIndexCzech(n,a), N, A);
    }
}
