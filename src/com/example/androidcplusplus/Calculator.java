package com.example.androidcplusplus;

public class Calculator {

	static{
		System.loadLibrary("calculator");
	}
	
	public native float sum(float a, float b);
	
}
