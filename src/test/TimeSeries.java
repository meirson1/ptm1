package test;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TimeSeries {

	HashMap<String, ArrayList<Float>> HM= new HashMap <String, ArrayList<Float>>();

	public TimeSeries(String csvFileName) {
		int i;
		float[] a=new float[100];
		float[] b=new float[100];
		float[] c=new float[100];
		float[] d=new float[100];

		String line="";
		BufferedReader lineRead=null;
		try{
			lineRead=new BufferedReader(new FileReader(csvFileName));
			line=lineRead.readLine();
			String []check=line.split(",");
			for (String str:check) {
				HM.put(str, new ArrayList<Float>());
			}
			while ((line=lineRead.readLine())!=null){
				String[] row=line.split(",");
				for ( i=0;i<check.length;i++) {
					//HM.put(HM.get(check[i]),HM.get(check[i]).add(Float.parseFloat(row[i])));
					HM.get(check[i]).add(Float.parseFloat(row[i]));
				}
				//for (i=0;i<4;i++) {
					//for (int k = 0; k < ; k++) {

					//}
					/*switch (i) {
						case 0:
							a[k]=Float.parseFloat(row[i]);
							break;
						case 1:
							b[k]=Float.parseFloat(row[i]);
							break;
						case 2:
							c[k]=Float.parseFloat(row[i]);
						case 3:
							d[k]=Float.parseFloat(row[i]);
						default:
							break;
					}*/
				//}
			}
//			HM.put("A",a);
//			HM.put("B",b);
//			HM.put("C",c);
//			HM.put("D",d);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				lineRead.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
