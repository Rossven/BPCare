package com.rossven.healty;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;


public class RateService extends Service {

    int[] pressures;

    @Override
    public void onCreate(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    public void setPressuresFunc(){

        pressures = setBloodPressures(Random());
    }



    public static int Random(){
        int possibleMin = 1;
        int possibleMax = 100;

        int posPer = (int)Math.floor(Math.random()*(possibleMax-possibleMin+1)+possibleMin);

        return posPer;
    }

    public static int[] setBloodPressures(int posPer) {

        int random_Diastolic = 0;
        int random_Systolic = 0;
        int stg = 0;

        if( posPer >= 1 && posPer <= 7 ){                                                                  //Düşük
            int minS = 50;
            int maxS = 79;
            int minD = 40;
            int maxD =59;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=1;
        }
        else if( posPer >7 && posPer <= 65 ){                                                              //Normal
            int minS = 80;
            int maxS = 120;
            int minD = 60;
            int maxD =80;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=2;
        }
        else if( posPer > 65 && posPer <= 80 ){                                                              //Yükselmiş
            int minS = 121;
            int maxS = 139;
            int minD = 80;
            int maxD = 89;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=3;
        }
        else if( posPer > 80 && posPer <= 93 ){                                                               //Yüksek Tansiyon Level 1
            int minS = 140;
            int maxS = 159;
            int minD = 90;
            int maxD = 99;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=4;
        }
        else if( posPer >93 && posPer <= 97 ){                                                                //Yüksek Tansiyon Level 2
            int minS = 160;
            int maxS = 179;
            int minD = 100;
            int maxD = 110;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=5;
        }
        else if( posPer > 97 && posPer <= 100 ){                                                              //Hiper Tansiyon
            int minS = 180;
            int maxS = 200;
            int minD = 110;
            int maxD = 120;
            random_Diastolic = (int)Math.floor(Math.random()*(maxD-minD+1)+minD);
            random_Systolic = (int)Math.floor(Math.random()*(maxS-minS+1)+minS);
            stg=6;
        }


        return new int[]{ random_Systolic, random_Diastolic,stg};
    }

    public static String Stages(int[] pressures){

        String stage = null;
        
        if(pressures[2]==1){
            stage="Düşük Tansiyon";
        }
        else if(pressures[2]==2){
            stage= "Normal Tansiyon";
        }
        else if(pressures[2]==3){
            stage= "Yükselmiş Tansiyon";
        }
        else if(pressures[2]==4){
            stage= "Yüksek Tansiyon Level 1";
        }
        else if(pressures[2]==5){
            stage= "Yüksek Tansiyon Level 2";
        }
        else if(pressures[2]==6){
            stage= "Hiper Tansiyon";
        }
            
        return stage;
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}