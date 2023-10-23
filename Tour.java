package com.rex.bikesort;

import java.util.ArrayList;

public class Tour {

    private int T = 11;
private int Q = 9;
private int ID=0;
private ArrayList<Combo> comblist =new ArrayList<>();


public Tour(){

}

public Tour(int T,int Q, int ID){
    this.T=T;
    this.Q=Q;
    this.ID=ID+1;
    
}

public void Display(){
    System.out.println("Tour "+ this.ID+ " has ");
    System.out.println("Tandems = " + this.T);
    System.out.println("Quads = " + this.Q);
    if(comblist.isEmpty()){
        System.out.println("There are no Combos on this Tour");
    }
    else{
        System.out.println("There are " +comblist.size()+" Combos");
        Combo b = new Combo();
        for(int a =0;a<comblist.size();a++)
        {
            b=comblist.get(a);
            b.read();
        }
    }
}

public void Combination(int cT,int cQ,int Index){
 Combo c = new Combo(cT,cQ,Index);
 comblist.add(Index, c);

}

public void Combination(Combo c,int Index){

    comblist.add(Index, c);
}

public int Tsize(){
    return T;
}

public int Qsize(){
    return Q;
}

public int combosize()
{
    return comblist.size();
}

public Combo givecomb(int ID){
    return comblist.get(ID);
}

}