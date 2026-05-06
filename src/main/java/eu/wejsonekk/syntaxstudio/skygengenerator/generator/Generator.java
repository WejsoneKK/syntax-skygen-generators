package eu.wejsonekk.syntaxstudio.skygengenerator.generator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Generator {

    private String name;
    private Material generatorIcon;
    private ItemStack generatorItem;
    private int itemAmount;

    public Generator(String name, Material icon, ItemStack item, int amount) {
        this.name = name;
        this.generatorIcon = icon;
        this.generatorItem = item;
        this.itemAmount = amount;
    }


    public Material getGeneratorIcon() {
        return generatorIcon;
    }

    public ItemStack getGeneratorItem() {
        return generatorItem;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public void setGeneratorItem(ItemStack generatorItem) {
        this.generatorItem = generatorItem;
    }

    public void setGeneratorIcon(Material generatorIcon) {
        this.generatorIcon = generatorIcon;
    }
}
