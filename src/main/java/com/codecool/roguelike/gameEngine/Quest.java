package com.codecool.roguelike.gameEngine;

import com.codecool.roguelike.gameEngine.items.Item;

public class Quest {

    private String name;
    private String description;
    private String objective;
    private Item reward;
    private String progress;
    private boolean isActive;

    public Quest(String name, String description, String objective, Item reward) {
        this.name = name;
        this.description = description;
        this.objective = objective;
        this.reward = reward;
        this.isActive = false;
    }

    @Override
    public String toString() {
        String space = " ";
        return description + "\n" + "Objective: " + objective + space.repeat(10) + "Reward: " + reward.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
