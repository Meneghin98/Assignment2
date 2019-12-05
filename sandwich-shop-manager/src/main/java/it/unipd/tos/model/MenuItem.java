////////////////////////////////////////////////////////////////////
// Simone Meneghin 1174926
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum ItemType {panini, fritti, bevande};
    
    private ItemType type;
    private String name;
    private double price;
    
    public MenuItem(ItemType t, String n, double p){
        type=t;
        name=n;
        price=p;
    }
}