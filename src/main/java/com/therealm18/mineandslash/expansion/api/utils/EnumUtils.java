package com.therealm18.mineandslash.expansion.api.utils;

import java.util.function.Function;
import javax.annotation.Nullable;

public final class EnumUtils {
  private EnumUtils() { throw new IllegalAccessError("Utility class"); }



  
  public static <E extends Enum<E>> E byIndex(int value, E defaultValue, Function<E, Integer> getter) {
    Enum[] arrayOfEnum;
    int i;
    byte b;
    for (arrayOfEnum = (Enum[])defaultValue.getDeclaringClass().getEnumConstants(), i = arrayOfEnum.length, b = 0; b < i; ) { E e = (E)arrayOfEnum[b];
      if (((Integer)getter.apply(e)).intValue() == value)
        return e; 
      b++; }
    
    return defaultValue;
  }



  
  public static <E extends Enum<E>> E byName(String name, E defaultValue) {
    Enum[] arrayOfEnum;
    int i;
    byte b;
    for (arrayOfEnum = (Enum[])defaultValue.getDeclaringClass().getEnumConstants(), i = arrayOfEnum.length, b = 0; b < i; ) { E e = (E)arrayOfEnum[b];
      if (e.name().equalsIgnoreCase(name))
        return e; 
      b++; }
    
    return defaultValue;
  }






  
  public static <E extends Enum<E>> E byOrdinal(int ordinal, E defaultValue) {
    E[] enumConstants = (E[])(Enum[])defaultValue.getDeclaringClass().getEnumConstants();
    if (ordinal >= 0 && ordinal < enumConstants.length) {
      return enumConstants[ordinal];
    }
    return defaultValue;
  }






  
  public static <E extends Enum<E>> boolean validate(@Nullable Object obj, Class<E> enumClass) {
    if (obj != null) {
      Enum[] arrayOfEnum; int i; byte b; for (arrayOfEnum = (Enum[])enumClass.getEnumConstants(), i = arrayOfEnum.length, b = 0; b < i; ) { E e = (E)arrayOfEnum[b];
        if (e.name().equalsIgnoreCase(obj.toString()))
          return true; 
        b++; }
    
    } 
    return false;
  }
}