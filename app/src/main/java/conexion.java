import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class conexion implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    String url="http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=730&key=E590B7B42BC693F80DA538D6DC7DA98F&steamid=";

    public void stats(Context context, String id){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
           request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
