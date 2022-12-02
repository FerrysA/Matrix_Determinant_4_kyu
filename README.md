# Matrix_Determinant_4_kyu
# 02.12.2022
# [cылка на задание](https://www.codewars.com/kata/52a382ee44408cea2500074c/train/java)
# Код:
```java
    
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

```
# понравивщееся решение:(автор Blind4Basics)
``` java
public static int determinant(int[][] m) {
        int d = 0, size = m.length;
        if (size == 1) return m[0][0];
        
        for (int n = 0 ; n < size ; n++) {
            int[][] newM = new int[size-1][size-1];
            for (int x = 1 ; x < size ; x++) for (int y = 0 ; y < size ; y++) {
                if (y == n) continue;
                newM[x-1][y + (y>n ? -1 : 0)] = m[x][y];
            }
            d += (n%2!=0 ? -1 : 1) * m[0][n] * determinant(newM);
        }
        return d;
    }
