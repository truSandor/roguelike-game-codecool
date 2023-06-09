package com.codecool.roguelike.gameEngine;

public class Coordinates {
    private int horizontalCoordinate;
    private int verticalCoordinate;

    public Coordinates(int horizontalCoordinate, int verticalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
        this.verticalCoordinate = verticalCoordinate;
    }

    public int getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public void setHorizontalCoordinate(int horizontalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
    }

    public int getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public void setVerticalCoordinate(int verticalCoordinate) {
        this.verticalCoordinate = verticalCoordinate;
    }

    @Override
    public String toString() {
        return "[x= " + horizontalCoordinate +
                ", y= " + verticalCoordinate +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return horizontalCoordinate == coordinates.horizontalCoordinate &&
                verticalCoordinate == coordinates.verticalCoordinate;
    }


    public static double generateRandomHorizontal(){
        return Math.random() * (20 - 1) + 1;
    }

    public static double generateRandomVertical(){
        return Math.random() * (10 - 1) + 1;
    }


}
