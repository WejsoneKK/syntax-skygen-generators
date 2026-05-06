package eu.wejsonekk.syntaxstudio.skygengenerator.litecommand;

import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.permission.MissingPermissions;
import dev.rollczi.litecommands.permission.MissingPermissionsHandler;
import eu.wejsonekk.syntaxstudio.skygengenerator.notice.NoticeService;
import org.bukkit.command.CommandSender;

public class MissingPermissionHandlerImpl implements MissingPermissionsHandler<CommandSender> {
    private final NoticeService noticeService;

    public MissingPermissionHandlerImpl(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }

    @Override
    public void handle(Invocation<CommandSender> invocation,
                       MissingPermissions missingPermissions,
                       ResultHandlerChain<CommandSender> chain
    ) {

        CommandSender sender = invocation.sender();
        String permission = missingPermissions.asJoinedText();

        this.noticeService.create()
                .viewer(sender)
                .notice(translation -> translation.missingPermission)
                .placeholder("{permissions}", missingPermissions.asJoinedText(", "))
                .placeholder("{permission}", permission)
                .send();
    }
}
