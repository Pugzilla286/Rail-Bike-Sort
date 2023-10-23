package com.rex.bikesort;

public class Combo {
    private int Tandem;
    private int Quad;
    private int Index;

    public Combo(){

    }

    public Combo(int Tandem,int Quad, int Index){
        this.Tandem=Tandem;
        this.Quad=Quad;
        this.Index=Index;
    }

    public void read(){
        System.out.println("There are "+Tandem+" Tandems and "+Quad+" Quads in combo "+(Index+1));
    }

    public int gettan(){
        return this.Tandem;
    }

    public int getquad(){
        return this.Quad;
    }
}