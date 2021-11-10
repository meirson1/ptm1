package test;
import org.jetbrains.annotations.NotNull;

import java.lang.Math;
import java.util.Formatter;

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
        return avg(x2)-u2;
    }

    // returns the covariance of X and Y
    public static float cov(float[] x, float[] y) {
        float Uxy=var(x)*var(y);//By formula
        Uxy=(float) Math.sqrt(Uxy);//Needed to get root
        return Uxy;
    }


    // returns the Pearson correlation coefficient of X and Y
    public static float pearson(float[] x, float[] y) {
        float sigmaxMy=(float) Math.sqrt(var(x))*(float) Math.sqrt(var(y));//sigma of x multiply by sigma of y
        return  (cov(x, y)) / (sigmaxMy);//By formula
    }

    // performs a linear regression and returns the line equation
    public static Line linear_reg(Point[] points) {
        float[] x=new float[points.length];//list of x
        float[] y=new float[points.length];//list of y
        for (int i=0;i<x.length;i++){//Put the variable of the points in x and y
            x[i]=points[i].x;
            y[i]=points[i].y;
        }
        float a=cov(x,y)/var(x);//Find Incline
        float b=avg(y)-a*avg(x);//Find b
        return new Line(a,b);//return new line
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
