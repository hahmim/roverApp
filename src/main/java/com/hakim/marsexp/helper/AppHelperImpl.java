/**
 * 
 */
package com.hakim.marsexp.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import com.hakim.marsexp.entity.Rover;
import com.hakim.marsexp.exception.InvalidInputException;
import com.hakim.marsexp.util.ExpeditionConstants;

/**
 * @author Kamilia_PC
 *
 */
public class AppHelperImpl implements AppHelper{
	
	private static String csvFormatString = null;
	private Rover rover = new Rover();
	

	/* 
	 * specify the path of the files to be used as input separating each path
	 * directory with "\\"
	 */
	private static String csvFile = "C:\\Users\\hahmim\\Documents\\Input.csv";
	

	/* (non-Javadoc)
	 * I agrregate the rotational as well as vertical or horizontal movement of the rover
	 */
	public void moveRover(ArrayList<Character> crdnls, ArrayList<Character> valdtns) throws InvalidInputException {
		BufferedReader br = null;
		String line = "";
		String message = "Invalid Input please provide an input valiue from the following list: L,R,M";
		String instructions = null;
		String cvsSplitBy = ",";
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as a tokenizer
				String[] input = line.split(cvsSplitBy);

				rover.setX(Integer.parseInt(input[ExpeditionConstants.zero]));
				rover.setY(Integer.parseInt(input[ExpeditionConstants.one]));
				rover.setPos((input[ExpeditionConstants.two]).charAt(ExpeditionConstants.zero));
				
				/* 
				 * get the csvFormatedinput remove the overhead of empty chars & dump it into instruction string
				 * */
				
				csvFormatString = input[ExpeditionConstants.three];
				instructions = csvFormatString.replaceAll("\\s+","");				
				char[] directionArr = instructions.toCharArray();
				int n = directionArr.length;

				for (int i = 0; i < n; i++) {
					// input validation
					if (!(valdtns.contains(directionArr[i]))) {
						// throw a custom exception for invalid input
						throw new InvalidInputException(message);

					}
					// Determine the heading of the rove
					Character prevPos = rover.getPos();
					Character pos = threeSixty(directionArr[i], rover.getPos(), n, crdnls);
					rover.setPos(pos);
					Character postPos = rover.getPos();
					if(prevPos.equals(postPos)){
						if(rover.getY()==ExpeditionConstants.MaximumCoord && directionArr[i] == ExpeditionConstants.Move){
							rover.setY(ExpeditionConstants.MinimumCoord);
						}else if(rover.getY()==ExpeditionConstants.MinimumCoord && directionArr[i] == ExpeditionConstants.Move){
							rover.setY(ExpeditionConstants.MaximumCoord);
						}else if(rover.getX()==ExpeditionConstants.MaximumCoord && directionArr[i] == ExpeditionConstants.Move){
							rover.setX(ExpeditionConstants.MinimumCoord);
						}else if(rover.getX()==ExpeditionConstants.MinimumCoord && directionArr[i] == ExpeditionConstants.Move){
							rover.setX(ExpeditionConstants.MaximumCoord);
						}
						else if(rover.getPos() == ExpeditionConstants.North && directionArr[i] == ExpeditionConstants.Move){
							rover.setY(rover.getY()+ExpeditionConstants.one);
						}
						else if(rover.getPos() == ExpeditionConstants.South && directionArr[i] == ExpeditionConstants.Move){
							rover.setY(rover.getY()-ExpeditionConstants.one);
						}
						else if(rover.getPos() == ExpeditionConstants.East && directionArr[i] == ExpeditionConstants.Move){
							rover.setX(rover.getX()+ExpeditionConstants.one);
						}
						else if(rover.getPos() == ExpeditionConstants.West && directionArr[i] == ExpeditionConstants.Move){
							rover.setX(rover.getX()-ExpeditionConstants.one);
						}
					}
					
				}
				//output rover's coordinates and heading to the console
				System.out.println(rover.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/*
	 * I help with the rotational movement
	 * */
	public Character threeSixty(Character inst, Character c, int n, ArrayList<Character> cardinals) {
		for  (int i = 0; i< cardinals.size();i++) {
			
			 /*
			  * Determine which Direction does the Inst(ruction) point the rover towards
			  **/
			
			if (inst.equals(ExpeditionConstants.Right)  || inst.equals(ExpeditionConstants.Left) ) {
					/* 
					 *  step through the list of cardinals
					 *  current value of the index is equal to the current
					 *  heading of the rover then rotate
					 * 
					 * */
					if (cardinals.get(i).equals(c)) {
						// rotate right
						if (inst.equals(ExpeditionConstants.Right) ) {
							if (i < cardinals.size() - ExpeditionConstants.one) {
								c = cardinals.get(i + ExpeditionConstants.one);
								return c;
							} 
							// if reached the last value go back to the value in the beginning
							else {
								return c = cardinals.get(ExpeditionConstants.zero);
							}
						} else if (inst == ExpeditionConstants.Left) {
							// rotate left
							if (i > 0) {
								c = cardinals.get(i - ExpeditionConstants.one);
								return c;
							} 
							// if reached the first value go back to the value in the end
							else {
								return c = cardinals.get(cardinals.size() - ExpeditionConstants.one);
							}
						}

					} 

			} else {
				return c;
			}
		}
		return c;
	}



}
