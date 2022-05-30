package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateTriangles {
    public static Triangle generateTriangle(){
        Random rand = new Random();
        Triangle tr;
        double a = 0,b=0,c=0;
        boolean flag = false;
        while(!flag){
            a = rand.nextDouble(15);
            b = rand.nextDouble(15);
            c = rand.nextDouble(15);
            flag = checkTriangle(a,b,c);
        }
        if(flag){
            return new Triangle(a,b,c);
        }
        System.out.println("No triangle generated");
        return null;

    }

    public static SquareTriangle generateSquareTriangle(){
        Random rand = new Random();
        double a,b,c;
        SquareTriangle sqTr;
        a = rand.nextDouble(15);
        b = rand.nextDouble(15);
        c = Math.sqrt((a*a+b*b));
        boolean flag = checkSquareTriangle(a,b,c);
        if(flag){
            return new SquareTriangle(a,b,c);
        }
        return null;
    }

    public static boolean checkTriangle(@NotNull Triangle tr){
        if (tr.getA() + tr.getC() > tr.getB() || tr.getC() + tr.getB() > tr.getA()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkTriangle(double a, double b, double c){
        if (a + c > b || c + b > a) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSquareTriangle(@NotNull SquareTriangle sqTr){
        if(sqTr.getA() *sqTr.getA()+sqTr.getB()*sqTr.getB() == sqTr.getC()*sqTr.getC()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean checkSquareTriangle(double a, double b, double c){
        var trSet = Stream.of(a,b,c).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        double check = 0.0;
        trSet.set(0, Math.floor(Math.pow(trSet.get(0),2)*100)/100);
        for(int i = 1; i<trSet.size();i++){
            check += Math.pow(trSet.get(i),2);
        }
        check = Math.floor(check*100)/100;
        if(trSet.get(0) == check){
            return true;
        } else{
            return false;
        }
    }
}
