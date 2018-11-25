
public interface Subject {

	public void register(Observer obs);
	public void remove(Observer obs);
	public void notifyObserver();
	
}
