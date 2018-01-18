import android.content.Intent;

import com.example.jordi.myapplication.MainActivity;

/**
 * Created by Jordi on 18/01/2018.
 */

public class jsronreader {


    public static final String steamID = "steamID";
    public static final String gameName = "gameName";
    public static final String name = "name";
    public static final String value = "value";

    public static final int HOME = 1;


        // web service url constants
        public String crearurl(String id) {
            String URL = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=E590B7B42BC693F80DA538D6DC7DA98F&steamid="+id;
            return URL;
        }


}
