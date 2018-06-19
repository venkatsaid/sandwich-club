package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich;
        JSONObject name;
        String mainName ="";
        List<String> alsoKnownAs=new ArrayList<>();
        String placeOfOrigin ="";
        String description ="";
        String image="";
        List<String> ingredients=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(json);
            name=jsonObject.getJSONObject("name");
            mainName=name.getString("mainName");
            JSONArray jsonArray_alsoKnownAs=name.getJSONArray("alsoKnownAs");
            if (jsonArray_alsoKnownAs.length()!=0){
                for (int i=0;i<jsonArray_alsoKnownAs.length();i++){
                    alsoKnownAs.add(jsonArray_alsoKnownAs.getString(i));
                }
            }
            placeOfOrigin=jsonObject.getString("placeOfOrigin");
            description=jsonObject.getString("description");
            image=jsonObject.getString("image");
            JSONArray jsonArray_ingredients = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < jsonArray_ingredients.length(); i++) {
                ingredients.add(jsonArray_ingredients.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        sandwich=new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
        return sandwich;
    }
}
