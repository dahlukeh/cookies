package andrew.cookies.game;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashMap;
import java.util.Arrays;
public class tests extends TestCase {
	
	@Test
	public void testHelper (){
		testChoose();
		testIndexOf();
		testShuffle();
	}
	private static final int TEST_LENGTH = 1000;
	public void testChoose() {
		int[] arr = {1,1,1,1,1,1,1,1};
		assertEquals(helper.choose(arr),1);
		arr = new int[]{1,1,2,3,4,5,6,7,8};
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> amnt = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (amnt.get(arr[i]) == null) 
				amnt.put(arr[i],1);
			else 
				amnt.put(arr[i],amnt.get(arr[i])+1);
		}
		int resp;
		for (int i = 0; i < arr.length *TEST_LENGTH; i++) {
			resp = helper.choose(arr);	
			if (res.get(resp) == null)
				res.put(resp,1);
			else
				res.put(resp,res.get(resp)+1);
		}
		for (Integer i: res.keySet()) {
			assertTrue(res.get(i) / amnt.get(i) - TEST_LENGTH < TEST_LENGTH/10 && res.get(i) / amnt.get(i) - TEST_LENGTH  > -TEST_LENGTH/10);
		}
		Integer[] oArray = {1,1,1,1,1,1,1};
		assertEquals((int)helper.choose(oArray),1);
		oArray = new Integer[] {1,2,3,4,5,5,6,7,8};
		res = new HashMap<Integer, Integer>();
		amnt = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (amnt.get(arr[i]) == null) 
				amnt.put(arr[i],1);
			else 
				amnt.put(arr[i],amnt.get(arr[i])+1);
		}
		for (int i = 0; i < arr.length *TEST_LENGTH; i++) {
			resp = helper.choose(arr);	
			if (res.get(resp) == null)
				res.put(resp,1);
			else
				res.put(resp,res.get(resp)+1);
		}
		for (Integer i: res.keySet()) {
			assertTrue(res.get(i) / amnt.get(i) - TEST_LENGTH < TEST_LENGTH/10 && res.get(i) / amnt.get(i) - TEST_LENGTH  > -TEST_LENGTH/10);
		}
	}
	public void testIndexOf() {
		Integer [] oArr = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < oArr.length; i++) {
			assertEquals(helper.indexOf(oArr,i),i);
		}
		oArr = new Integer[] {0,1,2,3,4,5,6,7,8,1};
		assertEquals(helper.indexOf(oArr,1),1);
		assertEquals(helper.indexOf(oArr,9),-1);
		int [] arr = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < arr.length; i++) {
			assertEquals(helper.indexOf(arr,i),i);
		}
		arr = new int[] {0,1,2,3,4,5,6,7,8,1};
		assertEquals(helper.indexOf(arr,1),1);
		assertEquals(helper.indexOf(arr,9),-1);
	}
	public void testShuffle() {
		Integer [] oArr = {0,1,2,3,4,5,6,7,8,9};
		helper.shuffle(oArr);
		for (int i = 0; i < oArr.length; i++) {
			assertNotSame(helper.indexOf(oArr,i),-1);
		}
		int same = 0;
		for (int i = 0; i < TEST_LENGTH; i++) {
			oArr = new Integer[] {0,1,2,3,4,5,6,7,8,9};
			helper.shuffle(oArr);
			for (int j = 0; j < oArr.length; j++) {
				if (oArr[j] == j)
					same++;
			}
		}
		assertTrue(same - TEST_LENGTH < TEST_LENGTH/10 && same - TEST_LENGTH > -TEST_LENGTH/10);
		
		int [] arr = {0,1,2,3,4,5,6,7,8,9};
		helper.shuffle(arr);
		for (int i = 0; i < arr.length; i++) {
			assertNotSame(helper.indexOf(arr,i),-1);
		}
		same = 0;
		for (int i = 0; i < TEST_LENGTH; i++) {
			arr = new int[] {0,1,2,3,4,5,6,7,8,9};
			helper.shuffle(arr);
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == j)
					same++;
			}
		}
		assertTrue(same - TEST_LENGTH < TEST_LENGTH/10 && same - TEST_LENGTH > -TEST_LENGTH/10);
		
	}
	
	
	public static void main (String[] args) {
		System.out.println("Testing Games");
	}

}