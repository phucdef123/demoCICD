package com.lab2;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	public boolean isEventNumber(int number) {
		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
