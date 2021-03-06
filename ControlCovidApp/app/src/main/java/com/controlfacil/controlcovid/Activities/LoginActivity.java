package com.controlfacil.controlcovid.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.controlfacil.controlcovid.API.Services.TareasService;
import com.controlfacil.controlcovid.API.TareasAPI;
import com.controlfacil.controlcovid.R;
import com.controlfacil.controlcovid.Models.Tarea;

import android.util.Patterns;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences prefs;

    private EditText editTextEmail;
    private String eMail;

    private EditText editTextPassword;
    private String passw;

    private Switch switchRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // btnLogin = findViewById(R.id.buttonLogin);
        bindUI();
        prefs = getSharedPreferences("Preferences", this.MODE_PRIVATE);
        setCredentialsIfExist();

        loadTareasFromAPI();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (login(email, password)) {
                    Intent i = new Intent(LoginActivity.this, TareasActivity.class);
                    startActivity(i);
                    saveOnPreferences(email, password);
                }
            }
        });
    }



        private static String getUserMailPrefs(SharedPreferences preferences) {
            return preferences.getString("email", "");
        }

        private static String getUserPassPrefs(SharedPreferences preferences) {
            return preferences.getString("pass", "");
        }

        private void removeSharedPreferences(SharedPreferences preferences) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("email");
            editor.remove("pass");
            editor.apply();
        }


    private void bindUI() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        switchRemember = (Switch) findViewById(R.id.switchRemember);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
    }

    private void setCredentialsIfExist() {
        eMail = getUserMailPrefs(prefs);
        passw = getUserPassPrefs(prefs);
        if (!TextUtils.isEmpty(eMail) && !TextUtils.isEmpty(passw)) {
            editTextEmail.setText(eMail);
            editTextPassword.setText(passw);
            switchRemember.setChecked(true);
        }
    }

    private boolean login(String email, String password) {
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Email is not valid, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidPassword(password)) {
            Toast.makeText(this, "Password is not valid, 4 characters or more, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private void saveOnPreferences(String email, String password) {
        if (switchRemember.isChecked()) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", email);
            editor.putString("pass", password);
            editor.apply();
        }
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 4;
    }

    private String loadTareasFromAPI() {
        String outputString;
        List<Tarea> lasTareas;
        Call<List<Tarea>> tareaCall;
        Tarea unaTarea;

        TareasService service = TareasAPI.getApi().create(TareasService.class);

            tareaCall = service.getTareasAll("todos");
            tareaCall.enqueue(new Callback<List <Tarea>>() {
                @Override
                public void onResponse(Call<Tarea> call, Response<Tarea> response) {
                    Tarea unaTarea = response.body();
                    setResult(unaTarea);
                }

                @Override
                public void onFailure(Call<Tarea> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });
    }

    private void setResult(Tarea unaTarea) {
 //       textViewcity.setText(city.getName() + ", " + city.getCountry());
 //       textViewDescription.setText(city.getDescription());
 //       textViewTemp.setText(city.getTemperature() + "ºC");
 //       Picasso.with(this).load(API.BASE_ICONS + city.getIcon() + API.EXTENSION_ICONS).into(img);
    }

}

