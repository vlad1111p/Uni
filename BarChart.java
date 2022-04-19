
public class BarChart {

	public static void main(String[] args) {
		
		double gap=0.0;
		double width=0.0;

	    if (args.length>=2) {
			gap = Double.parseDouble(args[0]);
			width = Double.parseDouble(args[1]);
	    }

		StdDraw.line(0.0, 0.1, 1.0, 0.1);
		
		String[] values= readStrings();
		
		String[] labels = new String[values.length/2];
		double[] heights = new double[values.length/2];
		
		int v=0;
		int n=0;
		
		while (v<values.length) {
			labels[n]=values[v];			
			n=n+1;
			v=v+2;
		}
		
		v=1;
		n=0;
		
		while (v<values.length) {
			heights[n]=Double.parseDouble(values[v]);			
			n=n+1;
			v=v+2;
		}
		
		if (args.length <=1) {
			drawBars(labels, heights);	
		}
		
		if (args.length >=2) {
			drawBars(labels, heights, width, gap);	
		}
		
	
		
	}
	
    public static void drawBar(double x, double width, String text, double height) {
        double y=0.0;
        y=(height/2)+0.1;
    	StdDraw.filledRectangle(x, y, width/2, height/2);
    	StdDraw.text(x, 0.05, text);
    }
    
    public static void drawBars(String[] labels, double[] heights, double width, double gap) {
    	double max=0.0;
    	
    	for (int i=0; i<heights.length; i++) {
    		if (heights[i]>max) {
    			max=heights[i];
    		}
    	}
    	
    	double factor=0.8/max;
    	
    	for (int i=0; i<heights.length; i++) {
    		heights[i]=heights[i]*factor;
    	}
    	
    	for (int i=0; i<heights.length; i++) {    		
    		drawBar(0.2+(i*(gap+width)), width, labels[i], heights[i]);    		
    	}
    }
    
    public static void drawBars(String[] labels, double[] heights) {
    	
    	int amount=heights.length;
    	double width=0.0;
    	double gap=0.0;
    	
    	double maxsize=0.8/amount;
    	gap=maxsize/2;
    	width=maxsize/2;
    	
    	drawBars(labels, heights, width, gap);
    }
    
    
    public static String[] readStrings() {
    	int i = 0;
    	String[] a = new String[0];
    	String[] b = new String[0];
		while (!StdIn.isEmpty()) {
			if (a.length <= i) {
				b = new String[a.length+2];
				for (int z = 0; z < a.length; z++) {
					b[z] = a[z];
				}
				a = new String[b.length];
				for (int z = 0; z < a.length-1; z++) {
					a[z] = b[z];
				}
			}
			String s = StdIn.readString();
			a[i] = s;
			String t = StdIn.readString();
			a[i+1]=t;
			i=i+2;
		}
      return a;
    }

}
