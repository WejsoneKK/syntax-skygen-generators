package eu.wejsonekk.syntaxstudio.skygengenerator.litecommand;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invalidusage.InvalidUsage;
import dev.rollczi.litecommands.invalidusage.InvalidUsageHandler;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.schematic.Schematic;
import eu.wejsonekk.syntaxstudio.skygengenerator.notice.NoticeService;
import org.bukkit.command.CommandSender;

public class InvalidUsageHandlerImpl implements InvalidUsageHandler<CommandSender> {

    private final NoticeService noticeService;

    public InvalidUsageHandlerImpl(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }

    @Override
    public void handle(
            Invocation<CommandSender> invocation,
            InvalidUsage<CommandSender> result,
            ResultHandlerChain<CommandSender> chain
    ) {

        CommandSender sender = invocation.sender();
        Schematic schema = result.getSchematic();
        if (schema.isOnlyFirst()) {
            this.noticeService
                    .create()
                    .viewer(sender)
                    .notice(translation -> translation.invalidUsage)
                    .placeholder("{usage}", schema.first())
                    .send();
            return;
        }
        this.noticeService.create()
                .viewer(sender)
                .notice(translation -> translation.invalidUsageHeader)
                .send();

        for (String usage : schema.all()) {
            this.noticeService.create()
                    .viewer(sender)
                    .notice(translation -> translation.invalidUsageEntry)
                    .placeholder("{usage}", usage)
                    .send();
        }
    }
}
