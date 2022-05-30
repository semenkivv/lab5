package com.company;

public class Triangle {
    private double a, b, c;
    private boolean numbersFlag;
    private String numbersCheckMsgError = "Wrong numbers";

    public Triangle(){}

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        checkNumbers();
    }

    public boolean checkNumbers() {
        if (a + c > b || c + b > a) {
            numbersFlag = true;
            return true;
        } else {
            System.out.println("Sum of two sides of triangle lesser than third");
            numbersFlag = false;
            return false;
        }
    }

    private void showNumbersError() {
        System.out.println(numbersCheckMsgError);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getAngleAB() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos(((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
        return result;
    }

    public double getAngleBC() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        return result;
    }

    public double getAngleCA() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos((Math.pow(c, 2) + Math.pow(a, 2) - Math.pow(b, 2)) / (2 * c * a));
        return result;
    }

    public double getPerimeter() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        return a + b + c;
    }

    public double getSquare() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double p = getPerimeter();
        return Math.floor(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100)/100;
    }
}
