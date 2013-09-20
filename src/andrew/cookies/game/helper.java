package andrew.cookies.game;
import java.util.Random;

public class helper {
	private static Random randomGenerator = new Random();
	/**
		picks a random element from the given array
		@return A random element from the array
	*/
	public static <T> T choose (T[] arr) {
		return 	arr[randomGenerator.nextInt(arr.length)];
	}
	public static int choose (int[] arr) {
		return 	arr[randomGenerator.nextInt(arr.length)];
	}
	/** 
		@return Index of element in an array or -1 if no element exists
	**/		
	public static <T> int indexOf(T[] arr, T needle) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(needle))
				return i;
		}
		return -1;
	}
	public static int indexOf(int[] arr, int needle) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==needle)
				return i;
		}
		return -1;
	}

	/** 
		Shuffles an array in place. Therefore this function is not threadsafe.
	*/
	public static <T> T[] shuffle (T[] arr) {
		int counter = arr.length, index;
		T temp;
		// While there are elements in the array
		while (counter-- != 0)
		{
			// Pick a random index
			index = randomGenerator.nextInt(counter+1);

			// And swap the last element with it
			temp = arr[counter];
			arr[counter] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
	public static int[] shuffle (int[] arr) {
		int counter = arr.length, index;
		int temp;
		// While there are elements in the array
		while (counter-- != 0)
		{
			// Pick a random index
			index = randomGenerator.nextInt(counter+1);

			// And swap the last element with it
			temp = arr[counter];
			arr[counter] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
}