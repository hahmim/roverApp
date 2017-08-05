/**
 * 
 */
package com.hakim.marsexp.entity;

public class Rover {
	
	Integer x;
	Integer y;
	Character pos;
	

	public Rover() {
		super();
	}
	

	public Integer getX() {
		return x;
	}




	public void setX(Integer x) {
		this.x = x;
	}




	public Integer getY() {
		return y;
	}




	public void setY(Integer y) {
		this.y = y;
	}




	public Character getPos() {
		return pos;
	}




	public void setPos(Character pos) {
		this.pos = pos;
	}




	@Override
	public String toString() {
		return "" + x +" " + y +" "+pos + "";
	}




}
