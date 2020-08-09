package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class _30_Isomorphic_Strings {

	public static void main(String[] args) {
		String X = "ACAB";
		String Y = "XCXY";

		if (isIsomorphic(X, Y)) {
			System.out.print(X + " and " + Y + " are Isomorphic");
		}
		else {
			System.out.print(X + " and " + Y + " are not Isomorphic");
		}
	}

	public static boolean isIsomorphic(String str1, String str2)
	{
		// if X and Y have different lengths, they cannot be Isomorphic
		if (str1==null || str2==null || str1.length() != str2.length()) {
			return false;
		}

		// use map to store mapping from characters of String X to String Y
		Map<Character, Character> map = new HashMap<>();


		for (int i = 0; i < str1.length(); i++)
		{
			char x = str1.charAt(i), y = str2.charAt(i);

			// if x is seen before
			if (map.containsKey(x))
			{
				// return false if first occurrence of x is mapped to different character
				if (map.get(x) != y)
					return false;
			}

			// if x is seen for the first time (i.e. it is not mapped yet)
			else
			{
				// map y to x and mark it mapped
				map.put(x, y);
			}
		}

		return true;
	}
	
	
	@Test
	public void checkIsomorphic()
	{
		String X = "ACAB";
		String Y = "XCXY";
		boolean isIsomorphic=isIsomorphic(X,Y);
		Assert.assertTrue(isIsomorphic);
		
		X="egg";
		Y="add";
		isIsomorphic=isIsomorphic(X,Y);
		Assert.assertTrue(isIsomorphic);
		
		X="foo";
		Y="bar";
		isIsomorphic=isIsomorphic(X,Y);
		Assert.assertFalse(isIsomorphic);
		
		X="paper";
		Y="title";
		isIsomorphic=isIsomorphic(X,Y);
		Assert.assertTrue(isIsomorphic);
	}
}
