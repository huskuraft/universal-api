package dev.huskuraft.universal.api.gui;

import java.util.List;

public interface ContainerWidget extends Widget {

    boolean isDragging();

    void setDragging(boolean dragging);

    List<? extends Widget> children();

    Widget getFocused();

    Widget getSelected();

    Widget getHovered();

    Widget getWidget(int i);

    Widget getWidgetAt(double mouseX, double mouseY);

    default void recreateChildren() {
        for (var child : children()) {
            child.recreate();
        }
    }

}

