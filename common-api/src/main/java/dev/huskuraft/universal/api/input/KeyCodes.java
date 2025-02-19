package dev.huskuraft.universal.api.input;

import org.lwjgl.glfw.GLFW;

public record KeyCodes(
        int value
) {

    public static final KeyCodes
            KEY_UNKNOWN = new KeyCodes(GLFW.GLFW_DONT_CARE);

    // Printable
    public static final KeyCodes
            KEY_SPACE = new KeyCodes(GLFW.GLFW_KEY_SPACE),
            KEY_APOSTROPHE = new KeyCodes(GLFW.GLFW_KEY_APOSTROPHE),
            KEY_COMMA = new KeyCodes(GLFW.GLFW_KEY_COMMA),
            KEY_MINUS = new KeyCodes(GLFW.GLFW_KEY_MINUS),
            KEY_PERIOD = new KeyCodes(GLFW.GLFW_KEY_PERIOD),
            KEY_SLASH = new KeyCodes(GLFW.GLFW_KEY_SLASH),
            KEY_0 = new KeyCodes(GLFW.GLFW_KEY_0),
            KEY_1 = new KeyCodes(GLFW.GLFW_KEY_1),
            KEY_2 = new KeyCodes(GLFW.GLFW_KEY_2),
            KEY_3 = new KeyCodes(GLFW.GLFW_KEY_3),
            KEY_4 = new KeyCodes(GLFW.GLFW_KEY_4),
            KEY_5 = new KeyCodes(GLFW.GLFW_KEY_5),
            KEY_6 = new KeyCodes(GLFW.GLFW_KEY_6),
            KEY_7 = new KeyCodes(GLFW.GLFW_KEY_7),
            KEY_8 = new KeyCodes(GLFW.GLFW_KEY_8),
            KEY_9 = new KeyCodes(GLFW.GLFW_KEY_9),
            KEY_SEMICOLON = new KeyCodes(GLFW.GLFW_KEY_SEMICOLON),
            KEY_EQUAL = new KeyCodes(GLFW.GLFW_KEY_EQUAL),
            KEY_A = new KeyCodes(GLFW.GLFW_KEY_A),
            KEY_B = new KeyCodes(GLFW.GLFW_KEY_B),
            KEY_C = new KeyCodes(GLFW.GLFW_KEY_C),
            KEY_D = new KeyCodes(GLFW.GLFW_KEY_D),
            KEY_E = new KeyCodes(GLFW.GLFW_KEY_E),
            KEY_F = new KeyCodes(GLFW.GLFW_KEY_F),
            KEY_G = new KeyCodes(GLFW.GLFW_KEY_G),
            KEY_H = new KeyCodes(GLFW.GLFW_KEY_H),
            KEY_I = new KeyCodes(GLFW.GLFW_KEY_I),
            KEY_J = new KeyCodes(GLFW.GLFW_KEY_J),
            KEY_K = new KeyCodes(GLFW.GLFW_KEY_K),
            KEY_L = new KeyCodes(GLFW.GLFW_KEY_L),
            KEY_M = new KeyCodes(GLFW.GLFW_KEY_M),
            KEY_N = new KeyCodes(GLFW.GLFW_KEY_N),
            KEY_O = new KeyCodes(GLFW.GLFW_KEY_O),
            KEY_P = new KeyCodes(GLFW.GLFW_KEY_P),
            KEY_Q = new KeyCodes(GLFW.GLFW_KEY_Q),
            KEY_R = new KeyCodes(GLFW.GLFW_KEY_R),
            KEY_S = new KeyCodes(GLFW.GLFW_KEY_S),
            KEY_T = new KeyCodes(GLFW.GLFW_KEY_T),
            KEY_U = new KeyCodes(GLFW.GLFW_KEY_U),
            KEY_V = new KeyCodes(GLFW.GLFW_KEY_V),
            KEY_W = new KeyCodes(GLFW.GLFW_KEY_W),
            KEY_X = new KeyCodes(GLFW.GLFW_KEY_X),
            KEY_Y = new KeyCodes(GLFW.GLFW_KEY_Y),
            KEY_Z = new KeyCodes(GLFW.GLFW_KEY_Z),
            KEY_LEFT_BRACKET = new KeyCodes(GLFW.GLFW_KEY_LEFT_BRACKET),
            KEY_BACKSLASH = new KeyCodes(GLFW.GLFW_KEY_BACKSLASH),
            KEY_RIGHT_BRACKET = new KeyCodes(GLFW.GLFW_KEY_RIGHT_BRACKET),
            KEY_GRAVE_ACCENT = new KeyCodes(GLFW.GLFW_KEY_GRAVE_ACCENT),
            KEY_WORLD_1 = new KeyCodes(GLFW.GLFW_KEY_WORLD_1),
            KEY_WORLD_2 = new KeyCodes(GLFW.GLFW_KEY_WORLD_2);

    // Function
    public static final KeyCodes
            KEY_ESCAPE = new KeyCodes(GLFW.GLFW_KEY_ESCAPE),
            KEY_ENTER = new KeyCodes(GLFW.GLFW_KEY_ENTER),
            KEY_TAB = new KeyCodes(GLFW.GLFW_KEY_TAB),
            KEY_BACKSPACE = new KeyCodes(GLFW.GLFW_KEY_BACKSPACE),
            KEY_INSERT = new KeyCodes(GLFW.GLFW_KEY_INSERT),
            KEY_DELETE = new KeyCodes(GLFW.GLFW_KEY_DELETE),
            KEY_RIGHT = new KeyCodes(GLFW.GLFW_KEY_RIGHT),
            KEY_LEFT = new KeyCodes(GLFW.GLFW_KEY_LEFT),
            KEY_DOWN = new KeyCodes(GLFW.GLFW_KEY_DOWN),
            KEY_UP = new KeyCodes(GLFW.GLFW_KEY_UP),
            KEY_PAGE_UP = new KeyCodes(GLFW.GLFW_KEY_PAGE_UP),
            KEY_PAGE_DOWN = new KeyCodes(GLFW.GLFW_KEY_PAGE_DOWN),
            KEY_HOME = new KeyCodes(GLFW.GLFW_KEY_HOME),
            KEY_END = new KeyCodes(GLFW.GLFW_KEY_END),
            KEY_CAPS_LOCK = new KeyCodes(GLFW.GLFW_KEY_CAPS_LOCK),
            KEY_SCROLL_LOCK = new KeyCodes(GLFW.GLFW_KEY_SCROLL_LOCK),
            KEY_NUM_LOCK = new KeyCodes(GLFW.GLFW_KEY_NUM_LOCK),
            KEY_PRINT_SCREEN = new KeyCodes(GLFW.GLFW_KEY_PRINT_SCREEN),
            KEY_PAUSE = new KeyCodes(GLFW.GLFW_KEY_PAUSE),
            KEY_F1 = new KeyCodes(GLFW.GLFW_KEY_F1),
            KEY_F2 = new KeyCodes(GLFW.GLFW_KEY_F2),
            KEY_F3 = new KeyCodes(GLFW.GLFW_KEY_F3),
            KEY_F4 = new KeyCodes(GLFW.GLFW_KEY_F4),
            KEY_F5 = new KeyCodes(GLFW.GLFW_KEY_F5),
            KEY_F6 = new KeyCodes(GLFW.GLFW_KEY_F6),
            KEY_F7 = new KeyCodes(GLFW.GLFW_KEY_F7),
            KEY_F8 = new KeyCodes(GLFW.GLFW_KEY_F8),
            KEY_F9 = new KeyCodes(GLFW.GLFW_KEY_F9),
            KEY_F10 = new KeyCodes(GLFW.GLFW_KEY_F10),
            KEY_F11 = new KeyCodes(GLFW.GLFW_KEY_F11),
            KEY_F12 = new KeyCodes(GLFW.GLFW_KEY_F12),
            KEY_F13 = new KeyCodes(GLFW.GLFW_KEY_F13),
            KEY_F14 = new KeyCodes(GLFW.GLFW_KEY_F14),
            KEY_F15 = new KeyCodes(GLFW.GLFW_KEY_F15),
            KEY_F16 = new KeyCodes(GLFW.GLFW_KEY_F16),
            KEY_F17 = new KeyCodes(GLFW.GLFW_KEY_F17),
            KEY_F18 = new KeyCodes(GLFW.GLFW_KEY_F18),
            KEY_F19 = new KeyCodes(GLFW.GLFW_KEY_F19),
            KEY_F20 = new KeyCodes(GLFW.GLFW_KEY_F20),
            KEY_F21 = new KeyCodes(GLFW.GLFW_KEY_F21),
            KEY_F22 = new KeyCodes(GLFW.GLFW_KEY_F22),
            KEY_F23 = new KeyCodes(GLFW.GLFW_KEY_F23),
            KEY_F24 = new KeyCodes(GLFW.GLFW_KEY_F24),
            KEY_F25 = new KeyCodes(GLFW.GLFW_KEY_F25),
            KEY_KP_0 = new KeyCodes(GLFW.GLFW_KEY_KP_0),
            KEY_KP_1 = new KeyCodes(GLFW.GLFW_KEY_KP_1),
            KEY_KP_2 = new KeyCodes(GLFW.GLFW_KEY_KP_2),
            KEY_KP_3 = new KeyCodes(GLFW.GLFW_KEY_KP_3),
            KEY_KP_4 = new KeyCodes(GLFW.GLFW_KEY_KP_4),
            KEY_KP_5 = new KeyCodes(GLFW.GLFW_KEY_KP_5),
            KEY_KP_6 = new KeyCodes(GLFW.GLFW_KEY_KP_6),
            KEY_KP_7 = new KeyCodes(GLFW.GLFW_KEY_KP_7),
            KEY_KP_8 = new KeyCodes(GLFW.GLFW_KEY_KP_8),
            KEY_KP_9 = new KeyCodes(GLFW.GLFW_KEY_KP_9),
            KEY_KP_DECIMAL = new KeyCodes(GLFW.GLFW_KEY_KP_DECIMAL),
            KEY_KP_DIVIDE = new KeyCodes(GLFW.GLFW_KEY_KP_DIVIDE),
            KEY_KP_MULTIPLY = new KeyCodes(GLFW.GLFW_KEY_KP_MULTIPLY),
            KEY_KP_SUBTRACT = new KeyCodes(GLFW.GLFW_KEY_KP_SUBTRACT),
            KEY_KP_ADD = new KeyCodes(GLFW.GLFW_KEY_KP_ADD),
            KEY_KP_ENTER = new KeyCodes(GLFW.GLFW_KEY_KP_ENTER),
            KEY_KP_EQUAL = new KeyCodes(GLFW.GLFW_KEY_KP_EQUAL),
            KEY_LEFT_SHIFT = new KeyCodes(GLFW.GLFW_KEY_LEFT_SHIFT),
            KEY_LEFT_CONTROL = new KeyCodes(GLFW.GLFW_KEY_LEFT_CONTROL),
            KEY_LEFT_ALT = new KeyCodes(GLFW.GLFW_KEY_LEFT_ALT),
            KEY_LEFT_SUPER = new KeyCodes(GLFW.GLFW_KEY_LEFT_SUPER),
            KEY_RIGHT_SHIFT = new KeyCodes(GLFW.GLFW_KEY_RIGHT_SHIFT),
            KEY_RIGHT_CONTROL = new KeyCodes(GLFW.GLFW_KEY_RIGHT_CONTROL),
            KEY_RIGHT_ALT = new KeyCodes(GLFW.GLFW_KEY_RIGHT_ALT),
            KEY_RIGHT_SUPER = new KeyCodes(GLFW.GLFW_KEY_RIGHT_SUPER),
            KEY_MENU = new KeyCodes(GLFW.GLFW_KEY_MENU),
            KEY_LAST = new KeyCodes(GLFW.GLFW_KEY_LAST);

    // Mouse Buttons
    public static final KeyCodes
            MOUSE_BUTTON_1 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_1),
            MOUSE_BUTTON_2 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_2),
            MOUSE_BUTTON_3 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_3),
            MOUSE_BUTTON_4 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_4),
            MOUSE_BUTTON_5 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_5),
            MOUSE_BUTTON_6 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_6),
            MOUSE_BUTTON_7 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_7),
            MOUSE_BUTTON_8 = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_8),
            MOUSE_BUTTON_LAST = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_LAST),
            MOUSE_BUTTON_LEFT = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_LEFT),
            MOUSE_BUTTON_RIGHT = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_RIGHT),
            MOUSE_BUTTON_MIDDLE = new KeyCodes(GLFW.GLFW_MOUSE_BUTTON_MIDDLE);

    // Joysticks
    public static final KeyCodes
            JOYSTICK_1 = new KeyCodes(GLFW.GLFW_JOYSTICK_1),
            JOYSTICK_2 = new KeyCodes(GLFW.GLFW_JOYSTICK_2),
            JOYSTICK_3 = new KeyCodes(GLFW.GLFW_JOYSTICK_3),
            JOYSTICK_4 = new KeyCodes(GLFW.GLFW_JOYSTICK_4),
            JOYSTICK_5 = new KeyCodes(GLFW.GLFW_JOYSTICK_5),
            JOYSTICK_6 = new KeyCodes(GLFW.GLFW_JOYSTICK_6),
            JOYSTICK_7 = new KeyCodes(GLFW.GLFW_JOYSTICK_7),
            JOYSTICK_8 = new KeyCodes(GLFW.GLFW_JOYSTICK_8),
            JOYSTICK_9 = new KeyCodes(GLFW.GLFW_JOYSTICK_9),
            JOYSTICK_10 = new KeyCodes(GLFW.GLFW_JOYSTICK_10),
            JOYSTICK_11 = new KeyCodes(GLFW.GLFW_JOYSTICK_11),
            JOYSTICK_12 = new KeyCodes(GLFW.GLFW_JOYSTICK_12),
            JOYSTICK_13 = new KeyCodes(GLFW.GLFW_JOYSTICK_13),
            JOYSTICK_14 = new KeyCodes(GLFW.GLFW_JOYSTICK_14),
            JOYSTICK_15 = new KeyCodes(GLFW.GLFW_JOYSTICK_15),
            JOYSTICK_16 = new KeyCodes(GLFW.GLFW_JOYSTICK_16),
            JOYSTICK_LAST = new KeyCodes(GLFW.GLFW_JOYSTICK_LAST);

    // Gamepad Buttons
    public static final KeyCodes
            GAMEPAD_BUTTON_A = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_A),
            GAMEPAD_BUTTON_B = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_B),
            GAMEPAD_BUTTON_X = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_X),
            GAMEPAD_BUTTON_Y = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_Y),
            GAMEPAD_BUTTON_LEFT_BUMPER = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_LEFT_BUMPER),
            GAMEPAD_BUTTON_RIGHT_BUMPER = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_RIGHT_BUMPER),
            GAMEPAD_BUTTON_BACK = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_BACK),
            GAMEPAD_BUTTON_START = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_START),
            GAMEPAD_BUTTON_GUIDE = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_GUIDE),
            GAMEPAD_BUTTON_LEFT_THUMB = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_LEFT_THUMB),
            GAMEPAD_BUTTON_RIGHT_THUMB = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_RIGHT_THUMB),
            GAMEPAD_BUTTON_DPAD_UP = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_UP),
            GAMEPAD_BUTTON_DPAD_RIGHT = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_RIGHT),
            GAMEPAD_BUTTON_DPAD_DOWN = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_DOWN),
            GAMEPAD_BUTTON_DPAD_LEFT = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_DPAD_LEFT),
            GAMEPAD_BUTTON_LAST = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_LAST),
            GAMEPAD_BUTTON_CROSS = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_CROSS),
            GAMEPAD_BUTTON_CIRCLE = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_CIRCLE),
            GAMEPAD_BUTTON_SQUARE = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_SQUARE),
            GAMEPAD_BUTTON_TRIANGLE = new KeyCodes(GLFW.GLFW_GAMEPAD_BUTTON_TRIANGLE);

    // Gamepad Axes
    public static final KeyCodes
            GAMEPAD_AXIS_LEFT_X = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_LEFT_X),
            GAMEPAD_AXIS_LEFT_Y = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_LEFT_Y),
            GAMEPAD_AXIS_RIGHT_X = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_RIGHT_X),
            GAMEPAD_AXIS_RIGHT_Y = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_RIGHT_Y),
            GAMEPAD_AXIS_LEFT_TRIGGER = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_LEFT_TRIGGER),
            GAMEPAD_AXIS_RIGHT_TRIGGER = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER),
            GAMEPAD_AXIS_LAST = new KeyCodes(GLFW.GLFW_GAMEPAD_AXIS_LAST);


}
