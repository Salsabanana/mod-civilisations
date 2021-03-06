package fr.salsa.CVLST.proxy;

import fr.salsa.CVLST.utils.RenderEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e){
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(ModItems.INSTANCE);
        MinecraftForge.EVENT_BUS.register(ModBlocks.INSTANCE);
        RenderEntity.registerEntityRenders();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }
}
