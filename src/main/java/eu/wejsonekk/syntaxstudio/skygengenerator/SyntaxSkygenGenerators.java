package eu.wejsonekk.syntaxstudio.skygengenerator;

import com.eternalcode.multification.notice.resolver.NoticeResolverRegistry;
import com.eternalcode.multification.notice.resolver.sound.SoundAdventureResolver;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import eu.wejsonekk.syntaxstudio.skygengenerator.configuration.ConfigurationService;
import eu.wejsonekk.syntaxstudio.skygengenerator.configuration.implementation.MessageConfig;
import eu.wejsonekk.syntaxstudio.skygengenerator.configuration.implementation.PluginConfig;
import eu.wejsonekk.syntaxstudio.skygengenerator.litecommand.InvalidUsageHandlerImpl;
import eu.wejsonekk.syntaxstudio.skygengenerator.litecommand.MissingPermissionHandlerImpl;
import eu.wejsonekk.syntaxstudio.skygengenerator.notice.NoticeService;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SyntaxSkygenGenerators extends JavaPlugin {

    private NoticeService noticeService;
    private MessageConfig messageConfig;
    private ConfigurationService configurationService;
    private PluginConfig pluginConfig;
    private LiteCommands<CommandSender> liteCommands;


    @Override
    public void onEnable() {


        NoticeResolverRegistry noticeResolverRegistry = new NoticeResolverRegistry()
                .registerResolver(new SoundAdventureResolver());

        this.configurationService = new ConfigurationService(noticeResolverRegistry);
        this.messageConfig = this.configurationService.create(MessageConfig.class, new File(this.getDataFolder(), "message.yml"));
        this.pluginConfig = this.configurationService.create(PluginConfig.class, new File(this.getDataFolder(), "configuration.yml"));

        this.noticeService = new NoticeService(this.messageConfig);


        this.liteCommands = LiteBukkitFactory
                .builder("syntax-skygen-generators", this)
                .invalidUsage(new InvalidUsageHandlerImpl(this.noticeService))
                .missingPermission(new MissingPermissionHandlerImpl(this.noticeService))
                .build();

    }

    @Override
    public void onDisable() {
        if (this.liteCommands != null) {
            this.liteCommands.unregister();
        }
    }
}
