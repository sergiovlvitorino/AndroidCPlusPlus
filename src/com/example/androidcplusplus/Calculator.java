package com.example.androidcplusplus;

public class Calculator {

	static{
		System.loadLibrary("calculator");
	}
	
	public native float sum(float a, float b);
	
	public native float sub(float a, float b);
	
	public native float mult(float a, float b);
	
	public native float div(float a, float b);
	
}
