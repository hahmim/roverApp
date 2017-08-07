/**
 * 
 */
package com.hakim.marsexp.helper;

import java.util.ArrayList;

import com.hakim.marsexp.exception.InvalidInputException;

/**
 * @author Kamilia_PC
 *
 */
public interface AppHelper {
	
	public void moveRover(ArrayList<Character> crdnls, ArrayList<Character> valdtns) throws InvalidInputException;
	
	public Character threeSixty(Character inst, Character c, int n, ArrayList<Character> cardinals);

}
