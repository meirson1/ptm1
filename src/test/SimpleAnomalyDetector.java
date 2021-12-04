package test;
import java.util.ArrayList;
import java.util.List;
public class SimpleAnomalyDetector implements TimeSeriesAnomalyDetector {

	List<CorrelatedFeatures> CF=new ArrayList<CorrelatedFeatures>();

	@Override
	public void learnNormal(TimeSeries ts) {
		float SendPearsonCorrelated;
		CorrelatedFeatures c=null;
		for (int i = 1; i <= ts.HM.size(); i++) {
			SendPearsonCorrelated=(float) 0.9;
			for (int j = i + 1; j <= ts.HM.size(); j++) {
				float f1[]=ts.HM.get(Character.toString((char) (i + 64)));
				float f2[]=ts.HM.get(Character.toString((char) (j+64)));
				if (Math.abs(StatLib.pearson(f1,f2)) >SendPearsonCorrelated) {
					SendPearsonCorrelated = Math.abs(StatLib.pearson(f1,f2));
					Line line=StatLib.linear_reg(f1,f2);
					float MaxThresHold=this.CheckMaxThresHold(line,f1,f2)*(float)1.1;
					c=new CorrelatedFeatures(String.valueOf((char)(i+64)),String.valueOf((char)(j+64)),SendPearsonCorrelated,line,MaxThresHold);
				}

			}
			if (this.CF==null)
				this.CF=new ArrayList<CorrelatedFeatures>();
			if (SendPearsonCorrelated>0.9)
				CF.add(c);
		}

	}

	private float CheckMaxThresHold(Line line, float[] f1, float[] f2) {
		float MaxThresHold=0;
		for (int k = 0; k < 100; k++) {
			Point point = new Point(f1[k], f2[k]);
			float ThresHold = StatLib.dev(point, line);//check max threshold
			if (MaxThresHold < ThresHold)
				MaxThresHold = ThresHold;
		}
		return MaxThresHold;
	}


	@Override
	public List<AnomalyReport> detect(TimeSeries ts) {

		return null;
	}
	
	public List<CorrelatedFeatures> getNormalModel(){
		return CF;
	}
}
