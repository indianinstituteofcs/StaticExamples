import java.util.*;



class StaticExample {
	private static int numInstances = 0;
	private static ArrayList<Long> primeList = new ArrayList<Long>();

	StaticExample() {
		numInstances++;
		if (primeList.size() == 0) {
			primeList.add(2L);
		}
	}
	
	protected static void printPrimeList() {
		System.out.print("primeList: [");
		int primeLength = primeList.size();
		
		for(int i = 0; i < primeLength ; i++) {
			if (i == (primeLength - 1)) {
				System.out.print(primeList.get(i));				
			} else {
				System.out.print(primeList.get(i) + ", ");
			}
		}
		
		System.out.println("]");
	}
	
	protected static int getCount() {
		return numInstances;
	}
	
	protected static boolean isPrime(Long targetNumber) {
		Long maxDivisor = (long) (Math.sqrt(targetNumber) + 1);
		Long lastPrime = primeList.get(primeList.size() - 1);
		
		for(Long currNumber = (lastPrime + 1); currNumber < maxDivisor; currNumber++) {
			if (Math.IEEEremainder(currNumber, 2) != 0) {
				Boolean isPrime = true;

				for(Long currentPrime: primeList) {
					if (Math.IEEEremainder(currNumber, currentPrime) == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					primeList.add(currNumber);
				}
			}
		}
		
		for(Long currentPrime: primeList) {
			if (Math.IEEEremainder(targetNumber, currentPrime) == 0) 
				return false;
		}
		
		return true;
	}
}

public class Drive {

	public static void main(String[] args) {		
		System.out.println("Starting with " + StaticExample.getCount() + " instances");

		for (int i = 0; i < 500; ++i) {
			new StaticExample();
		}
		System.out.println("Created " + StaticExample.getCount() + " instances");
		
		Long limitNumber = 1000L;
		int numberPrimes = 0;

		System.out.println("List of Prime numbers less than or equal to "+ limitNumber);

		System.out.print("[2 ");			

		for(int i = 3; i < limitNumber; i++) {
			if (StaticExample.isPrime((long) i)) {
				System.out.print(", " + i );
				numberPrimes++;
			}
		}
		
		System.out.println("]");
		System.out.println("Total number of primes numbers <= " + limitNumber + " is: " + numberPrimes);
		StaticExample.printPrimeList();
	}	
}





