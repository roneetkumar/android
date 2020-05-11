package com.example.finalexam2020roneetkumar;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.finalexam2020roneetkumar.model.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//RONEET KUMAR

public class FileManagement {

   public static ArrayList<Client> readFile(Context context, String filename){

       ArrayList<Client> clients = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open(filename));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = bufferedReader.readLine();

            while (line != null){
                StringTokenizer str = new StringTokenizer(line,"$");

                String cid = str.nextToken().toLowerCase();
                String cname = str.nextToken().toLowerCase();
                String city = str.nextToken().toLowerCase();
                Double subTotal = Double.valueOf(str.nextToken().toLowerCase());
                String clientType = str.nextToken().toUpperCase();

                if (subTotal > 0 && (clientType.equalsIgnoreCase("vip") || clientType.equalsIgnoreCase("new") || clientType.equalsIgnoreCase("reg"))){
                    Client client = new Client(cid,cname,city,subTotal,clientType);
                    clients.add(client);
                }

                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            inputStreamReader.close();

        }catch (IOException ex){
            Log.d( "readFile: ",ex.getMessage());
        }
        return clients;
   }
}
