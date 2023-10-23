package com.rex.bikesort;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int ind,tournum,combo;
        int a;//for the while loop to see if combos
        int Tandem =0,Quad =0;
        int cT,cQ;
        char answer;
        int biggestcombo[]={0,0,0,0,0};
        //int tourtrak=0;
        ArrayList<Tour> tourList = new ArrayList<>();
        //String UserInput;
        try{
            for(tournum=0;tournum<5;tournum++){
                
                System.out.println("Please Enter the number of Tandems (0-11)");
                Tandem = scanner.nextInt();
                if(Tandem>11||Tandem<0)
                throw new IllegalArgumentException("Too many tandems requested.");
                System.out.println("Please Enter the Number of Quads (0-9)");
                Quad = scanner.nextInt();
                if(Quad>9||Quad<0)
                throw new IllegalArgumentException("Too many quads requested.");

                Tour T= new Tour(Tandem, Quad, tournum);
                 tourList.add(T);


                System.out.println("Any Combos? Y/N");
                answer = scanner.next().charAt(0);
                    if((answer=='y')||(answer=='Y')){
                         System.out.println("Please enter the number of combos on this tour");
                    combo = scanner.nextInt();
                    //System.out.println("Please enter a -1 to leave at anytime");
                    for(a=0;a<combo;a++)
                    {
                        ind=a;
                        System.out.println("Combo "+(a+1)+" has ");
                        System.out.println("Number of Tandems:");
                        cT=scanner.nextInt();
                            if(cT>Tandem||cT<0)
                throw new IllegalArgumentException("Too many tandems requested.");
                        System.out.println("Number of Quads:");
                        cQ=scanner.nextInt();
                            if(cT>Quad||cT<0)
                throw new IllegalArgumentException("Too many quads requested.");
                       T.Combination(cT, cQ, ind);
                        

                       Tandem=Tandem-cT;
                       Quad=Quad-cQ;


                    }

                    }
                else if(answer=='n'||answer=='N'){
                    combo=0;
                   

                }
                else{
                    throw new IllegalArgumentException("Non-valid Response. This was Yes or No");
                }
            //T.Display();
            //if(T.combosize()>biggestcombo[tournum]){
                biggestcombo[tournum]=T.combosize();
                //tourtrak=tournum;
            //}

            }

                
            


        
    } catch (IllegalArgumentException e) {
        System.err.println("Error: " + e.getMessage());
    }finally{
    scanner.close();
    }
    
    //this whole piece is just a display
    for (int i = 0; i < tourList.size(); i++) {
        Tour tour = tourList.get(i);
       tour.Display();
    }


    //compare
    {
        int switchlog =0;
        int tm1=0,tm2=0;
        //int qs1=0,qs2=0;
        for(int i =0;i<4;i++){
            Tour t1=tourList.get(i);
            Tour t2=tourList.get(i+1);
            
            if((tm1=t1.Tsize())!=(tm2=t2.Tsize())){
                for(int st = Math.abs(tm1-tm2);st>0;st--){
                    switchlog++;
                }
            }
            if((tm1=t1.Qsize())!=(tm2=t2.Qsize())){
                for(int st = Math.abs(tm1-tm2);st>0;st--){
                    switchlog++;
                }
            }

            Combo c1 = new Combo();
            Combo c2 = new Combo();
            Combo c3 = new Combo();
            Tour finalt = new Tour();


            //this following can successfully detect a match, how then do I ignore the match
            for(int j=t1.combosize();j>0;j--){
                for(int k=t2.combosize();k>0;k--){
                    c1=t1.givecomb(j-1);
                    c2=t2.givecomb(k-1);
                    if(c1.gettan()==c2.gettan()){
                        if(c1.getquad()==c2.getquad()){
                            System.out.println("There is a match!");
                            c3=t2.givecomb(k-1);
                            //then add to arraylist of combos
                            finalt.Combination(c3,i);//dont know if will work

                            
                        }

                    }
                }

                }

        }
            Arrays.sort(biggestcombo); // sorts array from smallest to biggest
            //from here we know that index 4 will always be the most amount of combos and will contain however many combos there are in the biggest
            

            // enter a loop
            //find difference between sizes of biggeest and second biggest 
       
        //each tour has arraylist of combos, each index is a combo which contains #T,#Q,Index
        //cycle through and see if gettan and getquad are the same and then mark that index off.
        // this should?? sort out all the similar combos in which we can use on and on then we can just add any remaining combos to the
        //new list of combos after merging the two. then go back and repeat


        //assume everytour is now 11T,9Q since any size based switches marked above
                //succesfully tracks sized based switches (so far)


        

            

            //invalid arraylist sport gives exception
            /* 
            for(int st=Math.abs(t1.combosize()-t2.combosize());st>0;st--){
            if(i==0)
            {c1=t1.givecomb(st);}//may need to make sure index 'st' is valid 
            else
            {}//c1 = revisedtour combo

            c2=t2.givecomb(st);


            int tannum = c1.gettan()-c2.gettan();
            if(tannum!=0){

            }
            


            }*/
            

       // }        


        System.out.println("The best set up is "+0+" which contains " +switchlog+ " switches" + " " + Arrays.toString(biggestcombo));

    }

}
}






/* 

/*
 * 
 * Use arrayList of objects, those being Tours, made of int T = 11,int Q = 9, vector of int cT, vector of int cQ.
 * 
 * Before even ask anthing, should set up 5 arrays, each with index 0 = 11, index 1 = 9 (represents Tandems and Quads)
 * 
 * 
 * 
 * Enter for loop for 5 times, each time a new tour
 * Asks user for T,Q, (after recieveing T/Q should change the numbers in the array, i.e. 3T entered then change 11 to 3)
 * 
 * Then ask if there are any combos, Y/N. If N move onto the next tour and increment to next rotation of for loop
 * 
 * If Y, then enter new while loop, which will go until user enters a negative.
 * Will say 
 * "Combo 1:
 *  Number of Tandems: (user enters)
 *  Number of Quads: (user enters)"
 * The number of tandems is entered into the first index of cT
 * The number of Quads is entered into the first index of cQ
 * the index indicator will increment every rotation (remeber to set to 0 at the begining of the for loop)
 * 
 * 
 *
 * 
 * Comparison for combos.
 * 
 * First possibility~~~
 * two strings t1, t2 =''
 * take each and make into list of characters i.e. 'TQTTTQ'
 * compare the two tours, and move around characters until they match while meeting criteria of the combos for both (if not possibleget as close as it can, then mark changes needed that cant be accounted for)
 * store this in a new string, compare that with the next tour, then repeat the comparison process.
 * 
 * 
 * Second Possibility~~~
 * every tour has a comblist, could be easy to compare combos this way
 * first look at size differences of T/Q any drops or addons must be added to the switchlog
 * once the size is the same, look at the combos
 * 
 * 
 * 
 * 
 * get the number of tandems from each combo, and the number of quads
 * 
 * 
 */
