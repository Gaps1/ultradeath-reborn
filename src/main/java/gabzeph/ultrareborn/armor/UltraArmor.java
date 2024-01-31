package gabzeph.ultrareborn.armor;

import gabzeph.ultrareborn.UltradeathReborn;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class UltraArmor {

    public static final Item ULTRA_HELMET = registerItem("ultra_helmet", new ArmorItem(UltraMaterial.ULTRA, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ULTRA_LEGGINGS = registerItem("ultra_leggings", new ArmorItem(UltraMaterial.ULTRA, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ULTRA_CHESTPLATE = registerItem("ultra_chestplate", new ArmorItem(UltraMaterial.ULTRA, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ULTRA_BOOTS = registerItem("ultra_boots", new ArmorItem(UltraMaterial.ULTRA, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(UltradeathReborn.MOD_ID, name), item);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(ULTRA_BOOTS);
        entries.add(ULTRA_LEGGINGS);
        entries.add(ULTRA_CHESTPLATE);
        entries.add(ULTRA_HELMET);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(UltraArmor::addItemsToCombatItemGroup);
    }
}
