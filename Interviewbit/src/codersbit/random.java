package codersbit;

public class random {
	
	#include <stdio.h>

	#define N 100000

	static int factorCount[N+1];

	int main(void)
	{
	    int i, j;

	    for (i = 0; i <= N; i++) {
	        factorCount[i] = 0;
	    }

	    for (i = 2; i <= N; i++) {
	        if (factorCount[i] == 0) { // Number is prime
	            for (j = i; j <= N; j += i) {
	                factorCount[j]++;
	            }
	        }
	    }

	    printf("2 has %i distinct prime factors\n", factorCount[2]);
	    printf("10 has %i distinct prime factors\n", factorCount[10]);
	    printf("11111 has %i distinct prime factors\n", factorCount[11111]);
	    printf("12345 has %i distinct prime factors\n", factorCount[12345]);
	    printf("30030 has %i distinct prime factors\n", factorCount[30030]);
	    printf("45678 has %i distinct prime factors\n", factorCount[45678]);

	    return 0;
	}

}
