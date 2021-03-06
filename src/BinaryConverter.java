import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryConverter {

    public static Integer exp(int z, int x){

        int output = z;

        if (x == 0) {
            output = 1;
        } else {
            for (int i = 0; i < x -1;i++){
                output = output * z;
            }
        }
        return output;
    }

    public static int[] fibonacci(int limit){

        int kMinusTwo;
        int kMinusOne = 0;
        int k = 1;
        int[] sequence = new int[limit];

        for (int i = 0; i < limit; i++){

            sequence[i] = k;
            kMinusTwo = kMinusOne;
            kMinusOne = k;
            k = kMinusOne + kMinusTwo;

        }

        return sequence;
    }

    public static Integer findLargestSquare(Integer num){

        int square = 2;
        int count = 0;

        if (num == 1){
            return 0;
        } else {

            while (square <= num) {

                square = square * 2;
                count++;
            }
            return count;

        }
    }

    public static int convertToBinary(Integer decimal){

        int startLength = findLargestSquare(decimal);
        int[] nums = new int[startLength+1];

        int length = startLength;

        while (length > 0){

            int index = startLength - length;
            decimal = decimal - exp(2,length);
            length = findLargestSquare(decimal);
            nums[index] = 1;

        }

        if (decimal % 2 != 0){
            nums[startLength] = 1;
        }

        String stringBinary = "";

        for (int i = 0;i <nums.length;i++){
            stringBinary = stringBinary + nums[i];
        }

        return Integer.parseInt(stringBinary);

    }

    public static Integer convertToDecimal(Integer binary){

        List<String> Nums = new ArrayList<String>(Arrays.asList(binary.toString().split("")));
        Integer numLength = Nums.size()-1;
        Integer decimal = 0;

        int x = 0;

        for (String str: Nums){
            if (str.equals("1")) {
                int convertedInt = exp(2, numLength-x);
                decimal = decimal + convertedInt;
            }
            x++;
        }
        return decimal;
    }

    public static void main(String[] args) {

        for (int i : fibonacci(12)){
            System.out.println(convertToBinary(i));
        }

    }


}
