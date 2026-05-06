package eu.wejsonekk.syntaxstudio.skygengenerator.command;

import com.eternalcode.multification.notice.Notice;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.wejsonekk.syntaxstudio.skygengenerator.generator.Generator;
import eu.wejsonekk.syntaxstudio.skygengenerator.generator.genboost.GeneratorBoost;
import eu.wejsonekk.syntaxstudio.skygengenerator.notice.NoticeService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.time.Duration;

@Command(name = "syntaxgenerator", aliases = {"syntaxskygenerator", "adminskygenerator", "askygenerator", "askygenerator"})
@Permission("syntaxstudio.skygenerators.admin")
public class AdminSkyGeneratorCommand {

    private final NoticeService noticeService;

    public AdminSkyGeneratorCommand(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }

    @Execute(name = "global", aliases = {"globalny", "g"})
    void giveNetworkGenBoost(@Context CommandSender sender, @Arg("moc") Double multiplier, @Arg("czas") Duration time) {


        this.noticeService.create()
                .viewer(sender)
                .notice(translation -> translation.globalBoostGiven)
                .placeholder("{moc}", String.valueOf(multiplier))
                .placeholder("{multiplier}", String.valueOf(multiplier))
                .placeholder("{time}", String.valueOf(time))
                .placeholder("{czas}", String.valueOf(time))
                .send();

    }

    @Execute(name = "player", aliases = {"gracz", "personal", "personalny"})
    void givePersonalGenBoost(@Context CommandSender sender, @Arg("nick") Player player, @Arg("moc") Double multiplier, @Arg("czas") Duration time) {

        this.noticeService.create()
                .viewer(sender)
                .notice(translation -> translation.personalBoostGiven)
                .placeholder("{moc}", String
                        .valueOf(multiplier))
                .placeholder("{multiplier}", String
                        .valueOf(multiplier))
                .placeholder("{time}", String
                        .valueOf(time))
                .placeholder("{czas}", String
                        .valueOf(time))
                .placeholder("{target}", player.getName())
                .send();

    }

    @Execute(name = "create", aliases = {"stworz", "stwórz"})
    void createGenerator(@Context CommandSender sender, @Arg("nick") Player player, @Arg("moc") Double multiplier, @Arg("czas") Duration time) {

        // TODO: Dodać tworzenie generatora oraz custom argument
    }

    @Execute(name = "delete", aliases = {"usun", "usuń", "remove"})
    void deleteGenerator(@Context CommandSender sender, @Arg("nick") Player player, @Arg Generator generator) {

        // TODO: Dodać usuwanie generatora oraz custom argument

    }

    @Execute(name = "deleteitem", aliases = {"usunitem", "usunprzedmiot", "usuńprzedmiot"})
    void deleteItem(@Context CommandSender sender, @Arg("generator") GeneratorBoost generatorBoost, @Arg("id") String itemId) {

        // TODO: Dodać usuwanie przedmiotu z generatora
    }

    @Execute(name = "setitem", aliases = {"ustawitem", "ustawprzedmiot"})
    void setItem(@Context Player player, @Arg("generator") GeneratorBoost generatorBoost, @Arg("ilość") Integer amount) {

        if (amount <= 0) {
            this.noticeService.create()
                    .viewer(player)
                    .notice(translation -> Notice.chat("<red>Ilość musi być większa od zera"))
                    .send();
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null) {
            this.noticeService.create()
                    .viewer(player)
                    .notice(translation -> Notice.chat("<red>Brak przedmiotu w ręce"))
                    .send();
            return;
        }


        // TODO: Dodać ustawianie przedmiotu do generatora
        this.noticeService.create()
                .viewer(player)
                .notice(translation -> Notice.chat("<green>Przedmiot ustawiony na generatorze"))
                .send();

    }

    @Execute(name = "info", aliases = {"check", "information", "sprawdź", "spr", "sprawdz"})
    @Permission({"syntaxstudio.skygenerators.admin.info", "syntaxstudio.skygenerators.admin.*"})
    void showGeneratorInformation(@Context CommandSender sender, @Arg("generator") GeneratorBoost generator) {

    }


}
