package com.codecool.roguelike;

import java.util.List;

public abstract class GameCharacter {

    protected String name;
    protected int health = 100;
    protected int damage = 10;
    protected int damageTaken = 10;
    protected int hitChance = 50;
    protected Coordinates coordinates;
    protected char characterIcon;
    protected List<Item> Inventory;

    public GameCharacter(String name, Coordinates coordinates, char characterIcon) {
        this.name = name;
        this.coordinates = coordinates;
        this.characterIcon = characterIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getHitChance() {
        return hitChance;
    }

    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public char getCharacterIcon() {
        return characterIcon;
    }

    public void setCharacterIcon(char characterIcon) {
        this.characterIcon = characterIcon;
    }

    public List<Item> getInventory() {
        return Inventory;
    }

    public void setInventory(List<Item> inventory) {
        Inventory = inventory;
    }
}
