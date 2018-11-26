
import java.util.ArrayList;

public class Document {
	
	private static int classID = 0; 
	private int ID;
	
	private String author;
	private String title;
	private int pages;
	private String type;
	private int quantity;	
	
	public Document(String author, String title, int pages, String type, int quantity){
		this.author = author;
		this.title = title;
		this.pages = pages;
		this.type = type;
		this.quantity = quantity;
		
		ID = classID++; 
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void display(){
		System.out.println(ID + ".	" + title + "\n" + "	Author: "+ author + "\n" + "	Type: " + getType() + "\n" + "	Pages: " + pages + "\n");
	}
}