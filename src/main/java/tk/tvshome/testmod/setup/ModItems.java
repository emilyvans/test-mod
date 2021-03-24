package tk.tvshome.testmod.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;

public class ModItems {
    public static final RegistryObject<Item> test_item = Registration.ITEMS.register("test_item", () ->
           new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    static void register(){}

}
