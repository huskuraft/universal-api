package dev.huskuraft.universal.api.gui.player;

import dev.huskuraft.universal.api.core.PlayerInfo;
import dev.huskuraft.universal.api.gui.AbstractWidget;
import dev.huskuraft.universal.api.platform.Entrance;
import dev.huskuraft.universal.api.renderer.PlayerHeadRenderer;
import dev.huskuraft.universal.api.renderer.Renderer;

public class PlayerAvatarIcon extends AbstractWidget {

    private PlayerInfo playerInfo;

    public PlayerAvatarIcon(Entrance entrance, int x, int y, int size, PlayerInfo playerInfo) {
        super(entrance, x, y, size, size, null);
        this.playerInfo = playerInfo;
    }

    @Override
    public void renderWidget(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
        super.renderWidget(renderer, mouseX, mouseY, deltaTick);

        renderer.renderRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), 0x9f6c6c6c);

        if (playerInfo.getSkin() != null) {
            PlayerHeadRenderer.draw(renderer, playerInfo.getSkin(), getX(), getY(), getWidth());
        }

    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public void setSize(int size) {
        setWidth(size);
        setHeight(size);
    }
}
