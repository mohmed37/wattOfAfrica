package com.client.service;

import com.client.controler.OrthoGramComtroler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

public class CustomTimer extends TimerTask {
    @Autowired
    OrthoGramComtroler orthoGramComtroler;
    int time =10;
    @Override
    public void run() {
        if (time==0){
            orthoGramComtroler.saveOrthoGram("null");
            cancel();
        }
        time--;
    }
}
