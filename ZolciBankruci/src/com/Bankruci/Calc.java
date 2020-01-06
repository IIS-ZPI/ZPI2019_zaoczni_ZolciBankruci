package com.Bankruci;

public class Calc implements IArithmeticsDiv, IArithmeticsAdd, IArithmeticsMult, IArithmeticsDiff {
  
    @Override
    public double Difference(double A, double B) {
        return A - B;
    }
  
    @Override
    public double Division(double A, double B) {
        return A / B;//dzielonko
    }
  
    @Override
    public double Addition(double A, double B) {
        return A + B;
    }
  
    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }
}
