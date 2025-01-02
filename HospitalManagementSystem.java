package hospital.management;

import java.util.*;
public class HospitalManagementSystem
{
 public static void main(String[] args) 
 {
     System.out.println("Welcome to Hospital Management System\n");
     SystemManager systemManager = new SystemManager();
     systemManager.run();
 }
}


class Patient
{
 String id;
 String name;
 int age;
 String ailment;

 Patient(String id, String name, int age, String ailment)
 {
     this.id = id;
     this.name = name;
     this.age = age;
     this.ailment = ailment;
 }

 @Override
 public String toString()
 {
     return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment;
 }
}


class Appointment
{
 String appointmentId;
 String patientId;
 String doctorName;
 String date;
 String time;

 Appointment(String appointmentId, String patientId, String doctorName, String date, String time)
 {
     this.appointmentId = appointmentId;
     this.patientId = patientId;
     this.doctorName = doctorName;
     this.date = date;
     this.time = time;
 }

 @Override
 public String toString()
 {
     return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: " + doctorName + ", Date: " + date + ", Time: " + time;
 }
}


class MedicalSupply {
 String supplyName;
 int quantity;

 MedicalSupply(String supplyName, int quantity)
 {
     this.supplyName = supplyName;
     this.quantity = quantity;
 }

 @Override
 public String toString()
 {
     return "Supply: " + supplyName + ", Quantity: " + quantity;
 }
}


class SystemManager 
{
 Scanner scanner = new Scanner(System.in);
 List<Patient> patients = new ArrayList<>();
 List<Appointment> appointments = new ArrayList<>();
 List<MedicalSupply> supplies = new ArrayList<>();

 void run() 
 {
     while (true)
     {
         System.out.println("\n1. Register Patient");
         System.out.println("2. Schedule Appointment");
         System.out.println("3. Manage Medical Supplies");
         System.out.println("4. View All Patients");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");

         int choice = scanner.nextInt();
         scanner.nextLine(); 

         switch (choice) 
         {
             case 1 -> registerPatient();
             case 2 -> scheduleAppointment();
             case 3 -> manageSupplies();
             case 4 -> viewPatients();
             case 5 -> {
                 System.out.println("Exiting... Goodbye!");
                 return;
             }
             default -> System.out.println("Invalid choice. Please try again.");
         }
     }
 }

 void registerPatient() 
 {
     System.out.print("Enter Patient ID: ");
     String id = scanner.nextLine();
     System.out.print("Enter Patient Name: ");
     String name = scanner.nextLine();
     System.out.print("Enter Patient Age: ");
     int age = scanner.nextInt();
     scanner.nextLine();
     System.out.print("Enter Patient Ailment: ");
     String ailment = scanner.nextLine();

     patients.add(new Patient(id, name, age, ailment));
     System.out.println("Patient registered successfully.");
 }

 void scheduleAppointment() 
 {
     System.out.print("Enter Appointment ID: ");
     String appointmentId = scanner.nextLine();
     System.out.print("Enter Patient ID: ");
     String patientId = scanner.nextLine();
     System.out.print("Enter Doctor Name: ");
     String doctorName = scanner.nextLine();
     System.out.print("Enter Appointment Date (DD/MM/YYYY): ");
     String date = scanner.nextLine();
     System.out.print("Enter Appointment Time (HH:MM): ");
     String time = scanner.nextLine();

     appointments.add(new Appointment(appointmentId, patientId, doctorName, date, time));
     System.out.println("Appointment scheduled successfully.");
 }

 void manageSupplies() {
     System.out.print("Enter Supply Name: ");
     String supplyName = scanner.nextLine();
     System.out.print("Enter Quantity: ");
     int quantity = scanner.nextInt();
     scanner.nextLine();

     supplies.add(new MedicalSupply(supplyName, quantity));
     System.out.println("Supply added successfully.");
 }

 void viewPatients() 
 {
     if (patients.isEmpty()) 
     {
         System.out.println("No patients registered yet.");
     } 
     else
     {
         System.out.println("\nRegistered Patients:");
         for (Patient patient : patients)
         {
             System.out.println(patient);
         }
     }
 }
}