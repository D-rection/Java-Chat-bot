package Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Record 
{
	public String Time;
	public String Type;
	public String AdditionallyInformation;
	
	public Record(String type, String info)
	{
		Time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Type = type;
		AdditionallyInformation = info;
	}
	
	public String ToStringOnRecord()
	{
		return "|" + Time +" | " + Type + " | " + AdditionallyInformation + "|\n";
	}
}
