
import java.util.ArrayList;

public abstract class Document {

	private String author;
	private String title;
	private int pages;
	private ArrayList<String> genre;
	private int quantity;
	
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
	public String getGenre() {
		String genres = "";
		for(int i = 0; i < genre.size(); i++){
			genres += genre.get(i);
			genres += "\n";
		}
		return genres;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void display(){
		System.out.print("Title: " + title + "\n" + "Author: "+ author + "\n" + "Genre: " + getGenre() + "\n" + "Page: " + pages);
	}
	
}
