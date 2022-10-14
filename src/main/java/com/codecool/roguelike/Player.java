package com.codecool.roguelike;

/*
 * This class keeps all the necessary information about the player i.e. player icon, player position
 * Feel free to extend it!
 */
public class Player {

    private String NAME;
    private Race RACE;
    private int health;
    private int damage;
    private int damageTaken;
    private Coordinates coordinates;

    public Player(String name, Coordinates coordinates) {
        this.NAME = name;
        RACE = Race.HUMAN;
        health = 100;
        damage = 10;
        damageTaken = 10;
        this.coordinates = coordinates;
    }

    public void moveUp() {
        coordinates.setVerticalCoordinate(coordinates.getVerticalCoordinate() + 1);
    }

    public void moveDown() {
    }

    public void moveLeft() {
    }

    public void moveRight() {
    }

    public String getPlayerName() {
        return NAME;
    }

    public Race getPlayerRace() {
        return RACE;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setPlayerName(String name) {
        this.NAME = name;
    }

    public void setPlayerRace(Race race) {
        this.RACE = race;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }
}
