import ls.java.menu.LSMenu;

public class Wegman extends Store{
	int payed;
	String bought;
	boolean shopping;
	static int choice;
	String[][] itemList;
	public Wegman() {
		super("Wegman");
	}
	public void script(Shopper theShopper) {
		System.out.println("YOU MADE IT TO WEGMANS. WAY TO GO MAN!!");
		shopping = true;
		while(shopping == true){
			Item bananas = new Item("bananas", 1, "Wegmans");
			Item cereal = new Item("cereal", 500, "Wegmans");
			Item bag = new Item("bag", 5, "Wegmans");
			Item salad = new Item("salad", 20, "Wegmans");
			Item[] itemList = {bananas, cereal, bag, salad};
			LSMenu myMenu = new LSMenu("Choose one:");
			for(int i=0; i<itemList.length; i++) {
				String addMe = itemList[i].name;
				myMenu.addItem(addMe);
			}
			myMenu.addItem("B");
			myMenu.addItem("L");
			myMenu.addItem("exit");
			try {
				choice = myMenu.displayAndChoose();
				System.out.println(choice);
			}catch(java.lang.NumberFormatException e){
				choice = myMenu.displayAndChoose();
			}
			if(choice ==(itemList.length+1)) {
				System.out.println(theShopper.balance);
			}else if(choice ==(itemList.length+2)){
				theShopper.purchases();
			}
			else if(choice == (itemList.length+3)) {
				shopping = false;
			}
			else {
				if(theShopper.balance-itemList[choice-1].value>0) {
					payed = itemList[choice-1].value;
					bought = itemList[choice - 1].name;
					System.out.println("you bought " + itemList[choice - 1].name + " for " +itemList[choice - 1].value );
					theShopper.balance = theShopper.balance - itemList[choice - 1].value;
					System.out.println("my balance is "+theShopper.balance);
					theShopper.purchaseList.add(itemList[choice-1]);
				}else {
					System.out.println("Do you want to steal the item???");
					LSMenu stealMenu = new LSMenu("Choose one:");
					stealMenu.addItem("Yes");
					stealMenu.addItem("No");
					int yesNo = stealMenu.displayAndChoose();
					if(yesNo == 1) {
						System.out.println("you stole a "+itemList[choice - 1].name);
						theShopper.purchaseList.add(itemList[choice-1]);
					}else {
						System.out.println("thank you for being a good person");
					}
				}
			}
		}
	}
}
