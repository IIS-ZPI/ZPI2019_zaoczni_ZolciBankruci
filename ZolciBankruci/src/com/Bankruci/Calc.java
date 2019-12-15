package com.Bankruci;

public class Calc implements IArithmeticsDiv, IArithmeticsAdd{

    @Override
    public double Division(double A, double B) {
        return A/B;
    }
  
    @Override
    public double Addition(double A, double B) {
        return A + B;
    }
}
