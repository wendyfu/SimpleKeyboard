package example.com.simplekeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * SimpleKeyboard
 * {Default file description, change this}
 * Copyright (c) 2016 GDP Labs. All rights reserved.
 *
 * @author wendy
 * @since Dec 29, 2016.
 */
public class SimpleKeyboard extends InputMethodService
    implements KeyboardView.OnKeyboardActionListener {

    private static final int KEYCODE_EMOT_1 = -11;
    private static final int KEYCODE_EMOT_2 = -12;
    private static final int KEYCODE_EMOT_3 = -13;
    private static final int KEYCODE_EMOT_4 = -14;
    private static final int KEYCODE_EMOT_5 = -15;
    private static final int KEYCODE_SPACE = 32;

    private static final String TEXT_EMOT_1 = "(´▽｀)";
    private static final String TEXT_EMOT_2 = "(￣ー￣)";
    private static final String TEXT_EMOT_3 = "(⌒∩⌒)";
    private static final String TEXT_EMOT_4 = "(　^ω^)";
    private static final String TEXT_EMOT_5 = "(*≧∇≦*)";
    private static final String TEXT_SPACE = " ";

    private KeyboardView keyboardView;
    private Keyboard keyboard;

    @Override public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.emoji_keys);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                inputConnection.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_DONE:
                inputConnection.sendKeyEvent(
                    new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KEYCODE_EMOT_1:
                inputConnection.commitText(TEXT_EMOT_1, 1);
                break;
            case KEYCODE_EMOT_2:
                inputConnection.commitText(TEXT_EMOT_2, 1);
                break;
            case KEYCODE_EMOT_3:
                inputConnection.commitText(TEXT_EMOT_3, 1);
                break;
            case KEYCODE_EMOT_4:
                inputConnection.commitText(TEXT_EMOT_4, 1);
                break;
            case KEYCODE_EMOT_5:
                inputConnection.commitText(TEXT_EMOT_5, 1);
                break;
            case KEYCODE_SPACE:
                inputConnection.commitText(TEXT_SPACE, 1);
                break;
            default:
                break;
        }
    }

    @Override public void onPress(int primaryCode) {

    }

    @Override public void onRelease(int primaryCode) {

    }

    @Override public void onText(CharSequence text) {

    }

    @Override public void swipeLeft() {

    }

    @Override public void swipeRight() {

    }

    @Override public void swipeDown() {

    }

    @Override public void swipeUp() {

    }
}
