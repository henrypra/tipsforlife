package com.tips4life.tipsforlife.model;

import com.tips4life.tipsforlife.interfaces.TipInterface;

public class TipModel implements TipInterface {

    private String title;
    private String body;

    @Override
    public void save() {
        // TODO: Implement save() method to persist tip to db.
    }

    @Override
    public void delete() {
        // TODO: Implement delete() method to delete tip from db.
    }

    @Override
    public void update() {
        // TODO: Implement update() method to save changes to tip to db.
    }
}
