package eu.wejsonekk.syntaxstudio.skygengenerator.configuration.implementation;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;

public class PluginConfig extends OkaeriConfig {


    @Comment("# Tryb debugacji, dodatkowe logi na konsoli")
    @CustomKey("debug-mode")
    public boolean debugMode = false;


}
