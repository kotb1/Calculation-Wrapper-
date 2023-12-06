package Calculaution;

public class CalculationWrapper {

    private final ICalculation calculation;

    public CalculationWrapper(ICalculation calc) {
        calculation = calc;
    }

    public int findMinimum(int arr[]) {
        try {
            //calculation.findMin(arr);
            int min = calculation.findMin(arr);
            return min - 10;
        } catch (Exception e) {

            return Integer.MIN_VALUE;
        }
    }
}
