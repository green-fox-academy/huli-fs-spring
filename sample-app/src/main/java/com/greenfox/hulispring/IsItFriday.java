package com.greenfox.hulispring;

public class IsItFriday {
  static String isItFriday(String today) {
    if (today.equalsIgnoreCase("friday")){
      return "Yaay";
    } else
    return "Nope";
  }
}
