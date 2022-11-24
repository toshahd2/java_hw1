import java.util.Arrays;
import java.util.Random;

public class hw1 {
    public static void main(String[] args){
        //Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = new Random().nextInt(-1000, 1001);
        System.out.println("Рандомное число в диапазоне -1000 до 1000 равно " + i);

        //Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = highestBit(i);
        System.out.println("Номер старшего бита: " + n);

        //Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = shortMaxValue(i, n);
        System.out.println("Кратные n числа:\n" + Arrays.toString(m1));

        //Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = shortMinValue(i, n);
        System.out.println("Некратные n числа:\n" + Arrays.toString(m2));
    }
    static int highestBit(int x) {
        if (x < 0) {
            x = -x;
        }
        int count = 0;
        while (x != 1) {
            x >>= 1;
            count++;
        }
        return count;
    }
    static int[] shortMaxValue(int i, int n) {
        int max = Short.MAX_VALUE;
        int length = max - i;
        int[] mTemp = new int[length];
        int count = 0;
        for (int j=i; j<(max+1); j++) {
            if (j % n == 0) {
                mTemp[count] = j;
                count++;
            }
        }
        int[] m1 = Arrays.copyOf(mTemp, count);
        return m1;
    }

    static int[] shortMinValue(int i, int n) {
        int min = Short.MIN_VALUE;
        int length = - min + i;
        int[] mTemp = new int[length];
        int count = 0;
        for (int j=min; j<(i+1); j++) {
            if (j % n == 0) {
                mTemp[count] = j;
                count++;
            }
        }
        int[] m2 = Arrays.copyOf(mTemp, count);
        return m2;
    }

}
