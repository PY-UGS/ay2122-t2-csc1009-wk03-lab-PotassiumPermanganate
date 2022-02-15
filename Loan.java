package com.T3;

import java.util.Date;
import java.util.Scanner;

public class Loan {

    private double annualInterestRate = 2.5;
    private double loanAmount = 1;
    private int numberOfYears = 1000;
    private Date loanDate;

    public Loan() {
       // default constructor
   }


    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        // pre-filled constructor
        this.setAnnualInterestRate(annualInterestRate);
        this.setNumberOfYears(numberOfYears);
        this.setLoanAmount(loanAmount);
    }

    public double getMonthlyPayment() {

        return (this.getLoanAmount() * (this.getAnnualInterestRate() / 1200)) / (1 - (1 / Math.pow((1 + this.getAnnualInterestRate() / 1200) , (this.getNumberOfYears() * 12))));

    }

    public double getTotalPayment() {

        return this.getMonthlyPayment()* this.getNumberOfYears() * 12;

    }


    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public static void main(String[] args) {

        double monthlyPayment, totalPayment;
        Scanner scanner = new Scanner(System.in);
        Loan loan = new Loan();

        System.out.print("Enter annual interest rate, for example, 8.25: ");
        loan.setAnnualInterestRate(scanner.nextDouble());

        System.out.print("Enter the number of years as an integer: ");
        loan.setNumberOfYears(scanner.nextInt());

        System.out.print("Enter loan amount, for example, 120000.95: ");
        loan.setLoanAmount(scanner.nextDouble());

        Date now = new Date();
        loan.setLoanDate(now);

        System.out.println("The loan was created on " + loan.getLoanDate());


        System.out.println("The monthly payment is " + String.format("%.02f", loan.getMonthlyPayment()));
        System.out.println("The total payment is " + String.format("%.02f", loan.getTotalPayment()));

    }
}
