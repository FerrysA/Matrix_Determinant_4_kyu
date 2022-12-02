
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;// библ для ввода с клавиатуры

public class Main {

    static int determinant(int[][] A)

    {
        int n = A.length;
        if (n == 1) { return A[0][0]; }// элемент нулевой строки нулевого столбца

        int d = 0;

        int sing=1;
        for (int i = 0; i < n; i++)
        {
           if(i%2==0)
           {
               sing=1;
           }
            if(i%2==1)
            {
                sing=-1;
            }
            d = sing * A[0] [i] * determinant(Alg(A, 0, i)) + d;


        }


        return d;
    }
    static int[][] Alg(int[][] A, int i, int j)
    {
        int n = A.length;// строки
        int m = A[0].length;// столбцы
        int[][] BB = new int[n - 1] [m - 1];

        for (int k = 0; k < n - 1; k++) // k- строки l- столбцы
        {
            for (int l = 0; l < m - 1; l++)
            {

                if ((k < i) & (l < j))
                {
                    BB[k] [l] = A[k] [l];

                }

                if ((k >= i) & (l < j))
                {
                    BB[k] [l] = A[k + 1] [l];

                }

                if ((k < i) & (l >= j))
                {
                    BB[k] [l] = A[k] [l + 1];

                }

                if ((k >= i) & (l >= j))
                {
                    BB[k] [l] = A[k + 1] [l + 1];

                }

            }


        }

        return BB;
    }


    public static <string> void main(String[] args) {

        int[][] A = { { 1, 2 }, { 3,4 } };

        System.out.println(determinant(A));



    }
}


