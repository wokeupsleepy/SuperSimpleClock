package clocklogic;

import java.util.Calendar;

public class PrimeClock {
	
	private Calendar timeSource = Calendar.getInstance();
	private int currHour = timeSource.get(Calendar.HOUR_OF_DAY);
	private int currMin = timeSource.get(Calendar.MINUTE);
	private int currSec = timeSource.get(Calendar.SECOND);
	
	public int getCurrHour() {
		return currHour;
	}
	public int getCurrMin() {
		return currMin;
	}
	public int getCurrSec() {
		return currSec;
	}
	
	

}
