package com.datetime1.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get the current date
 LocalDate ld=LocalDate.now();
 System.out.println(ld);
           
       //get the current date and time
 LocalDateTime ldt=LocalDateTime.now();
 System.out.println(ldt);
  
      
 LocalDate ldspd=LocalDate.of(2000, Month.APRIL, 7);
 System.out.println(ldspd);
 
 LocalDate plswk =ld.plusWeeks(1);
 System.out.println(plswk);
 
 Period prd=Period.between(ldspd, ld);
 System.out.println(prd);
 DateTimeFormatter dfmt=DateTimeFormatter.ofPattern("dd-mm-yyyy");
 String formatedDate=ldt.format(dfmt);
 System.out.println((formatedDate));
 ZonedDateTime zndt=ZonedDateTime.now();
 System.out.println(zndt);
 ZoneId Znid=ZoneId.of("Asia/Tokyo");
 System.out.println(Znid);
 ZonedDateTime tk=ZonedDateTime.now(Znid);
 System.out.println(tk);
	}

}
