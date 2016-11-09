/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamentocadeias;


public class CasamentoCadeias {
    
    public static int maxChar = 256;
    
    public static void forcaBruta (String T, int n, String P, int m) 
    {
            for (int i = 0; i < (n - m + 1); i++)
            {
                    int k = i;
                    int j = 0;
                    while((j < m) && (T.charAt(k) == P.charAt(j)))
                    {
                            j++;
                            k++;
                    }
                    if (j == m)
                            System.out.println ("Casamento na posição : " + i);
            }
    }
    
    public static void shiftAndExato (String T, int n, String P, int m)
    {
	int R = 0;
	//Pré-processamento do padrão
	int M[] = new int[maxChar];
	for(int i = 0; i < maxChar; i++) M[i] = 0;
	for(int j = 0; j < m; j++)
	M[(int)P.charAt(j)] = M[(int)P.charAt(j)] | (1 << (m - j -1));
	// Pesquisa
	for (int i = 0; i < n; i++)
	{
		R = ((R >> 1) | (1 << (m-1))) & M[(int)T.charAt (i)];
		if((R & 1) != 0)
			System.out.println("Casamento na posicao : " + ( i - m + 1));
	}
    }
    
    public static void bmhs (String T, int n, String P, int m)
    {
            // Pré processamento do padrão
            int d[] = new int[maxChar];
            for (int j = 0; j < maxChar; j++)
                    d[j] = m + 1;

            for(int j = 0; j < m; j++)
                    d[(int)P.charAt(j)] = m - j;

            int i = m - 1;

            while(true) // Pesquisa
            {
                    int k = i;
                    int j = m - 1;
                    while ((j >= 0) && (T.charAt(k) == P.charAt(j)))
                    {
                            j--;
                            k--;
                    }
                    if (j < 0)
                            System.out.println ("Casamento na posicao: " + (k + 1));
                    
                    if (i < n - 1)
                        i = i + d[(int)T.charAt(i+1)];
                    else
                        break;
            }
    }
    
    public static void shiftAndAproximado (String T, int n, String P, int m, int k)
    {
	// Pré processamento do padrão
	int R[] = new int[k + 1];
	int M[] = new int[maxChar];
	for(int i = 0; i < maxChar; i++) M[i] = 0;
	for(int j = 0; j < m; j++) M[(int)P.charAt(j)] = M[(int)P.charAt(j)] | ( 1 << (m - j -1));
	//Pesquisa	
	int Ri = 1 << (m - 1);
	R[0] = 0;
	for(int j = 1; j <= k; j++) R[j] = (1 << (m-j)) | R[j-1];
	for(int i = 0; i < n; i++) {
		int Rant = R[0];
		int RNovo = ((Rant >> 1) | Ri) & M[(int) T.charAt(i)];
		R[0] = RNovo;
		for(int j = 1; j <= k; j++) {
                    RNovo = (((R[j] >> 1) & M[(int)T.charAt(i)]) | Rant | (Rant | RNovo) >> 1);
                    Rant = R[j];
                    R[j] = RNovo | Ri;
		}
		if((RNovo & 1) != 0)
			System.out.println("Casamento na posicao: " + (i - m + 1));
	}
	
    }

}
