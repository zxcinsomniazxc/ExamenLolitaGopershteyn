package com.example.examenlolitagopershteyn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView btnLogin;
    EditText edEmail, edPassword;
    TextView noAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.signin);
btnLogin = findViewById(R.id.btnLogin);
edEmail = findViewById(R.id.edEmail);
edPassword = findViewById(R.id.edPassword);
noAccount = findViewById(R.id.noAccount);
noAccount.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
}
});
btnLogin.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
loginUser();
}
});
}
public void loginUser(){
LoginRequest loginRequest = new LoginRequest();
loginRequest.setEmail(edEmail.getText().toString());
loginRequest.setPassword(edPassword.getText().toString());
Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
loginResponseCall.enqueue(new Callback<LoginResponse>() {
@Override
public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
if (response.isSuccessful()){
LoginResponse loginResponse = response.body();
String message = Integer.toString(loginResponse.getToken());
Toast.makeText(LoginActivity.this, message ,Toast.LENGTH_LONG).show();
startActivity(new Intent(LoginActivity.this, MainActivityNew.class));
finish();
}else{
}
}
@Override
public void onFailure(Call<LoginResponse> call, Throwable t) {
String message = t.getLocalizedMessage();
Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
}
});
    }
}
