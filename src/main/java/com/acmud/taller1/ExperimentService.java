package com.acmud.taller1;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component("experimentService")
@Lazy
public class ExperimentService {

	public ExperimentService() {
        System.out.println("ExperimentService");

    } 
    public void run() {
        System.out.println("algo");
    }

}