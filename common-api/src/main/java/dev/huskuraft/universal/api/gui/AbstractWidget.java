package dev.huskuraft.universal.api.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import dev.huskuraft.universal.api.platform.ClientEntrance;
import dev.huskuraft.universal.api.platform.Entrance;
import dev.huskuraft.universal.api.renderer.Renderer;
import dev.huskuraft.universal.api.text.Text;

public abstract class AbstractWidget implements Widget {

    private final ClientEntrance entrance;
    private boolean visible = true;
    private boolean active = true;
    private boolean hovered = false;
    private boolean focused = false;
    private float alpha = 1f;
    private int x;
    private int y;
    private int width;
    private int height;
    private Text message = Text.empty();;
    private List<Text> tooltip = new ArrayList<>();
    private Widget parent;
    protected boolean focusable = false;

    protected AbstractWidget(Entrance entrance, int x, int y, int width, int height, Text message) {
        this.entrance = (ClientEntrance) entrance;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.message = message;
        this.tooltip = new ArrayList<>();
    }

    protected AbstractWidget(Entrance entrance, Text message) {
        this.entrance = (ClientEntrance) entrance;
        this.message = message;
    }

    protected AbstractWidget(Entrance entrance) {
        this.entrance = (ClientEntrance) entrance;
    }

    protected ClientEntrance getEntrance() {
        return entrance;
    }

    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
        if (!focusable) {
            this.focused = false;
        }
    }

    @Override
    public void onTick() {

    }

    @Override
    public void onAnimateTick(float partialTick) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onReload() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void render(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
        onReload();
        setHovered(isMouseOver(mouseX, mouseY));

        if (isVisible()) {
            renderWidgetBackground(renderer, mouseX, mouseY, deltaTick);
            renderWidget(renderer, mouseX, mouseY, deltaTick);
        }
    }

    @Override
    public void renderOverlay(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
        if (isVisible()) {
            renderWidgetOverlay(renderer, mouseX, mouseY, deltaTick);
        }
        onAnimateTick(deltaTick);
    }

    public void renderWidgetBackground(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
    }

    public void renderWidget(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
    }

    public void renderWidgetOverlay(Renderer renderer, int mouseX, int mouseY, float deltaTick) {
        if (isHovered()) {
            renderer.renderTooltip(getTypeface(), getTooltip(), mouseX, mouseY);
        }
    }

    public Typeface getTypeface() {
        return getEntrance().getClient().getTypeface();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isHovered() {
        return hovered;
    }

    @Override
    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        if (!this.focusable) {
            return;
        }
        this.focused = focused;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void moveX(int x) {
        this.x += x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveY(int y) {
        this.y += y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public Text getMessage() {
        return message;
    }

    public void setMessage(Text text) {
        this.message = text;
    }

    public void setMessage(String text) {
        this.message = Text.text(text);
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY) {
        return (hasParent() && getParent().isMouseOver(mouseX, mouseY) || !hasParent()) && this.isVisible() && mouseX >= this.getX() && mouseY >= this.getY() && mouseX < (this.getX() + this.getWidth()) && mouseY < (this.getY() + this.getHeight());
    }

    @Override
    public boolean onMouseMoved(double mouseX, double mouseY) {
        return false;
    }

    @Override
    public boolean onMouseClicked(double mouseX, double mouseY, int button) {
        if (!focusable) {
            return false;
        }
        var mouseOver = isMouseOver(mouseX, mouseY);
        this.focused = mouseOver;
        return mouseOver;
    }

    @Override
    public boolean onMouseReleased(double mouseX, double mouseY, int button) {
        return false;
    }

    @Override
    public boolean onMouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return false;
    }

    @Override
    public boolean onMouseScrolled(double mouseX, double mouseY, double amountX, double amountY) {
        return false;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    @Override
    public boolean onKeyReleased(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    @Override
    public boolean onCharTyped(char character, int modifiers) {
        return false;
    }

    @Override
    public boolean onFocusMove(boolean forwards) {
        return false;
    }

    public boolean isHoveredOrFocused() {
        return this.isHovered() || this.isFocused();
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public List<Text> getTooltip() {
        return tooltip;
    }


    public void clearTooltip() {
        this.tooltip = List.of();
    }

    public void setTooltip(Text tooltip) {
        this.tooltip = Collections.singletonList(tooltip);
    }

    public void setTooltip(List<Text> tooltip) {
        this.tooltip = tooltip;
    }

    public void setTooltip(Text... tooltip) {
        this.tooltip = List.of(tooltip);
    }

    public void setTooltip(String... tooltip) {
        this.tooltip = Stream.of(tooltip).map(Text::text).toList();
    }

    @Override
    public Widget getParent() {
        return parent;
    }

    public void setParent(Widget parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public final int getLeft() {
        return Widget.super.getLeft();
    }

    @Override
    public final int getRight() {
        return Widget.super.getRight();
    }

    @Override
    public final int getTop() {
        return Widget.super.getTop();
    }

    @Override
    public final int getBottom() {
        return Widget.super.getBottom();
    }
}
