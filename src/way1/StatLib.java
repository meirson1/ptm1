package way1;


public class StatLib {

	

	// simple average
	public static float avg(float[] x) {
		int sum = 0;
		int i = 1;
		for (i = 1; i <= x.length; i++) {
			sum += x[i];
		}
		sum = sum / i;
		return sum;
	}

	// returns the variance of X and Y
	public static float var(float[] x){
		return 0;
	}

	// returns the covariance of X and Y
	public static float cov(float[] x, float[] y){

		return 0;
	}


	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y){
		return 0;
	}

	// performs a linear regression and returns the line equation
	public static Line linear_reg(Point[] points){
		int x=5;
		return null;
	}

	// returns the deviation between point p and the line equation of the points
	public static float dev(Point p,Point[] points){
		return 0;
	}

	// returns the deviation between point p and the line
	public static float dev(Point p,Line l){
		return 0;
	}
	
}
