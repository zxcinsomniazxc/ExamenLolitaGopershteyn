package com.example.examenlolitagopershteyn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersAPI {
    @GET("auth/user")
    Call<List<Users>> getData();
}
