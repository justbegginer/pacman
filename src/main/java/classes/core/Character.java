package classes.core;

import classes.IllegalDirection;

import java.util.Objects;

public class Character extends Point {
    String direction = null;

    public Character(int x, int y, String direction) {
        super(x, y);
        IllegalDirectionChecker(direction);// проверка на правильность введёного направления происходит до измненения
        //чтобы не допустить изменения на неправильные данные и поддержать гарантию безопасности исключений
        this.direction = direction;
    }

    public void setDirection(String newDirection) {
        IllegalDirectionChecker(newDirection);
        this.direction = newDirection;
    }

    public String getDirection() {
        return direction;
    }

    public void moving() {
        if (Objects.equals(direction, "left")) {
            move(-1, 0);
        } else if (Objects.equals(direction, "right")) {
            move(1, 0);
        } else if (Objects.equals(direction, "up")) {
            move(0, 1);
        } else {
            move(0, -1);
        }
    }

    private void IllegalDirectionChecker(String newDirection) {
        if (!(Objects.equals(newDirection, "left") || Objects.equals(newDirection, "right") ||
                Objects.equals(newDirection, "up") || Objects.equals(newDirection, "down")))
            throw new IllegalDirection();
    }
}
