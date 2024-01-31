package gabzeph.ultrareborn;

import gabzeph.ultrareborn.datagen.ModelProvider;
import gabzeph.ultrareborn.datagen.ItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class UltradeathRebornDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(ModelProvider::new);
	}
}
