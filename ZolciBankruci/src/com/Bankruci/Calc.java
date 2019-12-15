package com.Bankruci;

public class Calc implements IArithmeticsDiv, IArithmeticsAdd, IArithmeticsMult {

    @Override
    public double Division(double A, double B) {
        return A/B;
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
