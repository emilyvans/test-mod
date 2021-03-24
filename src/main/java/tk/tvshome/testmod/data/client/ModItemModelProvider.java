package tk.tvshome.testmod.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import tk.tvshome.testmod.testmod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, testmod.MODID, existingFileHelper);

    }

    @Override
    protected void registerModels() {
        //withExistingParent("test_block", modLoc("block/test_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated,"test_ingot");

    }

    private void builder(ModelFile itemGenerated,String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0","item/"+name);
    }

}
