public class Order{
    private ArrayList<Document> items;
    private String name;
    private String cardInfo;
    private String address;

    public void setItems(ArrayList<Documents> items){
        this.items = items;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCardInfo(String cardInfo){
        this.cardInfo = cardInfo;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getCardInfo(){
        return cardInfo;
    }

    public String getAddress(){
        return address;
    }
}
