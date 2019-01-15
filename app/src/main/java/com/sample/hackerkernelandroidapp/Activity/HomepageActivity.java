package com.sample.hackerkernelandroidapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.sample.hackerkernelandroidapp.NetworkCalling.NetworkServiceCall;
import com.sample.hackerkernelandroidapp.NetworkCalling.OnServiceCallCompleteListener;
import com.sample.hackerkernelandroidapp.NetworkCalling.ServerURL;
import com.sample.hackerkernelandroidapp.R;
import com.sample.hackerkernelandroidapp.SpinnerPojo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomepageActivity extends AppCompatActivity {

    private String api_token;
    private String name;
    private String email;
    private Spinner spinner_Country, spinner_State, spinner_City;
    private String requestName;
    private ArrayList<SpinnerPojo> spinnerCountryArrayList;
    private ArrayList<SpinnerPojo> spinnerStateArrayList;
    private ArrayList<SpinnerPojo> spinnerCityArrayList;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        spinnerCountryArrayList = new ArrayList<>();
        spinnerStateArrayList = new ArrayList<>();
        spinnerCityArrayList = new ArrayList<>();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("LOGIN_PREF", 0);
        api_token = pref.getString("api_token", null);
        name = pref.getString("name", null);
        email = pref.getString("email", null);
        IntrelizeVariables();
        GetCountryData();
    }

    private void IntrelizeVariables() {
        try {
            spinner_Country = (Spinner) findViewById(R.id.spinner_Country);
            spinner_State = (Spinner) findViewById(R.id.spinner_State);
            spinner_City = (Spinner) findViewById(R.id.spinner_City);
            logout = (Button) findViewById(R.id.logout);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences preferences = getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Logout_status", "LOG_OUT");
                    editor.clear();
                    editor.commit();
                    Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GetCountryData() {
        try {
            requestName = "GetCountryData";
            String strCountryUrl = ServerURL.getcountries(api_token);
            NetworkServiceCall serviceCall = new NetworkServiceCall(HomepageActivity.this, true);
            serviceCall.setOnServiceCallCompleteListener(new onServiceCallCompleteListener());
            serviceCall.makeJSONObjectGetStringRequest(strCountryUrl, null, Request.Priority.HIGH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GetStateData(String counterId) {
        try {
            requestName = "GetStateData";
            String strCountryUrl = ServerURL.getstates(counterId, api_token);
            NetworkServiceCall serviceCall = new NetworkServiceCall(HomepageActivity.this, false);
            serviceCall.setOnServiceCallCompleteListener(new onServiceCallCompleteListener());
            serviceCall.makeJSONObjectGetStringRequest(strCountryUrl, null, Request.Priority.HIGH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GetCityData(String stateId) {
        try {
            requestName = "GetCityData";
            String strCountryUrl = ServerURL.getcities(stateId, api_token);
            NetworkServiceCall serviceCall = new NetworkServiceCall(HomepageActivity.this, false);
            serviceCall.setOnServiceCallCompleteListener(new onServiceCallCompleteListener());
            serviceCall.makeJSONObjectGetStringRequest(strCountryUrl, null, Request.Priority.HIGH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToPage3(View view) {

        Intent intent = new Intent(this,activity_page3.class);
        startActivity(intent);

    }

    private class onServiceCallCompleteListener implements OnServiceCallCompleteListener {
        @Override
        public void onJSONObjectResponse(JSONObject jsonObject) {
            if (requestName.equalsIgnoreCase("GetCountryData")) {
                UpdateSpinnerCountryData(jsonObject);
            } else if (requestName.equalsIgnoreCase("GetStateData")) {
                UpdateSpinnerStateData(jsonObject);
            } else if (requestName.equalsIgnoreCase("GetCityData")) {
                UpdateSpinnerCityData(jsonObject);
            }
        }

        @Override
        public void onJSONArrayResponse(JSONArray jsonArray) {

        }

        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }

    private void UpdateSpinnerCountryData(JSONObject jsonObject) {
        try {
            spinnerCountryArrayList = new ArrayList<>();
            if (jsonObject.has("states")) {
                JSONArray statesArray = jsonObject.getJSONArray("states");
                for (int i = 0; i < statesArray.length(); i++) {
                    JSONObject object = statesArray.getJSONObject(i);
                    String id = object.getString("id");
                    String strName = object.getString("name");
                    SpinnerPojo pojo = new SpinnerPojo();
                    pojo.setId(id);
                    pojo.setName(strName);
                    spinnerCountryArrayList.add(pojo);
                }
            }
            String[] str = new String[spinnerCountryArrayList.size()];
            for (int pos = 0; pos < spinnerCountryArrayList.size(); pos++) {
                str[pos] = spinnerCountryArrayList.get(pos).getName();
            }
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_Country.setAdapter(spinnerAdapter);
            spinnerAdapter.notifyDataSetChanged();

            spinner_Country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String counterId = spinnerCountryArrayList.get(position).getId();
                    String counterName = spinnerCountryArrayList.get(position).getName();
                    GetStateData(counterId);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateSpinnerStateData(JSONObject jsonObject) {
        try {
            spinnerStateArrayList = new ArrayList<>();
            if (jsonObject.has("states")) {
                JSONArray statesArray = jsonObject.getJSONArray("states");
                for (int i = 0; i < statesArray.length(); i++) {
                    JSONObject object = statesArray.getJSONObject(i);
                    String id = object.getString("id");
                    String strName = object.getString("name");
                    SpinnerPojo pojo = new SpinnerPojo();
                    pojo.setId(id);
                    pojo.setName(strName);
                    spinnerStateArrayList.add(pojo);
                }
            }
            String[] str = new String[spinnerStateArrayList.size()];
            for (int pos = 0; pos < spinnerStateArrayList.size(); pos++) {
                str[pos] = spinnerStateArrayList.get(pos).getName();
            }
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_State.setAdapter(spinnerAdapter);
            spinnerAdapter.notifyDataSetChanged();

            spinner_State.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String stateId = spinnerStateArrayList.get(position).getId();
                    String counterName = spinnerStateArrayList.get(position).getName();
                    GetCityData(stateId);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateSpinnerCityData(JSONObject jsonObject) {
        try {
            spinnerCityArrayList = new ArrayList<>();
            if (jsonObject.has("cities")) {
                JSONArray statesArray = jsonObject.getJSONArray("cities");
                for (int i = 0; i < statesArray.length(); i++) {
                    JSONObject object = statesArray.getJSONObject(i);
                    String id = object.getString("id");
                    String strName = object.getString("name");
                    SpinnerPojo pojo = new SpinnerPojo();
                    pojo.setId(id);
                    pojo.setName(strName);
                    spinnerCityArrayList.add(pojo);
                }
            }
            String[] str = new String[spinnerCityArrayList.size()];
            for (int pos = 0; pos < spinnerCityArrayList.size(); pos++) {
                str[pos] = spinnerCityArrayList.get(pos).getName();
            }
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_City.setAdapter(spinnerAdapter);
            spinnerAdapter.notifyDataSetChanged();

            spinner_City.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String counterId = spinnerCityArrayList.get(position).getId();
                    String counterName = spinnerCityArrayList.get(position).getName();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
