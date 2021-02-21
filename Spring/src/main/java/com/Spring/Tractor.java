package com.Spring;

import com.Spring.Moves.Movable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
resource- https://bitbucket.org/agoshkoviv/patterns-homework-1/src/69a61334ea43ff4c3fd950a00095377cf1e3bfd4/src
/main/java/ru/sbt/test/refactoring/?at=master
 */

@Component
@Scope("prototype")
public class Tractor implements AbsTractor {

    private int[] position = new int[] { 0, 0 };
    private int[] field = new int[] { 5, 5 };

    private Movable move;

    @Autowired
    public Tractor(@Qualifier("east")Movable move){
        this.move=move;
    }

    @PostConstruct
    public  void doMyInit(){
        System.out.println("Tractor created");
    }


    public void move(String command) {
        if (command.equals("F")) {
            moveForwards();
        } else if (command.equals("T")) {
            turnClockwise();
        }
    }

    public void moveForwards() throws TractorInDitchException{
        move.moveForwards(this);
        //if in border of field
        if (position[0] > field[0] || position[1] > field[1]) {
            throw new TractorInDitchException("Out of Field`s bounds!");
        }
        System.out.println("Tractor was moved");
    }

    public void turnClockwise() {
        move.turnClockwise(this);
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setMove(Movable move){
        this.move=move;
    }

    public Movable getMove() {
        return move;
    }
}
