package com.example.game;

public class hero {
    String name;
    int power;
    int speed;
    int health;

    hero(String name , int power , int speed  , int health) {
        this.name = name;
        this.power = power;
        this.speed = speed;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
