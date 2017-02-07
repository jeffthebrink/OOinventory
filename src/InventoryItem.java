/**
 * Created by jeffbrinkley on 2/7/17.
 */
public class InventoryItem {
    public int itemQty;
    public String item;
    public String category;


    public InventoryItem(){

    }

    public InventoryItem(int itemQty, String item, String category) {
        this.itemQty = itemQty;
        this.item = item;
        this.category = category;

    }

}
