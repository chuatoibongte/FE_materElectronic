package com.example.mater_electronic.network.account;

import com.example.mater_electronic.models.account.Account;
import com.example.mater_electronic.models.account.ChangePassAccountRequest;
import com.example.mater_electronic.models.account.ChangePassAccountResponse;
import com.example.mater_electronic.models.account.GetAccountResponse;
import com.example.mater_electronic.models.account.UpdateAccountResponse;
import com.example.mater_electronic.models.account.UpdateAddressRequest;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.Part;

public interface AccountService {
    //API lấy data Account
    @GET("customer/manageAccount")
    Call<GetAccountResponse> getAccount(@Header("Authorization") String accessToken);
    //API Cập nhật account sử dụng formdata
    @Multipart
    @PATCH("customer/manageAccount")
    Call<UpdateAccountResponse> updateAccount(
            @Header("Authorization") String accessToken,
            @Part("username") RequestBody username,
            @Part("name") RequestBody name,
            @Part("phone") RequestBody phone,
            @Part("birthday") RequestBody birthday,
            @Part("gender") RequestBody gender,
            @Part MultipartBody.Part avatar // Optional image file
    );

    //API Update data Account without image
    @Multipart
    @PATCH("customer/manageAccount")
    Call<UpdateAccountResponse> updateAccountWithoutImage(
            @Header("Authorization") String accessToken,
            @Part("username") RequestBody username,
            @Part("name") RequestBody name,
            @Part("phone") RequestBody phone,
            @Part("birthday") RequestBody birthday,
            @Part("gender") RequestBody gender
    );

    //API Update addressList only
    @PATCH("customer/manageAccount")
    Call<UpdateAccountResponse> updateAddressList(
            @Header("Authorization") String accessToken,
            @Body UpdateAddressRequest request
    );

    //API đổi mật khẩu trong profile
    @PATCH("customer/manageAccount/changepass")
    Call<ChangePassAccountResponse> changePass(
            @Header("Authorization") String accessToken,
            @Body ChangePassAccountRequest request
    );
}
