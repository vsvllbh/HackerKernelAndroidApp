package com.sample.hackerkernelandroidapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.sample.hackerkernelandroidapp.NetworkCalling.NetworkServiceCall;
import com.sample.hackerkernelandroidapp.NetworkCalling.OnServiceCallCompleteListener;
import com.sample.hackerkernelandroidapp.NetworkCalling.ServerURL;
import com.sample.hackerkernelandroidapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_email, edit_password;
    private Button btn_login;
    String strEmail, strPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntializeVariables();
    }

    private void IntializeVariables() {
        try {
            edit_email = (EditText) findViewById(R.id.edit_email);
            edit_password = (EditText) findViewById(R.id.edit_password);
            btn_login = (Button) findViewById(R.id.btn_login);
            btn_login.setOnClickListener(this);
            edit_email.setText("yash@gmail.com");
            edit_password.setText("123456");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                clickLoginButton();
                break;
        }
    }

    private void clickLoginButton() {
        if (Validation())
            try {
                String loginUrl = ServerURL.getLogin();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("email", strEmail);
                hashMap.put("password", strPassword);
                NetworkServiceCall serviceCall = new NetworkServiceCall(LoginActivity.this, true);
                serviceCall.setOnServiceCallCompleteListener(new ServiceCallCompleteListene());
                serviceCall.makeJSONObjectPostStringRequest(loginUrl, hashMap, Request.Priority.HIGH);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private boolean Validation() {
        boolean staus = true;
        strEmail = edit_email.getText().toString().trim();
        strPassword = edit_password.getText().toString().trim();

        if (TextUtils.isEmpty(strEmail)) {
            edit_email.setError("Please enter your email");
            edit_email.setFocusable(true);
            staus = false;
        } else if (TextUtils.isEmpty(strPassword)) {
            edit_password.setError("Please enter your password");
            edit_password.setFocusable(true);
            staus = false;
        }

        return staus;
    }

    private class ServiceCallCompleteListene implements OnServiceCallCompleteListener {
        @Override
        public void onJSONObjectResponse(JSONObject jsonObject) {
            GetLoginServicesJSON(jsonObject);

        }

        @Override
        public void onJSONArrayResponse(JSONArray jsonArray) {

        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(LoginActivity.this, "Please enter valide Login details", Toast.LENGTH_SHORT).show();
        }
    }

    private void GetLoginServicesJSON(JSONObject jsonObject) {
        try {
            if (jsonObject.has("user")) {
                JSONObject objUser = jsonObject.getJSONObject("user");
                String api_token = objUser.getString("api_token");
                String name = objUser.getString("name");
                String email = objUser.getString("email");
                storeApiKeyInPref(api_token, name, email);
                Toast.makeText(LoginActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
            if (jsonObject.has("errors")) {
                JSONObject objerrors = jsonObject.getJSONObject("errors");
                JSONArray arrayemail = objerrors.getJSONArray("email");
                String strEmailError = arrayemail.getString(0);
                Toast.makeText(LoginActivity.this, strEmailError + "", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeApiKeyInPref(String api_token, String name, String email) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("LOGIN_PREF", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("api_token", api_token);
        editor.putString("name", name);
        editor.putString("email", email);
        editor.commit();
    }
}
