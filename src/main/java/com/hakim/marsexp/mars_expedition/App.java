package com.hakim.marsexp.mars_expedition;

import java.util.ArrayList;

import com.hakim.marsexp.exception.InvalidInputException;
import com.hakim.marsexp.helper.AppHelper;
import com.hakim.marsexp.util.ExpeditionConstants;



/**
 * Author hahmim
 *
 */
public class App 
{
	

	public static void main(String[] args) {
		AppHelper appHelper = new AppHelper();
		ArrayList<Character> cardinals = new ArrayList<Character>();
		ArrayList<Character> validationList = new ArrayList<Character>();
		cardinals.add(ExpeditionConstants.North);
		cardinals.add(ExpeditionConstants.East);
		cardinals.add(ExpeditionConstants.South);
		cardinals.add(ExpeditionConstants.West);
		validationList.add(ExpeditionConstants.Left);
		validationList.add(ExpeditionConstants.Right);
		validationList.add(ExpeditionConstants.Move);
		try {
			long timeNow1 = System.currentTimeMillis();
			appHelper.moveRover(cardinals, validationList);
			long timeNow2 = System.currentTimeMillis();
			System.out.println("the time consumed was " + (timeNow2 - timeNow1) + " miliseconds");
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}
}
