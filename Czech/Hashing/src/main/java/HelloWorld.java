import com.sun.deploy.util.ArrayUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.out;

/**
 * Created by mrnim on 26-Apr-16.
 */
public class HelloWorld {
    public static String[] getAllLists(String[] elements, int lengthOfList)
    {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements;
        else
        {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1);

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.length; i++)
            {
                for(int j = 0; j < allSublists.length; j++)
                {
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }

            return allLists;
        }
    }

    public static String[] getAlphabet(){
        String[] alphabet = new String['Z' - 'A' + 1];

        for (int i = 'A'; i <= 'Z' ; i++) {
            alphabet[i - 'A'] = String.valueOf((char)i);
        }

        return alphabet;
    }

    public static int getValue(byte[] bytes, int base){
        int number = 0;

        for (int i = bytes.length - 1; i >= 0; i--) {
            number += Math.pow(base, i) * bytes[bytes.length - i - 1];
        }

        return number;
    }

    public static int getValueShift(byte[] bytes, int base){
        int number = 0;
        number = bytes[0];
        number <<= 8;
        number += bytes[1];
        number <<= 8;
        number += bytes[2];
        number <<= 8;
        number += bytes[3];

        return number;
    }

    @FunctionalInterface
    public interface FunctionHash<One, Two, Return>{
        public Return apply(One one, Two two);
    }

    @FunctionalInterface
    public interface FunctionValue<One, Return>{
        public Return apply(One one);
    }

    public static void invokeAndSaveToFile(String fileName,FunctionValue<byte[], Integer> value, FunctionHash<Integer, Integer, Integer> hash, int n, int a){
        int[] x = new int[a];
        for (int i = 0; i < a; i++) {
            x[i] = i;
        }

        int[] y = new int[a];

        String[] allLists = getAllLists(getAlphabet(), n);

        Arrays.stream(allLists).forEach((el)->{
            byte[] xBytes = el.getBytes();
            int xValue = value.apply(xBytes);
            y[hash.apply(xValue, a)]++;
        });

        try {
            Method1.saveToFile(fileName, x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        int N = 4;
        int A = 100;

        //2
        invokeAndSaveToFile("AlphabetCeil.csv", bytes -> getValue(bytes, 10), (n,a) -> Method1.getHashCeilIndex(n,a), N, A);
        invokeAndSaveToFile("AlphabetFloor.csv", bytes -> getValue(bytes, 10), (n,a) -> Method1.getHashFloorIndex(n,a), N, A);
        invokeAndSaveToFile("AlphabetCzech.csv", bytes -> getValue(bytes, 10), (n,a) -> Method1.getHashIndexCzech(n,a), N, A);

        //3
        invokeAndSaveToFile("AlphabetCeilShift.csv", bytes -> getValueShift(bytes, 10), (n,a) -> Method1.getHashCeilIndex(n,a), N, A);
        invokeAndSaveToFile("AlphabetFloorShift.csv", bytes -> getValueShift(bytes, 10), (n,a) -> Method1.getHashFloorIndex(n,a), N, A);
        invokeAndSaveToFile("AlphabetCzechShift.csv", bytes -> getValueShift(bytes, 10), (n,a) -> Method1.getHashIndexCzech(n,a), N, A);

        //4
        invokeAndSaveToFile("AlphabetCzechXor.csv", bytes -> getValue(bytes, 10), (n,a) -> Method1.getHashIndexCzechBit(n,a), N, A);
        invokeAndSaveToFile("AlphabetCzechShiftXor.csv", bytes -> getValueShift(bytes, 10), (n,a) -> Method1.getHashIndexCzechBit(n,a), N, A);

        //5
        invokeAndSaveToFile("9.csv", bytes -> getValue(bytes, 9), (n,a) -> Method1.getHashIndexCzech(n,a), N, A);
        invokeAndSaveToFile("6.csv", bytes -> getValue(bytes, 6), (n,a) -> Method1.getHashIndexCzech(n,a), N, A);
        invokeAndSaveToFile("7.csv", bytes -> getValue(bytes, 7), (n,a) -> Method1.getHashIndexCzech(n,a), N, A);
    }
}
