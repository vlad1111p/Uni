import java.util.ArrayList;
import java.util.ListIterator;


public class Monitor {

	ArrayList<Dataset> ds = new ArrayList<>();
	ArrayList<Trigger> triggers = new ArrayList<>();
	ArrayList<Alert> alerts = new ArrayList<>();
	
	public void report(Dataset dataset) {
		ds.add(dataset);
		trigger(ds);
	}
	
	public void addTrigger(DeltaTrigger dTrigger) {
		triggers.add(dTrigger);
	}
	
	public void addTrigger(AboveTrigger aTrigger) {
		triggers.add(aTrigger);
	}
	
	public void addAlert(TextAlert tAlert) {
		alerts.add(tAlert);
	}
	
	public void addAlert(EmailAlert mAlert) {
		alerts.add(mAlert);
	}
	public void trigger (ArrayList<Dataset> dataset) {
		ListIterator<Trigger> itr=triggers.listIterator(0);
		boolean alert=false;
		
		if (triggers.size()>1) {
			while(itr.hasNext()&&alert==false) {
				alert=itr.next().trigger(dataset); // das hier ist nicht die methode trigger aus monitor, sondern der aus dem interface trigger
				
			}
		}
		if (triggers.size()==1) {
			alert=triggers.get(0).trigger(dataset);
		}
		if (alert==true) {
			alert(dataset.get(dataset.size()-1));
		}
	}
	
	public void alert(Dataset dataset) {
		ListIterator<Alert> itr=alerts.listIterator(0);
		do {
			itr.next().alert(dataset); //Wie bei trigger
		}while(itr.hasNext());
	}
}

class Dataset {
	long timestamp;
	double value;
	
	Dataset(long timestamp, double value) {
		this.timestamp=timestamp;
		this.value=Math.round(100*value)/100.0;
		
	}
}

interface Trigger {
	boolean trigger(ArrayList<Dataset> dataset);
}

class AboveTrigger implements Trigger {
	double bound;
		
	AboveTrigger(double bound) {
		this.bound=bound;
	}
	
	public boolean trigger(ArrayList<Dataset> dataset) {
		if (dataset.get(dataset.size()-1).value>bound) {
			return true;
		}
		return false;
	}
	
}

class DeltaTrigger implements Trigger {
	long t;
	double maxChange;
	
	DeltaTrigger(long t, double maxChange) {
		this.t=t;
		this.maxChange=maxChange;
	}
	
	public boolean trigger(ArrayList<Dataset> dataset) {
		ListIterator<Dataset> itr=dataset.listIterator(dataset.size()-1);
		ListIterator<Dataset> itr2=dataset.listIterator(dataset.size()-1);
		long difft=0;
		double diffv=0;
		
		while(itr.hasPrevious() && difft < t && Math.abs(diffv)<maxChange) {
			difft=dataset.get(dataset.size()-1).timestamp - itr.previous().timestamp;
			diffv=dataset.get(dataset.size()-1).value - itr2.previous().value;

		}

		boolean test=itr.hasPrevious();

		if (test==true && Math.abs(diffv)<=maxChange && difft<t) {

			difft=dataset.get(dataset.size()-1).timestamp - dataset.get(0).timestamp;
			diffv=dataset.get(dataset.size()-1).value - dataset.get(0).value;

		}

		if (Math.abs(diffv)>maxChange) {

			return true;
		}
		
		
		return false;
	}
}

interface Alert {
	void alert(Dataset dataset);
}

class TextAlert implements Alert {
	String message;
	
	TextAlert(String message) {
		this.message=message;
	}
	
	public void alert(Dataset dataset) {
		String s=message;
		String value=String.format("%.2f", dataset.value);
		value=value.replace(",", ".");
		s = s.replace("%t", "" + dataset.timestamp);
        s = s.replace("%v", "" + value);
        System.out.println(s);
	}
}

class EmailAlert implements Alert{
	String email;
	String message;
	
	EmailAlert(String email, String message) {
		this.email=email;
		this.message=message;
	}
	
	public void alert(Dataset dataset) {
		String s=message;
		String value=String.format("%.2f", dataset.value);
		value=value.replace(",", ".");
		s = s.replace("%t", "" + dataset.timestamp);
        s = s.replace("%v", "" + value);
        System.out.println(email);
        System.out.println(s);
	}
}