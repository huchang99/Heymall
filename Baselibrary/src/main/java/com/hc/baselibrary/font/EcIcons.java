package com.hc.baselibrary.font;

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {

    icon_weixinone('\ue60e'),
    icon_weixintwo('\ue73b'),
    icon_weixinthree('\ue60d');

    private char aChar;

     EcIcons(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public String key() {
        return this.name().replace('_', '-');
    }

    @Override
    public char character() {
        return aChar;
    }
}
