package mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEvictingDualNodeHashTable;
import net.runelite.rs.api.RSVarbitComposition;

@Mixin(RSVarbitComposition.class)
public abstract class RSVarbitCompositionMixin implements RSVarbitComposition
{
    @Shadow("client")
    private static RSClient client;

    @MethodHook(value = "<init>", end = true)
    @Inject
    public void rl$init()
    {
        if (client != null) {
            RSEvictingDualNodeHashTable cachedModels2 = client.getItemCompositionCache();
            cachedModels2.resize(1024);
        }
    }
}