package com.royalsoftsolutions.apicallvollyjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private RequestQueue requestQueue;
    private  Map<String, String>  paramsMap;
    private  Context context;

    //private val paramsMap: Map<String, String>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        textView = findViewById ( R.id.tv_result );
        button = findViewById ( R.id.button );
        requestQueue = Volley.newRequestQueue ( this );
        //String abc = ;

        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                String url = "https://pathocarepatan.com/gsfinance/ws/gsfsjsonapi.php";
                StringRequest stringRequest = new StringRequest ( Request.Method.POST, url, new Response.Listener<String> ( ) {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText ( MainActivity.this, "done" +response,
                                Toast.LENGTH_SHORT ).show ();

                    }
                }, new Response.ErrorListener ( ) {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText ( MainActivity.this, "Error" +error.getMessage(), Toast.LENGTH_SHORT ).show ();
                    }
                } )

                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<String, String>();
                        headers.put (  "Apikey","GSFS") ;
                        headers.put (  "Userdevicetype","android") ;


                        headers.put (  "Userdevicetoken","") ;
                        headers.put("Userdeviceid",
                                Settings.Secure.getString(getContentResolver (), Settings.Secure.ANDROID_ID));
                        headers.put (  "Userid","1") ;


                        return headers;
                    }

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {


                        String email_mobile ="1234567810";
                        String password = "12345678";
                        String login = "";
                        String userId = "0";
                        String deviceId = "";
                        String token = "";
                       // dialog2.show ( );

                        Map<String, String> params = new HashMap ( );
                        params.put ( "ACTION_CALL_FUNCTION", "login" );
                        params.put ( "action", "login" );
                        params.put ( "email_mobile", email_mobile );
                        params.put ( "password", password );
                        params.put ( "userId", userId );
                        params.put ( "deviceId", deviceId );
                        params.put ( "token", token );
                        Log.d ( "Params=", "ACTION_CALL_FUNCTION : login" );
                        Log.d ( "Params=", "email_mobile : " + email_mobile );
                        Log.d ( "Params=", "password : " + password );


                       /* Map<String,String>params = new HashMap<> (  );
                        params.put ( "string", "hiren" );
                        *//*params.put ( "ACTION_CALL_FUNCTION", "userdailyreportdetails" );
                        params.put ( "umid", "20" );
                        params.put ( "clientId", "0" );
                        params.put ( "drdate", "2021-2-11" );*/

                        return params;
                    }


                };

                requestQueue.add ( stringRequest );







               /* jsonparse();*/
            }
        } );
    }




   /* private void jsonparse() {






        Map<String, String> params = new HashMap ( );
        params.put ( "ACTION_CALL_FUNCTION", "userdailyreportdetails" );
        params.put ( "umid", "20" );
        params.put ( "clientId", "0" );
        params.put ( "drdate", "2021-2-11" );

        Log.d ( "Params=", "ACTION_CALL_FUNCTION : login" );







        String url = "";
        JsonObjectRequest request = new JsonObjectRequest ( Request.Method.POST, url, params,
                new Response.Listener<JSONObject> ( ) {
            @Override
            public void onResponse(JSONObject response) {
                try {



                  JSONObject jsonObject = new JSONObject (  );
                  jsonObject =  response.getJSONObject ( "result" );
                 String jsonstring = jsonObject.toString ();



                } catch (JSONException e) {
                    e.printStackTrace ( );
                }
                //Log.d ( "Result",jsonObject.toString ());

            }
        }, new Response.ErrorListener ( ) {
            @Override
            public void onErrorResponse(VolleyError error) {
            error.printStackTrace ();
            }
        } );
    }*/
}