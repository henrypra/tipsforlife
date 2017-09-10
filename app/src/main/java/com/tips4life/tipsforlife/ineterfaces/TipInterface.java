package com.tips4life.tipsforlife.ineterfaces;

/*
* TipInterface interface to enforce behaviour across tip classes.
* Potentially not needed with only 3 actual TipInterface classes, however is good practice
* to enforce this early on to improve maintainability of app long term.
* */

public interface TipInterface {

    void save();
    void delete();
    void update();

}
