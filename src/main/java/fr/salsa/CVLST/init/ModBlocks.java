package fr.salsa.CVLST.init;

import fr.salsa.CVLST.blocks.CVLSTBlocks;
import fr.salsa.CVLST.blocks.trees.CustomBlockLeave;
import fr.salsa.CVLST.blocks.trees.CustomBlockLog;
import fr.salsa.CVLST.blocks.trees.CustomBlockPlank;
import fr.salsa.CVLST.blocks.trees.CustomBlockSapling;
import fr.salsa.CVLST.utils.References;
import fr.salsa.CVLST.utils.handler.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final Block rubyBlock = new CVLSTBlocks("ruby_block", Material.IRON, 5.0f, 30.0f, 1, "pickaxe");
    public static final Block saphirBlock = new CVLSTBlocks("saphir_block", Material.IRON, 5.0f, 30.0f, 1, "pickaxe");
    public static final Block plank = new CustomBlockPlank("planks");
    public static final Block leave = new CustomBlockLeave("leave");
    public static final Block log = new CustomBlockLog("log");
    public static final Block sapling = new CustomBlockSapling("sapling");

    @SubscribeEvent
    public static void registerRenders() {
        for (int i = 0; i < EnumHandler.Enumtype.values().length; i++) {
            registerRender(plank, i, "plank_" + EnumHandler.Enumtype.values()[i].getName());
            registerRender(log, i, "log_" + EnumHandler.Enumtype.values()[i].getName());
            registerRender(log, i, "leave_" + EnumHandler.Enumtype.values()[i].getName());
            registerRender(sapling, 1, "sapling_" + EnumHandler.Enumtype.values()[i].getName());
        }
    }

    public static void registerRender(Block block, int meta, String filename) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, filename), "inventory"));
    }


    @SubscribeEvent
    public void registerModels(ModelRegistryEvent e) {
        for (Block b : BLOCKS) {
            registerModel(b);
        }
    }

    @SideOnly(Side.CLIENT)
    private void registerModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }
}