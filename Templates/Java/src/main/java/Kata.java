import java.util.*;

public class Kata {
    public int[] bitSort(int[] numbers) {
        int[] sortedNums = new int[numbers.length];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>() {};

        for (int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];
            int bitsCount = bitCounter(number);

            if (!map.containsKey(bitsCount)){
                map.put(bitsCount, new ArrayList<>());
            }

            ArrayList<Integer> item = map.getOrDefault(bitsCount, new ArrayList<>());
            item.add(number);
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (int bitSet = 0; bitSet < 32; bitSet++) {
            if (map.containsKey(bitSet)) {
                ArrayList<Integer> originalNumbers = map.get(bitSet);
                Collections.sort(originalNumbers);
                System.out.println(originalNumbers);
                results.addAll(originalNumbers);
            }

        }
        return listToArray(results);
    }

    public int[] listToArray(ArrayList<Integer> input) {
        int[] results = new int[input.toArray().length];
        for (int index = 0; index < input.toArray().length; index++) {
            results[index] = input.get(index);
        }
        return results;
    }

    public int bitCounter(int value) {
        int bitCounter = 0;
        String numToBits = Integer.toBinaryString(value);

        for (int index = 0; index < numToBits.length(); index++) {
            if (numToBits.charAt(index) == '1') {
                bitCounter++;
            }
        }
        return bitCounter;
    }


//
//    Initialize count: = 0
//    If integer n is not zero
//            (a) Do bitwise & with (n-1)
//    and assign the value
//    back to n
//    n: = n&(n-1)
//            (b) Increment count by 1
//            (c) go to step 2
//    Else return count
}
