//package com.mygdx.spiky_bird.birdBehaviour;
//
//import com.mygdx.spiky_bird.sprites.BirdAnimation;
//
///**
// * Created by commandcentral on 9/14/2017.
// */
//
//public class BirdDescendant implements BirdBehaviour {
//    @Override
//    public void jump() {
//
//    }
//
//    @Override
//    public void update() {
//        if (velocity.y>0){
//            BirdAnimation.getInstance().getAnimation().setFrameDuration(0.1f);
//        } else BirdAnimation.getInstance().getAnimation().setFrameDuration(0.3f);
//        if (position.y > 0) {
//            velocity.add(0, GRAVITY, 0);
//        }
//        velocity.scl(dt);
//        position.add(MOVEMENT * dt, velocity.y, 0);
//        if (position.y < 0) {
//            position.y = 0;
//        }
//        velocity.scl(1 / dt);
//        bounds.setPosition(position.x, position.y);
//    }
//}
