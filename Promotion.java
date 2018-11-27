
public class Promotion {

	private int id;
	private String startDate;
	private String endDate;
	private String description;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(int day, int month, int year) {
		startDate = "";
		startDate += day + "/" + month + "/" + year;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(int day, int month, int year) {
		endDate = "";
		endDate += day + "/" + month + "/" + year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	public int getID(){
		return id;
	}
	
	public void display(){
		System.out.println("ID: " + id + "\n" + "Promotion: " + description + "\n" + "Start date" + startDate + "\n" + "End date: " + endDate);
	}
	
}
