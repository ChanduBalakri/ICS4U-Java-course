package Cheat;

public class Copy {

	public static void main(String[] args) {
		        String [] months = {"January", "February", "March", "April", "May", "June", "July","August", "September", "October", "November","December"};
		        int [] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //number of days in each month
		        String [] daysOfWeek = {"S", "M", "T", "W", "TH", "F", "S"};
		        int startYearOnDay = 5; //eg. start year on a Friday
		        int startMonth = startYearOnDay; //January to start same day
		        //loop though months
		        for(int m = 0; m < months.length; m++){
		            //Display month and days of week
		            System.out.println(months[m]+"\n");
		            for(int w = 0; w < daysOfWeek.length; w++){
		                System.out.print(daysOfWeek[w]+"\t");
		            }
		            System.out.println();
		            //tab so month starts aligned with correct day of week
		            for(int s = 0; s < startMonth; s++){
		                System.out.print("\t");
		            }
		            //Display days of month
		            for(int d = 0; d < numberOfDays[m]; d++){
		                if((startMonth + d)%7 == 0 && d != 0){
		                    System.out.println();
		                }
		                System.out.print((d+1)+"\t");
		            }
		            startMonth = (startMonth + numberOfDays[m]) % 7;
		            System.out.println();
		            System.out.println();
		        }
		    }
		}