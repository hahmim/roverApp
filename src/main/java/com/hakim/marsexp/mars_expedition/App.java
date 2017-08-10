package com.hakim.marsexp.mars_expedition;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hakim.marsexp.exception.InvalidInputException;
import com.hakim.marsexp.helper.AppHelper;
import com.hakim.marsexp.helper.AppHelperImpl;
import com.hakim.marsexp.util.ExpeditionConstants;



/**
 * Author hahmim
 *
 */
public class App 
{


	public static void main(String[] args) {
		
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppBean AppBean = (AppBean) ctx.getBean("AppBean");
		
		ArrayList<Character> cardinals = new ArrayList<Character>();
		ArrayList<Character> validationList = new ArrayList<Character>();
		cardinals.add(ExpeditionConstants.North);
		cardinals.add(ExpeditionConstants.East);
		cardinals.add(ExpeditionConstants.South);
		cardinals.add(ExpeditionConstants.West);
		validationList.add(ExpeditionConstants.Left);
		validationList.add(ExpeditionConstants.Right);
		validationList.add(ExpeditionConstants.Move);
		long timeNow1 = System.currentTimeMillis();
			try {
				AppBean.callMoveRover(cardinals, validationList);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		long timeNow2 = System.currentTimeMillis();
		System.out.println("the time consumed was " + (timeNow2 - timeNow1) + " miliseconds");
	}
}
