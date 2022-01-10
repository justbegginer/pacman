package classes.core;

import classes.IllegalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void setDirection() {
        Character character = new Character(0, 0, "left");
        //проверяем на правильную запись направлений
        assertEquals(character.getDirection(), "left");
        character.setDirection("right");
        assertEquals(character.getDirection(), "right");
        character.setDirection("up");
        assertEquals(character.getDirection(), "up");
        character.setDirection("down");
        assertEquals(character.getDirection(), "down");
        //Проверка на неправильные заданные направления в конструкторе и сетторе
        //Также смотрим изменяются данные или нет(не должны)
        boolean haveException = false;
        Character falsedCharacter = null;
        try {
            falsedCharacter = new Character(0, 0, "xyz");
        } catch (IllegalDirection e) {
            haveException = true;
        }
        assertTrue(haveException);
        haveException = false;
        Character falsedCharacter2 = null;
        try {
            falsedCharacter2 = new Character(0, 0, "left");
            falsedCharacter2.setDirection("dasd");
        }catch (IllegalDirection e){
            haveException = true;
        }
        assertTrue(haveException);
        assertEquals("left", falsedCharacter2.getDirection());
    }

    @Test
    void moving() {
        Character character = new Character(0, 0, "left");
        //проверяем на правильные передвижения персонажа
        character.moving();
        assertEquals(character.getX(), -1);
        character.setDirection("right");
        character.moving();
        assertEquals(character.getX(), 0);
        character.setDirection("up");
        character.moving();
        assertEquals(character.getY(), 1);
        character.setDirection("down");
        character.moving();
        assertEquals(character.getY(), 0);
        assertEquals(character.getX(), 0);
    }
}