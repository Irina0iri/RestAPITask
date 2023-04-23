package com.example.restapitask;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class JsonUtils {
    @RequestMapping("/user")
    static String createUser() throws IOException, JSONException, ParseException {
        Object o = new JSONParser().parse(new FileReader("src\\main\\resources\\user.json"));
        org.json.simple.JSONObject jsonV1 = (org.json.simple.JSONObject) o;
        String response = jsonV1.toJSONString();
        JSONObject json = new JSONObject(response);
        User user = new User(json.getString("nume"),json.getString("prenume"),json.getInt("varsta"));
        return user.toString();
    }
@RequestMapping("/housesList")
    static String createListOfHouses () throws IOException, ParseException, JSONException {
        Object o = new JSONParser().parse(new FileReader("src\\main\\resources\\homeObject.json"));
        org.json.simple.JSONArray jsonArrayV1 = (org.json.simple.JSONArray) o;
        String response = jsonArrayV1.toJSONString();
        org.json.JSONArray jsonArray = new org.json.JSONArray(response);
        ArrayList<HouseToBuy> housesArray;
        housesArray = new ArrayList<>();
        for(int houseIndex = 0; houseIndex < jsonArray.length(); houseIndex++){
            JSONObject houseObject = jsonArray.getJSONObject(houseIndex);
            housesArray.add(new HouseToBuy(houseObject.getInt("numberOfFloors"),houseObject.getString("quality"),houseObject.getBoolean("SeaView")));

        }
        return housesArray.toString();
    }

    @RequestMapping(value= "/message",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<String> getMessage (@RequestBody Message message,@RequestHeader (value = "authorization",required = false) String headerAuth){
        String text = message.getText();
        if(headerAuth == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else if(headerAuth.equals("devmind-api-key"))
            return new ResponseEntity<>(text,HttpStatus.CREATED);
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
