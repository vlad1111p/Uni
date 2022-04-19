

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SaveLoad {
    public static void save(Path path, ZeichenBlatt zeichenBlatt) {
    	GsonBuilder builder = new GsonBuilder();
    	builder.registerTypeAdapter(Figur.class, new FigurSerialization());
        Gson gson = builder.create();
        String json = gson.toJson(zeichenBlatt);
        System.out.println(path.toString());
        try {
        Files.write(path, json.getBytes());
        } catch (IOException e) {
        	throw new RuntimeException("Es ist ein Fehler beim Speichern aufgetreten");
        }
    }

    public static void load(Path path, ZeichenBlatt zeichenBlatt) {
        //TODO
    	GsonBuilder builder = new GsonBuilder();
    	builder.registerTypeAdapter(Figur.class, new FigurSerialization());
        Gson gson = builder.create();
    	ZeichenBlatt nzb;
 
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(path.toString()));    	
       		nzb = gson.fromJson(reader, ZeichenBlatt.class);    		
    		zeichenBlatt.setFiguren(nzb.getFiguren());
    		//OPTIONAL
    		zeichenBlatt.setFuellFarbe(nzb.getFuellFarbe());
    		zeichenBlatt.setLinienFarbe(nzb.getLinienFarbe());

    	} catch (FileNotFoundException e) {
    		throw new RuntimeException("Es ist ein Fehler beim Laden aufgetreten");
    	}
    } 

}

