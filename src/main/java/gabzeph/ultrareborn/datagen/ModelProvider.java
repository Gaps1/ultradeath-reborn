package gabzeph.ultrareborn.datagen;

import gabzeph.ultrareborn.armor.UltraArmor;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor((ArmorItem) UltraArmor.ULTRA_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) UltraArmor.ULTRA_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) UltraArmor.ULTRA_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) UltraArmor.ULTRA_BOOTS);
    }
}
