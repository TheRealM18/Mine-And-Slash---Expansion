package com.therealm18.mineandslash.expansion.api.utils;

import java.util.Random;

public final class MathUtils
{
	  private static final double DOUBLES_EQUAL_PRECISION = 1.0E-9D;
	  private static final Random RANDOM = new Random();

	  
	  private MathUtils() { throw new IllegalAccessError("Utility class"); }


	  
	  public static double clamp(double value, double lowerBound, double upperBound) { return (value < lowerBound) ? lowerBound : ((value > upperBound) ? upperBound : value); }


	  
	  public static float clamp(float value, float lowerBound, float upperBound) { return (value < lowerBound) ? lowerBound : ((value > upperBound) ? upperBound : value); }


	  
	  public static int clamp(int value, int lowerBound, int upperBound) { return (value < lowerBound) ? lowerBound : ((value > upperBound) ? upperBound : value); }





	  
	  public static boolean doublesEqual(double a, double b) { return doublesEqual(a, b, 1.0E-9D); }







	  
	  public static boolean doublesEqual(double a, double b, double precision) { return (Math.abs(b - a) < precision); }








	  
	  public static boolean doubleIsInt(double value) { return doublesEqual(value, (int)value); }





	  
	  public static boolean floatsEqual(float a, float b) { return floatsEqual(a, b, 1.0E-9F); }








	  
	  public static boolean floatIsInt(float value) { return floatsEqual(value, (int)value); }







	  
	  public static boolean floatsEqual(float a, float b, float precision) { return (Math.abs(b - a) < precision); }


	  
	  public static boolean inRangeExclusive(double value, double min, double max) { return (value < max && value > min); }


	  
	  public static boolean inRangeExclusive(int value, int min, int max) { return (value < max && value > min); }


	  
	  public static boolean inRangeInclusive(double value, double min, double max) { return (value <= max && value >= min); }


	  
	  public static boolean inRangeInclusive(int value, int min, int max) { return (value <= max && value >= min); }


	  
	  public static int min(int a, int b) { return (a < b) ? a : b; }

	  
	  public static int min(int a, int b, int c) {
	    if (b < a) a = b; 
	    if (c < a) a = c; 
	    return a;
	  }
	  
	  public static int min(int a, int b, int c, int d) {
	    if (b < a) a = b; 
	    if (c < a) a = c; 
	    if (d < a) a = d; 
	    return a;
	  }
	  
	  public static int min(int a, int b, int c, int d, int... rest) {
	    int min = min(a, b, c, d);
	    for (int i : rest) {
	      if (i < min)
	        min = i; 
	    }  return min;
	  }

	  
	  public static int max(int a, int b) { return (a > b) ? a : b; }

	  
	  public static int max(int a, int b, int c) {
	    if (b > a) a = b; 
	    if (c > a) a = c; 
	    return a;
	  }
	  
	  public static int max(int a, int b, int c, int d) {
	    if (b > a) a = b; 
	    if (c > a) a = c; 
	    if (d > a) a = d; 
	    return a;
	  }
	  
	  public static int max(int a, int b, int c, int d, int... rest) {
	    int max = max(a, b, c, d);
	    for (int i : rest) {
	      if (i > max)
	        max = i; 
	    }  return max;
	  }

	  
	  public static double nextGaussian(double mean, double deviation) { return deviation * RANDOM.nextGaussian() + mean; }


	  
	  public static double nextGaussian(Random random, double mean, double deviation) { return deviation * random.nextGaussian() + mean; }


	  
	  public static int nextInt(int bound) { return RANDOM.nextInt(bound); }


	  
	  public static int nextIntInclusive(int min, int max) { return RANDOM.nextInt(max - min + 1) + min; }


	  
	  public static int nextIntInclusive(Random random, int min, int max) { return random.nextInt(max - min + 1) + min; }


	  
	  public static boolean tryPercentage(double percent) { return (RANDOM.nextDouble() < percent); }


	  
	  public static boolean tryPercentage(Random random, double percent) { return (random.nextDouble() < percent); }
	}
