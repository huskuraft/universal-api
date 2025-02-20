package dev.huskuraft.universal.api.gui.button;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import dev.huskuraft.universal.api.core.ResourceLocation;
import dev.huskuraft.universal.api.gui.AbstractButton;
import dev.huskuraft.universal.api.gui.Dimens;
import dev.huskuraft.universal.api.platform.Entrance;
import dev.huskuraft.universal.api.text.Text;

public class Button extends AbstractButton {

    public static final int BUTTON_WIDTH_1 = Dimens.Buttons.QUARTER_WIDTH;
    public static final int BUTTON_WIDTH_2 = Dimens.Buttons.HALF_WIDTH;
    public static final int BUTTON_WIDTH_4 = Dimens.Buttons.FULL_WIDTH;

    public static final int TAB_WIDTH = Dimens.Buttons.TAB_WIDTH;

    public static final int DEFAULT_HEIGHT = Dimens.Buttons.HEIGHT;

    public static final int VERTICAL_PADDING = Dimens.Buttons.VERTICAL_SPACING;
    public static final int HORIZONTAL_PADDING = Dimens.Buttons.HORIZONTAL_SPACING;

    public static final int COMPAT_SPACING_H = 4;
    public static final int COMPAT_SPACING_V = 4;
    public static final int PADDINGS = 6;

    private OnPress onPress;

    public Button(Entrance entrance, int x, int y, int width, int height, Text message) {
        super(entrance, x, y, width, height, message, null);
    }

    public Button(Entrance entrance, int x, int y, int width, int height, ResourceLocation icon) {
        super(entrance, x, y, width, height, Text.empty(), icon);
    }

    public Button(Entrance entrance, int x, int y, int width, int height, Text message, ResourceLocation icon) {
        super(entrance, x, y, width, height, message, icon);
    }

    public Button(Entrance entrance, int x, int y, int width, int height, Text message, OnPress onPress) {
        super(entrance, x, y, width, height, message, null);
        this.onPress = onPress;
    }

    public Button(Entrance entrance, int x, int y, int width, int height, ResourceLocation icon, OnPress onPress) {
        super(entrance, x, y, width, height, Text.empty(), icon);
        this.onPress = onPress;
    }

    public Button(Entrance entrance, int x, int y, int width, int height, Text message, ResourceLocation icon, OnPress onPress) {
        super(entrance, x, y, width, height, message, icon);
        this.onPress = onPress;
    }

    public static Builder builder(Entrance entrance, Text text, OnPress onPress) {
        return new Builder(entrance, onPress).setText(text);
    }

    public static Builder builder(Entrance entrance, ResourceLocation icon, OnPress onPress) {
        return new Builder(entrance, onPress).setIcon(icon);
    }

    public static Builder builder(Entrance entrance, Text text,ResourceLocation icon, OnPress onPress) {
        return new Builder(entrance, onPress).setText(text).setIcon(icon);
    }

    protected void onPress() {
        if (onPress != null) {
            this.onPress.onPress(this);
        }
    }

    public void setOnPressListener(OnPress onPress) {
        this.onPress = onPress;
    }

    public interface OnPress {
        void onPress(Button button);
    }

    public static class Builder {

        private Text text = Text.empty();
        private ResourceLocation icon;
        private final OnPress onPress;
        private final Entrance entrance;
        @Nullable
        private List<Text> tooltip = new ArrayList<>();
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;

        public Builder(Entrance entrance, OnPress onPress) {
            this.entrance = entrance;
            this.onPress = onPress;
        }

        public Builder setText(Text text) {
            this.text = text;
            return this;
        }

        public Builder setIcon(ResourceLocation icon) {
            this.icon = icon;
            return this;
        }

        public Builder setPos(int i, int j) {
            this.x = i;
            this.y = j;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setSize(int i, int j) {
            this.width = i;
            this.height = j;
            return this;
        }

        public Builder setBounds(int x, int y, int width, int height) {
            return this.setPos(x, y).setSize(width, height);
        }

        public Builder setBoundsGrid(int width, int height, float row, float col, float size) {
            return setBounds(
                    (int) (width / 2f - Button.BUTTON_WIDTH_1 * 2 - HORIZONTAL_PADDING * 3 / 2f + col * 4 * (Button.BUTTON_WIDTH_1 + HORIZONTAL_PADDING)),
                    (int) (height - Button.DEFAULT_HEIGHT - Dimens.Buttons.VERTICAL_PADDING - row * (DEFAULT_HEIGHT + VERTICAL_PADDING)),
                    (int) (Button.BUTTON_WIDTH_1 * size * 4 + HORIZONTAL_PADDING * (size * 4 - 1)),
                    DEFAULT_HEIGHT);
        }

        public Builder setBoundsGrid(int x, int y, int width, int height, float row, float col, float size) {
            var innerSize = 1 / size;
            var innerWidth = width - (innerSize - 1) * COMPAT_SPACING_V - 2 * PADDINGS;
            var index = col / size;
            var buttonWidth = innerWidth / innerSize;
            return setBounds(
                    (int) (x + index * (buttonWidth + COMPAT_SPACING_V) + PADDINGS),
                    (int) (y + (height - row * (Button.DEFAULT_HEIGHT + COMPAT_SPACING_H) - Button.DEFAULT_HEIGHT - PADDINGS)),
                    (int) buttonWidth,
                    DEFAULT_HEIGHT);
        }

        public Builder setTooltip(Text tooltip) {
            this.tooltip = List.of(tooltip);
            return this;
        }

        public Builder setTooltip(List<Text> tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public Button build() {
            var button = new Button(entrance, this.x, this.y, this.width, this.height, this.text, this.icon, this.onPress);
            button.setTooltip(this.tooltip);
            return button;
        }
    }
}
