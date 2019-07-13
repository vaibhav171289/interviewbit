package binarysearch;

import java.util.ArrayList;

public class Paint{
    public static long getMax(ArrayList<Integer> C, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(C.get(i) > max)
                max = C.get(i);
        }
        return max;
    }
    
    public static long getSum(ArrayList<Integer> C, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += C.get(i);
        }
        return total;
    }
    
    public static int getRequiredPainters(ArrayList<Integer> C, int n, int maxLengthPerPainter){
        int total = 0;
        int numPainters = 1;
        System.out.println("\t In get required painters maxLengthPerPainter: " + maxLengthPerPainter); 
        for(int i =0;i < n; i++){
            total += C.get(i);            
            if(total > maxLengthPerPainter){
                total = C.get(i);
                numPainters++;
            }
            
        }
        return numPainters;
    }
    public static long partition(ArrayList<Integer> C, int n, int k){
        long lo = getMax(C, n);
        System.out.println("Max = " + lo); 
        long hi = getSum(C, n);
        System.out.println("getSum = " + hi);
        while(lo < hi){
            int mid = (int)(lo + (hi-lo)/2);
            System.out.println("For Mid = " + mid +" \n lo = " + lo + "\n hi = " +  hi);
            int requiredPainters = getRequiredPainters(C, n, mid);
            System.out.println("\t required painters : " + requiredPainters);
            if(requiredPainters <= k) {                
                hi = mid;
                System.out.println("\t hi = " + hi);
            }
            else {                
                lo = mid + 1;
                System.out.println("\t lo = " + lo);
            }
        }
        return lo;
    }
    public static int paint(int A, int B, ArrayList<Integer> C) {
        return (int)(partition(C, C.size(), A) * B % 10000003);
    }
    
    
    
    public static void main(String[] args){
        int K = 1; // Number of painters
        int T = 3; // Time taken by painter to paint 1 unit of board
        ArrayList<Integer> C = new ArrayList<Integer>();
//        C.add(1000000);
//        C.add(1000000);
        C.add(1);
        /*C.add(2);
        C.add(3);
        C.add(4);
        C.add(5);*/
        C.add(6);/*
        C.add(7);
        C.add(800);
        C.add(900);*/
    
        
        System.out.println(paint(K, T, C));
    }
}