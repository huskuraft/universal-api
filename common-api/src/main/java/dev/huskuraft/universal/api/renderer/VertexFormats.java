package dev.huskuraft.universal.api.renderer;

public enum VertexFormats implements VertexFormat {
    BLIT_SCREEN,
    BLOCK,
    NEW_ENTITY,
    PARTICLE,
    POSITION,
    POSITION_COLOR,
    POSITION_COLOR_NORMAL,
    POSITION_COLOR_LIGHTMAP,
    POSITION_TEX,
    POSITION_COLOR_TEX,
    POSITION_TEX_COLOR,
    POSITION_COLOR_TEX_LIGHTMAP,
    POSITION_TEX_LIGHTMAP_COLOR,
    POSITION_TEX_COLOR_NORMAL,
    ;

    @Override
    public Object refs() {
        return RenderStateFactory.getInstance().getVertexFormat(this).refs();
    }

    public enum Modes implements Mode {
        LINES,
        LINE_STRIP,
        DEBUG_LINES,
        DEBUG_LINE_STRIP,
        TRIANGLES,
        TRIANGLE_STRIP,
        TRIANGLE_FAN,
        QUADS,
        ;

        @Override
        public Object refs() {
            return RenderStateFactory.getInstance().getVertexFormatMode(this).refs();
        }
    }
}
