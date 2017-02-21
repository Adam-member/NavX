package org.usfirst.frc.team2557.util;

public class Stats {
	
	public static final int MAXARRAYSIZE = 1000;
	
	private int currentElement;
	private double values[];

	public Stats()
	{
		values = new double[MAXARRAYSIZE];
		currentElement = 0;
	}

	public boolean addValue(double value)
	{
		if (isAtEnd()) {
			return false;
		}
		
		values[currentElement++] = value;
		
		return true;
	}
	
	public boolean isAtEnd()
	{
		if (currentElement >= MAXARRAYSIZE) {
			return true;
		}
		return false;
	}
	
	public double getAverage()
	{
		if (!isAtEnd()) {
			return 0.0;
		}
		
		double sum = 0.0;
		
		for (int i = 0; i < MAXARRAYSIZE; i++) {
			sum += values[i];
		}
		
		return sum / MAXARRAYSIZE;
	}
	
	public double getStandardDeviation() {
		if (!isAtEnd()) {
			return 0.0;
		}
		
		double average = getAverage();
		double sum = 0;
		
		for (int i = 0; i < MAXARRAYSIZE; i++) {
			sum += Math.pow(values[i] - average, 2);
		}
		
		return Math.sqrt(sum / MAXARRAYSIZE);
	}
}
