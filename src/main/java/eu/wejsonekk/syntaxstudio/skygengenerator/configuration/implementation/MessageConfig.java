package eu.wejsonekk.syntaxstudio.skygengenerator.configuration.implementation;

import com.eternalcode.multification.notice.Notice;
import eu.okaeri.configs.OkaeriConfig;
import net.kyori.adventure.bossbar.BossBar;

import java.time.Duration;

public class MessageConfig extends OkaeriConfig {

    public Notice invalidUsage = Notice.chat("<red>Prawidłowe użycie: <gold>{usage}");
    public Notice invalidUsageHeader = Notice.chat("<red>Prawidłowe użycie:");
    public Notice invalidUsageEntry = Notice.chat("<dark_gray>-<gold>{usage}");
    public Notice missingPermission = Notice.chat("<red>Nie posiadasz wymaganych uprawnień do tego polecenia <dark_gray>(<white>{permissions}<dark_gray>)");


    public Notice globalBoostGiven = Notice.chat(
            "<dark_green>Pomyślnie nadano <dark_green>{moc}x <gold>boosta <dark_green>globalnego <dark_green>na <dark_green>{time}"
    );
    public Notice personalBoostGiven = Notice.chat(
            "<dark_green>Pomyślnie nadano <dark_green>{moc}x <gold>boosta <dark_green>osobistego <dark_green>na <dark_green>{time} dla <gold>{target}"
    );

    public Notice globalGenBoostBossBar = Notice.bossBar(
            BossBar.Color.GREEN,
            Duration.ofSeconds(50),
            "<green>Globalny GenBoost Aktywny jeszcze przez <gold>{time} <green>o mocy <white>{multiplier}"
    );

}
