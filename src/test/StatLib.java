package test;
import org.jetbrains.annotations.NotNull;

import java.lang.Math;

public class StatLib {


    // simple average
    @org.jetbrains.annotations.Contract(pure = true)
    public static float avg(float @NotNull [] x) {
        float sum = 0;
        int i = 0;
        for (i = 0; i < x.length; i++) {
            sum += x[i];
        }
        sum /= i;
        return sum;
    }

    // returns the variance of X and Y
    public static float var(float[] x) {
        float u=avg(x);//By formula u=avg
        float[] x2=new float[x.length];//creating new list of x^2 to prevent lost of data original x.
        for (int i=0;i<x2.length;i++){
            x2[i]=x[i];
        }
        for (int i=0;i<x.length;i++) {//By the formula of x^2
            x2[i]= (float) Math.pow(x2[i],2);
        }
        float u2= (float) Math.pow(u,2);//by formula u^2
        return avg(x)-u2;
    }

    // returns the covariance of X and Y
    public static float cov(float[] x, float[] y) {
        float Uxy=avg(x)*avg(y);//By formula u=avg.Ux*Uy
        float[] xy=new float[x.length+y.length];//creating new list of x and y variables
        for (int i=0;i<x.length;i++) {//insert x variables
            xy[i] = x[i];
        }
        for (int i=x.length;i<x.length+y.length;i++){//insert y variables
            xy[i]=y[i-x.length];
        }
        return var(x)-Uxy;//By formula
    }


    // returns the Pearson correlation coefficient of X and Y
    public static float pearson(float[] x, float[] y) {
        float sigmaxMy=(float) Math.pow(var(x),(1/2))*(float) Math.pow(var(y),(1/2));//sigma of x multiply by sigma of y
        return  (cov(x, y)) / (sigmaxMy);//By formula
    }

    // performs a linear regression and returns the line equation
    public static Line linear_reg(Point[] points) {
        return null;
    }

    // returns the deviation between point p and the line equation of the points
    public static float dev(Point p, Point[] points) {
        return 0;
    }

    // returns the deviation between point p and the line
    public static float dev(Point p, Line l) {
        return 0;
    }

}
