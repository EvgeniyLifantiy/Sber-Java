package com.Spring.Moves;

import com.Spring.Tractor;
import org.springframework.stereotype.Component;

@Component
public class North implements Movable{

     @Override
     public void moveForwards(Tractor tractor) {
          tractor.setPosition(new int[] {tractor.getPosition()[0] , tractor.getPosition()[1] +1});
     }
     @Override
     public void turnClockwise(Tractor tractor) {
          tractor.setMove(new East());
     }
}
