package tk.tvshome.testmod.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import tk.tvshome.testmod.testmod;

import java.util.function.Supplier;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, testmod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, testmod.MODID);

    public static void register(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
    //items
    public static final RegistryObject<Item> test_item = Registration.ITEMS.register("test_item", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    //blocks
    public static final RegistryObject<Block> testblock = register("test_block", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3,10)
                    .harvestLevel(2)
                    .sound(SoundType.ANVIL)
                    .jumpFactor(100)));
    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }

}
