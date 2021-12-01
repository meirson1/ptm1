package test;
import java.util.ArrayList;
import java.util.List;
public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {

	List<CorrelatedFeatures> CF=new ArrayList<CorrelatedFeatures>();

	@Override
	public void learnNormal(TimeSeries ts) {
		float thresHold=0;
		float y;
		float max=0;
		Point[] p = new Point[100];
		for (int i = 1; i <= 4; i++) {
			for (int j = i + 1; j <= 4; j++) {
				y=Math.abs(StatLib.pearson(ts.HM.get((char) (i+64)),ts.HM.get((char)(j+64))));
				for (int s = 0; s < 100; s++)
					p[s] = new Point(ts.HM.get((char) (i + 64))[s], ts.HM.get((char) (j + 64))[s]);//use dev for threshold
				Line lin=StatLib.linear_reg(p);
				for (int s=0;s<100;s++){
					thresHold=StatLib.dev(p[i],lin);
					if (thresHold>max)
						max=thresHold;
				}
				//thresHold = thresHolder(ts.HM.get((char) (i + 64)), ts.HM.get((char) (j + 64)), StatLib.linear_reg(p));
				CF.add(new CorrelatedFeatures(String.valueOf((char) (i + 64)), String.valueOf((char) (j + 64)), y, StatLib.linear_reg(p), thresHold));
			}
		}
	}

	private float thresHolder(float[] x, float[] y, Line line) {
		float max=0;
		float check;
		for (int i=0;i<x.length;i++){
			for (int j=0;j<y.length;j++){
				check=Math.abs(2);
				if (check>max)
					max=check;
			}
		}
		return max;
	}


	@Override
	public List<AnomalyReport> detect(TimeSeries ts) {

		return null;
	}
	
	public List<CorrelatedFeatures> getNormalModel(){
		return CF;
	}
}
