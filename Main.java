package com.company;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        TriangleLinkedList trList = new TriangleLinkedList();
        TriangleLinkedList sqTrList = new TriangleLinkedList();
        int n,m = 0;
        BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Enter N: ");
            String str = con.readLine();
            System.out.println("Enter M: ");
            String str2 = con.readLine();
            n = Integer.parseInt(str);
            m = Integer.parseInt(str2);
        }catch(NumberFormatException e){
            System.out.println(e);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for(int i = 0; i<n;i++){
            trList.add(GenerateTriangles.generateTriangle());
            if(trList.getLast() == null){
            }
        }
        for(int i = 0;i<m;i++){
            sqTrList.add(GenerateTriangles.generateSquareTriangle());
            if(trList.getLast() == null){
            }
        }
        var squares = trList.stream().map(x -> x.getSquare()).collect(Collectors.toList());
        squares.addAll(sqTrList.stream().map(x -> x.getSquare()).collect(Collectors.toList()));
        squares.stream().forEach(x -> System.out.println(x));
        double max = squares.stream().max(Double::compare).get();
        System.out.println("Max square is: "+max);
        var gipoMin = sqTrList.stream().map(x -> {
            if(x.getA() > x.getB() && x.getA() > x.getC()){
                return x.getA();
            } else if(x.getB()>x.getA() && x.getB() > x.getC()){
                return x.getB();
            } else{
                return x.getC();
            }
        }).collect(Collectors.toList()).stream().sorted(Comparator.naturalOrder()).findFirst().get();
        System.out.println("Min gipotenuza is: "+Math.floor(gipoMin*100)/100);
    }
}

