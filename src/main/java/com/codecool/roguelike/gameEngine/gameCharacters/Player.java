package com.codecool.roguelike.gameEngine.gameCharacters;

import com.codecool.roguelike.*;
import com.codecool.roguelike.gameEngine.Coordinates;
import com.codecool.roguelike.gameEngine.Engine;
import com.codecool.roguelike.gameEngine.items.*;
import com.codecool.roguelike.items.*;

import java.io.IOException;

/*
 * This class keeps all the necessary information about the player i.e. player icon, player position
 * Feel free to extend it!
 */
public class Player extends GameCharacter {
    private Race RACE;
    private static final char playerIcon = '@';
    private Coordinates attackCoordinates;

    private boolean hasKey;

    public Player(String name, Race race, Coordinates coordinates) {
        super(name, coordinates, playerIcon);
        this.RACE = race;
        hasKey = false; //TODO
        this.armor += 40;
        this.damage += 50;
        this.hitChance = 90;
    }

    public void moveUp() {
        Coordinates nextCoordinates = new Coordinates(coordinates.getHorizontalCoordinate(), coordinates.getVerticalCoordinate() - 1);
        if (Engine.isEmpty(nextCoordinates)) {
            coordinates = nextCoordinates;
        } else {
            Engine.tryToInteract(this, nextCoordinates);
            attackCoordinates = nextCoordinates;
        }
    }

    public void moveDown() {
        Coordinates nextCoordinates = new Coordinates(coordinates.getHorizontalCoordinate(), coordinates.getVerticalCoordinate() + 1);
        if (Engine.isEmpty(nextCoordinates)) {
            coordinates = nextCoordinates;
        } else {
            Engine.tryToInteract(this, nextCoordinates);
            attackCoordinates = nextCoordinates;
        }
    }


    public void moveLeft() {
       Coordinates nextCoordinates = new Coordinates(coordinates.getHorizontalCoordinate() - 1, coordinates.getVerticalCoordinate());
       if (Engine.isEmpty(nextCoordinates)) {
           coordinates = nextCoordinates;
       } else {
           Engine.tryToInteract(this, nextCoordinates);
           attackCoordinates = nextCoordinates;
       }
    }

    public void moveRight() {
        Coordinates nextCoordinates = new Coordinates(coordinates.getHorizontalCoordinate() + 1, coordinates.getVerticalCoordinate());
        if (Engine.isEmpty(nextCoordinates)) {
            coordinates = nextCoordinates;
        } else {
            Engine.tryToInteract(this, nextCoordinates);
            attackCoordinates = nextCoordinates;
        }
    }

    public Race getPlayerRace() {
        return RACE;
    }

    public void setPlayerRace(Race race) {
        this.RACE = race;
    }

    @Override
    public String toString() {
        return  name +
                "\n    HP " + health +
                " / Armor " + armor +
                " / Damage " + damage +
                " / Coords " + coordinates +
                " / Inventory [" + inventory.size() + "]";
    }

    public void displayInventory() {
        for (Item item : inventory) {
            System.out.println(item);
        }
        try {
            Util.getInputChar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void pickUp(Item item) {
        inventory.add(item);
        if (item.getType().equals(ItemType.KEY)) {
            hasKey = true;

        } else if (item instanceof Weapon weapon) {
                damage += weapon.getAddedDamage();
                System.out.println("You equipped the " + item.getName() + "!");

        } else if (item instanceof Armor armor) {
                this.armor += armor.getAddedArmor();
                System.out.println("You equipped the " + item.getName() + "!");

        } else if (item instanceof Food food) {
            health = health + food.getAddedHealth() > 100 ? 100 : health + food.getAddedHealth();
            inventory.remove(item);
            System.out.println("You ate an " + item.getName() + "!");
        }
        Engine.deleteItem(item);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void die() {
        if (isDead()) {
            System.out.println("You died");
        }
    }

    public Coordinates getAttackCoordinates() {
        return attackCoordinates;
    }

    public boolean isHasKey() {
        return hasKey;
    }
}
