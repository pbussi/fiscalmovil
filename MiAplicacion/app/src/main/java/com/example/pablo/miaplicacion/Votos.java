package com.example.pablo.miaplicacion;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pablo on 30/09/15.
 */
public class Votos {

     public static boolean resetVotos(Context c){
         try {
             File traceFile = new File(c.getExternalFilesDir(null), "votos.csv");
             FileWriter out = new FileWriter(traceFile);
             out.write("");
             out.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return true;
    }




}
