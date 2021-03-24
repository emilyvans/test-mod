package tk.tvshome.testmod.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import tk.tvshome.testmod.data.client.ModItemModelProvider;
import tk.tvshome.testmod.testmod;

@EventBusSubscriber(modid = testmod.MODID,bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    public DataGenerators() {}

    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();

        gen.addProvider(new ModItemModelProvider(gen, event.getExistingFileHelper()));
        testmod.LOGGER.error("hello from registermodels");
    }
}
