package org.gaahoo.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.annotations.common.util.impl.Log;

public class DateHelper {

	public static Date addHelper(String type,Date date,int amount){
		
		if(type.contains("jour")){
			return DateUtils.addDays(date, amount);
		}
		if(type.contains("semaine")){
			return DateUtils.addWeeks(date, amount);
		}
		if(type.contains("mois")){
			return DateUtils.addMonths(date, amount);
		}
		if(type.contains("anne")){
			return DateUtils.addYears(date, amount);
		}else{
			return null;
		}
		//DateUtils.isSameDay(date1, date2)
		
		
	}
	
	public static String toDate(Date date) {
	    
	    return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	public static String toDate(Date date,String type) {
	    
	    return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	public static Date getDateFormat(Date date) {
			  try{
				  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			    return formatter.parse(formatter.format(date));
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
			
	}
	
	public static int daysBetween(Date d1, Date d2) {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
	
	public static float numberDay(String dateBeforeString,String dateAfterString){
		
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		float daysBetween=0;
		try {
		       Date dateBefore = myFormat.parse(dateBeforeString);
		       Date dateAfter = myFormat.parse(dateAfterString);
		       long difference = dateAfter.getTime() - dateBefore.getTime();
		       daysBetween = (difference / (1000*60*60*24));
	               /* You can also convert the milliseconds to days using this method
	                * float daysBetween = 
	                *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
	                */
		       System.out.println("Number of Days between dates: "+daysBetween);
		 } catch (Exception e) {
		       e.printStackTrace();
		 }
		 
		 return daysBetween;
	}
	
	public static Date week() {
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    //c.add(Calendar.DATE, -i - 7);
	    Date start = c.getTime();
	    c.add(Calendar.DATE, 6);
	    Date end = c.getTime();
	    System.out.println(start + " - " + end);
	    
		return new Date();
	}
	
	public static Date beginWeek() {
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    System.out.println(c.get(Calendar.DAY_OF_WEEK)+"day");
	    System.out.println(c.getFirstDayOfWeek()+"first");
	    c.add(Calendar.DATE, -i - 7);
	    Date start = c.getTime();
	    c.add(Calendar.DATE, 6);
	    Date end = c.getTime();
	    System.out.println(end+"begin");
	    
		return  end;
	}
	
	public static Date endWeek() {
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    c.add(Calendar.DATE, -i - 7);
	    Date start = c.getTime();
	    c.add(Calendar.DATE, 6);
	    Date end = c.getTime();
	    System.out.println(DateUtils.addDays(end, 6)+"end");
	    
		return DateUtils.addDays(end, 6);
	}
	
	public static String getDay(Date date) {
		String day="";
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)day="Lundi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY)day="Mardi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY)day="Mercredi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY)day="Jeudi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)day="Vendredi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)day="Samedi";
	    if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)day="Dimanche";
		return day;
	}
	
	public boolean isSameDay(Date date1,Date date2) {
		boolean val=false;
		if(getDay(date1).contains(getDay(date2)))val=true;
		
		return val;
		
	}
	
	
	public static String getMonthLibelle(int month, int year){
        String libelle="";
        month=month+1;
        if (month==1){
            libelle="Janvier";
        }
        if (month==2){
            libelle="Fevrier";
        }
        if (month==3){
            libelle="Mars";
        }
        if (month==4){
            libelle="Avril";
        }
        if (month==5){
            libelle="Mai";
        }
        if (month==6){
            libelle="Juin";
        }
        if (month==7){
            libelle="Juillet";
        }
        if (month==8){
            libelle="Août";
        }
        if (month==9){
            libelle="Septembre";
        }
        if (month==10){
            libelle="Octobre";
        }
        if (month==11){
            libelle="Novembre";
        }
        if (month==12){
            libelle="Decembre";
        }
        return  libelle+" "+String.valueOf(year);
    }
	public static String lastDayOfMonth(int month,int year){

        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month+1)+"-21");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(lastDayOfMonth);
    }


    public static String firstDayOfMonth(int month,int year){

        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month+1)+"-01");
        

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(today);
    }
    
    public static String firstDayOfMonth(){
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month+1)+"-01");
        

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(today);
    }
    
    public static String lastDayOfMonth(){
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month+1)+"-21");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(lastDayOfMonth);
    }
    
    public static String firstDayOfPastMonth(){
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
    	if(month==0) {
    		month=11;
    		year=year-1;
    	}
        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month)+"-01");
        

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(today);
    }
    
    public static String lastDayOfPastMonth(){
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
    	if(month==0) {
    		month=12;
    		year=year-1;
    	}
        Date today = parseDate(String.valueOf(year)+"-"+String.valueOf(month)+"-21");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Today            : " + sdf.format(today));
        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        return  sdf.format(lastDayOfMonth);
    }
    
    
    
    public static Date parseDate(String date){


        Date date1= null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  date1;
    }
    
    public static Date parseDate(String date,String form) {


        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date1;
    }
    
    public static int[] getDayMonthYear(Date date){

        try {
            String val="";
            // Fri Jun 17 14:54:28 PDT 2016
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // 17
            int year = cal.get(Calendar.YEAR); // 2016
            int month = cal.get(Calendar.MONTH); // 2016
            return new int[]{dayOfMonth, month,year};
        }catch (Exception e){
            return new int[]{-1, -1,-1};
        }
        

    }
    
    public static boolean isSameMonthYear(Date d1,Date d2){
    	boolean val=false;
    	if(getDayMonthYear(d1)[1]==getDayMonthYear(d2)[1] && getDayMonthYear(d1)[2]==getDayMonthYear(d2)[2]){
    		val=true;
    	}
    	
    	return val;
    	
    }
}
