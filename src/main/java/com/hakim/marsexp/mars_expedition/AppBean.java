package com.hakim.marsexp.mars_expedition;

import java.util.ArrayList;

import com.hakim.marsexp.exception.InvalidInputException;
import com.hakim.marsexp.helper.AppHelper;


public class AppBean {
	
	private AppHelper AppHelperImpl;

	

	public void setAppHelperImpl(AppHelper appHelperImpl) {
		this.AppHelperImpl = appHelperImpl;
	}
	
	public void callMoveRover(ArrayList<Character> cardinals,ArrayList<Character> validationList) throws InvalidInputException {
		AppHelperImpl.moveRover(cardinals, validationList);
	}

}
