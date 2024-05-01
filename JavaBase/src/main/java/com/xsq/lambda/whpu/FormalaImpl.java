package src.com.xsq.lambda.whpu;

public class FormalaImpl implements IFormala {
    //1.显式实现
    @Override
    public double getResult(int a) {
        return a * a;
    }
}
