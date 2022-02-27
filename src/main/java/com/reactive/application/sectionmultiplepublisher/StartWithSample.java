package com.reactive.application.sectionmultiplepublisher;

import com.reactive.application.sectionutil.NameGenerator;
import com.reactive.application.sectionutil.UtilClass;

public class StartWithSample {

  public static void main(String[] args) {
    NameGenerator nameGenerator = new NameGenerator();

    nameGenerator.getNames().take(2).subscribe(UtilClass.getSubscriber("SAM"));
    UtilClass.sleepThread(2);
    nameGenerator.getNames().take(3).subscribe(UtilClass.getSubscriber("MIKE"));
    UtilClass.sleepThread(2);
    nameGenerator.getNames().take(2).subscribe(UtilClass.getSubscriber("JAKE"));
  }
}
