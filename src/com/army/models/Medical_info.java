package com.army.models;

import com.army.models.interfaces.i_medical_info;

public class Medical_info extends ID implements i_medical_info {
    private double height;
    private double weight;
    private double vision;
    private boolean fit_to_army;

    public Medical_info(double height, double weight, double vision){
        setHeight(height);
        setWeight(weight);
        setVision(vision);
        this.fit_to_army = define_fit_to_army(height,weight,vision);
    }
    public Medical_info(int id,double height, double weight, double vision){
        setId(id);
        setHeight(height);
        setWeight(weight);
        setVision(vision);
        this.fit_to_army = define_fit_to_army(height,weight,vision);
    }

    public Medical_info(int id, double height, double weight, double vision,boolean fit_to_army){
        super(id);
        setHeight(height);
        setWeight(weight);
        setVision(vision);
        setFit_to_army(fit_to_army);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVision() {
        return vision;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }

    public boolean isFit_to_army() {
        return fit_to_army;
    }

    public void setFit_to_army(boolean fit_to_army) {
        this.fit_to_army = define_fit_to_army(height,weight,vision); ;
    }

    @Override
    public String toString() {
        String res;
        if(fit_to_army){
            res = "Fit for duty!";
        }
        else {
            res = "Unfit for service(";
        }
        return "Candidate №" +getId()+
                " Height: " + height +
                " Weight: " + weight +
                " Vision: " + vision+
                " RESULT: " + res;
    }

    @Override
    public boolean define_fit_to_army(double height, double weight, double vision) {
        double average_ratio_of_height_and_weight = height/weight;
        boolean y = (vision >= -2 && vision <= 2);
        boolean x =(average_ratio_of_height_and_weight>=0.3);
        return (x&&y);
    }
}
