package motorPH;

import java.io.File;
import java.io.FileNotFoundException; //signals the program IF the attempt of opening the file path has failed
import java.time.LocalDate; //tools to work with dates (used in Total Working Hours Calculations)
import java.time.format.DateTimeFormatter; //used to format dates
import java.util.Scanner;

public class MotorPH {

    public static void main(String[] args) {
        File csv = new File("C:\\Users\\vvele\\eclipse-workspace\\motorPH\\csv\\5th CSV File - Employee Details (2).csv");
        File csv1 = new File("C:\\Users\\vvele\\eclipse-workspace\\mtrph\\finalcsvfile\\Attendance Record.csv");
        System.out.println("      =Welcome to MotorPH Portal=      ");
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the employee number: ");
        String employeeNumber = scan.nextLine();

        try {
            Scanner scanner = new Scanner(csv); //this line creates a new Scanner object named scanner to read from the CSV file (csv)
            boolean foundEmployee = false; //used to track whether the employee with the specified employee number is found in the CSV file

            while (scanner.hasNextLine()) { //starts a while loop that continues as long as there are more lines to read from the csv file
                String line = scanner.nextLine(); //skips the header of the CSV File
                String[] fields = line.split(","); //used to separate values(the fields) using comma

                if (fields.length > 0 && fields[0].equals(employeeNumber)) { //if the length of field is greater than 0 and field 0 is equals to employee number
                    foundEmployee = true; //then the system will initialize that they had foundEmployee
                    displayEmployeeDetails(fields); //for method to display employee details
                    displayTimeinout(fields, scan, scanner, csv1, employeeNumber, csv);

//                    calculateSalary(fields);
                    break; //exits the while loop once the employee is found & displayed
                }
            }
            if (!foundEmployee) {
                System.out.println("Employee not found!");
                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


	private static void displayTimeinout(String[] fields,Scanner scan, Scanner scanner, File csv1, String employeeNumber, File csv) {
		
		System.out.print("Enter the month (MM/yyyy): ");
        String inputMonth = scan.nextLine();
        LocalDate monthStart = LocalDate.parse("01/" + inputMonth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate monthEnd = monthStart.plusMonths(1).minusDays(1);

        float totalWorkingHours = 0;

        try {
        scanner = new Scanner(csv1); //can be replaced with another csv file

        System.out.println("--------------------------------------------------");
        System.out.println("    Date     | Time In | Time Out | Working Hours");
        System.out.println("--------------------------------------------------");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] attendanceFields = line.split(","); // Separate fields for attendance record

            if (attendanceFields.length > 0 && attendanceFields[0].equals(employeeNumber)) {
                LocalDate recordDate = LocalDate.parse(attendanceFields[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                if (!recordDate.isBefore(monthStart) && !recordDate.isAfter(monthEnd)) {

                    // Calculate working hours from attendance record fields
                    float workingHours = calculateWorkingHours(attendanceFields[2], attendanceFields[3]);
                    totalWorkingHours += workingHours;

                    // Display attendance record
                    System.out.printf("%s   | %s   | %s   | %.2f%n", recordDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), attendanceFields[2], attendanceFields[3], workingHours);
                }
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total Working Hours: " + totalWorkingHours);
        
        calculateSalary(fields, csv, totalWorkingHours);
        
        System.out.println();
        System.out.println("===================================================");
        
        
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    	}
	}
		

	private static void displayEmployeeDetails(String[] fields) {
        System.out.println("\n===================================================");
        System.out.println("             EMPLOYEE DETAILS:");
        System.out.println("Employee Number: " + fields[0] + "\t\tBirthday: " + fields[3]);
        System.out.println("First Name: " + fields[2] + "\t\tLast Name: " + fields[1]);
        System.out.println("\nAddress: " + fields[4]);
        System.out.println("Phone Number: " + fields[5]);
        System.out.println("\n===================================================");
        System.out.println("EMPLOYEE IDENTIFICATION NUMBERS:");
        System.out.println("SSS #: " + fields[6] + "\t\tPhilhealth #: " + fields[7]);
        System.out.println("TIN #: " + fields[8]+ "\t\tPag-ibig #: " + fields[9]);
        System.out.println("\n===================================================");
        System.out.println("JOB DETAILS:");
        System.out.println("Status: " + fields[10]);
        System.out.println("Position: " + fields[11]);
        System.out.println("Immediate Supervisor: " + fields[12]);
        System.out.println("\n===================================================");
    }

    private static float calculateWorkingHours(String timeIn, String timeOut) {
        String[] timeInParts = timeIn.split(":");
        String[] timeOutParts = timeOut.split(":");
        int inHours = Integer.parseInt(timeInParts[0]);
        int inMinutes = Integer.parseInt(timeInParts[1]);
        int outHours = Integer.parseInt(timeOutParts[0]);
        int outMinutes = Integer.parseInt(timeOutParts[1]);
        int totalMinutes = (outHours * 60 + outMinutes) - (inHours * 60 + inMinutes);
        
        // Adjust totalMinutes to consider -1 hour if the difference is greater than 0 for the lunch break of Employee :D
        if (totalMinutes > 0) {
            totalMinutes -= 60;
        }
        
        float totalWorkingHours = totalMinutes / 60.0f;
        return totalWorkingHours;
        
    	}   
    private static void calculateSalary(String[] fields, File csv, float totalWorkingHours) {

        System.out.println("SALARY DETAILS: ");
        System.out.println();
        System.out.println("Basic Salary: " +fields[13]);
    	
    	double basicSalary = Double.parseDouble(fields[13]);
        double hourly_rate = Double.parseDouble(fields[18]);
        double ricesub = Double.parseDouble(fields[14]);
        double phone = Double.parseDouble(fields[15]);
        double cloth = Double.parseDouble(fields[16]);
        double sss = Double.parseDouble(fields[19]);
        double gross = Double.parseDouble(fields[17]);

        double premiumRate = basicSalary *0.03;
        double philHealth = premiumRate / 2;
        

        
        double pagIbig = 0; // Initialize pagIbig variable
        if (basicSalary >= 1000 && basicSalary <= 1500) {
            double employeeCR = basicSalary * 0.01;
            double employersCR = basicSalary * 0.02;
            double total = employeeCR + employersCR;
            
            if (total > 100) {
                total = 100;
            }
            pagIbig = total; // Assign pagIbig value
            System.out.println("Pag-IBIG Deductions: " + pagIbig);
        } else if (basicSalary > 1500) {
            double employeeCR1 = basicSalary * 0.02;
            double employersCR1 = basicSalary * 0.02;
            double total1 = employeeCR1 + employersCR1;

            if (total1 > 100) {
                total1 = 100;
            }
            pagIbig = total1; //okay pa ko di pa naman sumasakit ulo ko :D
            System.out.println("Pag-IBIG Deductions: " + pagIbig);
        }
        System.out.println("SSS Deductions: "+ sss);

        double totalDeductions = sss + philHealth + pagIbig;
        
        System.out.println("PhilHealth Deductions: "+ philHealth);
        System.out.println("Total Deductions: "+ totalDeductions);

        
        double taxableIncome = basicSalary - totalDeductions;
        
        
        if(basicSalary <=20832) {
        System.out.println("No Withholding Tax");
        }
        else if(basicSalary >=20833 && basicSalary <=33333) {
        double calc = taxableIncome-20833;
        double calc2 = calc*0.2;
        System.out.println("Withholding Tax: "+ calc2);
        }
        else if(basicSalary >=33333 && basicSalary <= 66667) {
        double calc3 = taxableIncome-33333;
        double calc4 = calc3*0.25;
        double totalcalc = calc4+2500;
        System.out.println("Withholding Tax: "+ totalcalc);
        }
        else if(basicSalary >=66667 && basicSalary <= 166667) {
            double calc5 = taxableIncome-66667;
            double calc6 = calc5*0.30; 
            double totalcalc1 = calc6+10833;
            System.out.println("Withholding Tax: "+ totalcalc1);
        }
        else if(basicSalary >=166667 && basicSalary <= 666667) {
            double calc7 = taxableIncome-40833;
            double calc8 = calc7*0.32; 
            double totalcalc2 = calc8+40833;
            System.out.println("Withholding Tax: "+ totalcalc2);
        }
        else if(basicSalary >666667) {
            double calc9 = taxableIncome-200833;
            double calc10 = calc9*0.35; 
            double totalcalc3 = calc10+40833;
            System.out.println("Withholding Tax: "+ totalcalc3);  
        }
        
        System.out.print("Taxable Income: "+taxableIncome);
        System.out.println();
        System.out.println("===================================================");
        System.out.println("GROSS PAY AND NET PAY: ");
        System.out.println();
    	double grossPay = hourly_rate * totalWorkingHours; //
		double netPay = grossPay - totalDeductions; 
		
		String formattedGrossPay = String.format("%.2f", grossPay);
		String formattedNetPay = String.format("%.2f", netPay);

		System.out.println("Gross Pay: " + formattedGrossPay);
		System.out.println("Net Pay: " + formattedNetPay);
    }
}
