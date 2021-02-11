package com.Refactor;

import com.Refactor.Tractor.Moves.East;
import com.Refactor.Tractor.Tractor;
import com.Refactor.Tractor.TractorInDitchException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class testTractor {

    Tractor tractor=new Tractor(new East());

    @Test
    public void testTurnClockwise(){

        //created with East
        Assert.assertTrue(tractor.getMove().getClass().toString().endsWith("East"));

        //turn,must be East -> South -> West -> North ->East
        tractor.turnClockwise();
        Assert.assertTrue(tractor.getMove().getClass().toString().endsWith("South"));

        tractor.turnClockwise();
        Assert.assertTrue(tractor.getMove().getClass().toString().endsWith("West"));

        tractor.turnClockwise();
        Assert.assertTrue(tractor.getMove().getClass().toString().endsWith("North"));

        tractor.turnClockwise();
        Assert.assertTrue(tractor.getMove().getClass().toString().endsWith("East"));

    }

    @Test
    public void testMoveForwards(){

        System.out.println("Start position \n"+Arrays.toString(tractor.getPosition()));


        tractor.moveForwards();
        Assert.assertTrue(tractor.getPositionX()==1 && tractor.getPositionY()==0);


        tractor.turnClockwise();
        tractor.moveForwards();
        Assert.assertTrue(tractor.getPositionX()==1 && tractor.getPositionY()==-1);


        tractor.turnClockwise();
        tractor.moveForwards();
        Assert.assertTrue(tractor.getPositionX()==0 && tractor.getPositionY()==-1);


        tractor.turnClockwise();
        tractor.moveForwards();
        System.out.println("Return to Start");
        Assert.assertTrue(tractor.getPositionX()==0 && tractor.getPositionY()==0);


        System.out.println("Test exception");
        tractor.moveForwards();
        tractor.moveForwards();
        tractor.moveForwards();
        tractor.moveForwards();
        tractor.moveForwards();
        try {
            tractor.moveForwards();

        } catch (TractorInDitchException e){
            System.out.println(e.getMessage());
        }



    }
}
