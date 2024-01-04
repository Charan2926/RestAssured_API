package com.GenericUtility;

import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to get random number
	 * @author Nani
	 * @return
	 */
	public int getRandomno() {
		Random ran = new Random();
		int random =ran.nextInt();
		return random;
	}
}
