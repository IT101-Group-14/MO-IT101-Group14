package motorph;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeesData {
		
	private static boolean foundAttendance;
	public static void main(String[] args) throws FileNotFoundException {
		

		Scanner scan = new Scanner (System.in);
		
		File myObj = new File ("C:\\Users\\Dell_i5\\Downloads\\Employee_Details.csv");
		
		
		System.out.println("Enter Your Employee Number");
		String employeenumber = scan.nextLine();
		
		try {
			Scanner scan1 = new Scanner (myObj);
			boolean foundEmployee =false;
			
			while (scan1.hasNextLine()) {
			 String line = scan1.nextLine();
			 String[] fields = line.split(",");
			 
			 if (fields.length > 0 && fields[0].equals(employeenumber)) {
				 foundEmployee = true;
				 displayEmployeeDetails(fields);
				 break;
			 }
			}
			
			 if (!foundEmployee) {
				 System.out.println("Employee not found");
			 } else	{	 	 
			 boolean found_Attendance = false;
				 
				 scan1 = new Scanner(myObj);
				 
				   while (scan1.hasNextLine()) {
				   String line = scan1.nextLine();
				   String[] fields = line.split(",");
				   
				   if (fields.length > 0 && fields[0].equals(employeenumber)) {
						 foundEmployee = true;
						 displayworketime(fields);
						 break;
				   }
				 } 
			   }
			 
				Scanner scan2 = new Scanner (myObj);
				
				boolean foundEmployee1 =false;
				
				while (scan2.hasNextLine()) {
				 String line = scan2.nextLine();
				 String[] fields = line.split(",");
				 
				 if (fields.length > 0 && fields[0].equals(employeenumber)) {
					 foundEmployee = true;
					 displaysalarycalculations(fields);
					 break;
				 }
				}

			 scan1.close();
			 } catch (FileNotFoundException e) {
				 e.printStackTrace();
		 }
		}

		private static void displayworketime(String[] fields) {
	 // calculation of total staffed time
			
		System.out.println("----------------------Worked Time--------------------------");
			
			// Show worked hours
		System.out.println("Date             |Time in        |Time out          |Staffed Time");
		System.out.println(fields[21] + "              " + fields[22] + "         " + fields[23]+ "             " + fields[24]);
		System.out.println(fields[25] + "              " + fields[26] + "         " + fields[27]+ "             " + fields[28]);
		System.out.println(fields[29] + "              " + fields[30] + "         " + fields[31]+ "             " + fields[32]);
		System.out.println(fields[33] + "              " + fields[34] + "         " + fields[35]+ "             " + fields[36]);
		System.out.println(fields[37] + "   	       " + fields[38] + "         " + fields[39]+ "             " + fields[40]);
		System.out.println(fields[41] + "              " + fields[42] + "         " + fields[43]+ "             " + fields[44]);
		System.out.println(fields[45] + "              " + fields[46] + "         " + fields[47]+ "             " + fields[48]);
		System.out.println(fields[49] + "              " + fields[50] + "         " + fields[51]+ "             " + fields[52]);
		System.out.println(fields[53] + "              " + fields[54] + "         " + fields[55]+ "             " + fields[56]);
		System.out.println(fields[57] + "              " + fields[58] + "         " + fields[59]+ "             " + fields[60]);
		System.out.println(fields[61] + "              " + fields[62] + "         " + fields[63]+ "             " + fields[64]);
		System.out.println(fields[65] + "              " + fields[66] + "         " + fields[67]+ "             " + fields[68]);
		System.out.println(fields[69] + "              " + fields[70] + "         " + fields[71]+ "             " + fields[72]);
		System.out.println(fields[73] + "              " + fields[74] + "         " + fields[75]+ "             " + fields[76]);
		System.out.println(fields[77] + "              " + fields[78] + "         " + fields[79]+ "             " + fields[80]);
			System.out.println("--------------------------------------------------------------");
			
			double day1 = Double.parseDouble(fields[24]);
			double day2 = Double.parseDouble(fields[28]);
			double day3 = Double.parseDouble(fields[32]);
			double day4 = Double.parseDouble(fields[36]);
			double day5 = Double.parseDouble(fields[40]);
			double day6 = Double.parseDouble(fields[44]);
			double day7 = Double.parseDouble(fields[48]);
			double day8 = Double.parseDouble(fields[52]);
			double day9 = Double.parseDouble(fields[56]);
			double day10 = Double.parseDouble(fields[60]);
			double day11 = Double.parseDouble(fields[64]);
			double day12 = Double.parseDouble(fields[68]);
			double day13 = Double.parseDouble(fields[72]);
			double day14 = Double.parseDouble(fields[76]);
			double day15 = Double.parseDouble(fields[80]);
			
			double total = day1 + day2 + day3 + day4 + day5 + day6 + day7 + day8 + day9 + day10 + day11 +day12 + day13 + day14 + day15;
			System.out.println("Total Working Hours:      " + total);
		
	}

		private static void displaysalarycalculations(String[] fields) {
			System.out.println();
            System.out.println("*********************Salary Details*************************");
            System.out.println();
            System.out.println("Staffed Time: " + fields[81]);
		    System.out.println("Hourly Rate: " + fields[18]);
			System.out.println("Rice Subsidy: " + fields[14]);
			System.out.println("Phone Allowance: " + fields[15]);
			System.out.println("Clothing Allowance: " + fields[16]);
			System.out.println("SSS Contribution: " + fields[19]);
			System.out.println("Gross Pay: " + fields[17]);
			System.out.println();	
		    System.out.println("===============================================================");					 
			System.out.println("**************CALCULATION OF YOUR SALARY***************");


			 // partial salary details
			 double Staffed_time = Double.parseDouble(fields[81]);
			 double hourly_rate = Double.parseDouble(fields[18]);
			 double ricesub = Double.parseDouble(fields[14]);
			 double phoneall = Double.parseDouble(fields[15]);
			 double cloth = Double.parseDouble(fields[16]);
			 double sss =  Double.parseDouble(fields[19]);
			 double gross = Double.parseDouble(fields[17]);
			
			
   			
			 //Calculations of staffed time and hourly rate
			 double workedhours = Staffed_time * hourly_rate;
			 double totalhours = workedhours;
			 
			 
			 //calculations of benefits
			 double benefits = ricesub + phoneall + cloth;
			 double totalbenefits = benefits;
			 
			 
			 //calculations of partial salary
			 double partialsal = totalhours + benefits;
			 
			 
			 // this section will be the salary deductions
			 int phealth = (int) (gross*0.03);
			 int pagibig = (int) (gross*0.04);
			 int totaldeduct = (int) (sss + phealth + pagibig);
			 int taxcal = (int) ((partialsal - totaldeduct)*.15);
			 double salary1= partialsal - taxcal;
			 double salary2 = salary1 - totaldeduct;
			 double finalpay = salary2;
			 
			 
			 
			//Output of total salary details
			 System.out.println("------------------------------------------------");
			 System.out.println("DEDUCTIONS             "+"           AMOUNT:");
			 System.out.println("SSS Contribution:                " + fields[19]);
			 System.out.println("Phil-Health:                     " + phealth);
			 System.out.println("Pag-ibig Contribution:           " + pagibig);
			 System.out.println("Total Deduction:                 " + totaldeduct);
			 System.out.println("------------------------------------------------");
			 System.out.println("Withholding tax:                 " + taxcal);
			 System.out.println("------------------------------------------------");
			 System.out.println("Net Pay:                         " + finalpay);
		
	}

	private static void displayEmployeeDetails(String[] fields) {
		
		// This section will be the Employee details
		System.out.println("==============================================");
    	System.out.println("             EMPLOYEE DETAILS:");
    	System.out.println("Employee Number: " + fields[0] + "\t\tBirthday: " + fields[3]);
    	System.out.println("First Name: " + fields[2] + "\t\tLast Name: " + fields[1]);
    	System.out.println("Address: " + fields[4]);
    	System.out.println("Phone Number: " + fields[5]);
    	System.out.println("\n==============================================");

    	System.out.println("EMPLOYEE IDENTIFICATION NUMBERS:");
    	System.out.println("SSS #: " + fields[6]);
    	System.out.println("Philhealth #: " + fields[7]);
    	System.out.println("TIN #: " + fields[8]);
    	System.out.println("Pag-ibig #: " + fields[9]);

    	System.out.println("\n===================================================");

    	System.out.println("JOB DETAILS:");
    	System.out.println("Status: " + fields[10]);
    	System.out.println("Position: " + fields[11]);
    	System.out.println("Immediate Supervisor: " + fields[12]);
    	System.out.println("\n===================================================");

        }
    }
