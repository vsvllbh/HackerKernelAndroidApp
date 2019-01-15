package com.sample.hackerkernelandroidapp.NetworkCalling;
/**
 * Created by Niladri on 1/28/2017.
 */

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ServerURL {


    //https://www.getpostman.com/collections/741b614919ffda3ab558
    public static String getCollections() {
        return "https://www.getpostman.com/collections/741b614919ffda3ab558";
    }

    //http://139.59.87.150/imakeprofile/public/api/countries?api_token=H2Y6wI6itQycNLPwoRI5BwrCBAodEFY7G21m3d9ueQW2zAWQGh8jYTQwAMcH43IVCgJKmrO8eVJmnzJNrc2guMYOZzOGlNHDFZ9k
    public static String getcountries(String apiKey) {
        return "http://139.59.87.150/imakeprofile/public/api/countries?api_token=" + apiKey;
    }

    //http://139.59.87.150/imakeprofile/public/api/states/101?api_token=H2Y6wI6itQycNLPwoRI5BwrCBAodEFY7G21m3d9ueQW2zAWQGh8jYTQwAMcH43IVCgJKmrO8eVJmnzJNrc2guMYOZzOGlNHDFZ9k
    public static String getstates(String countrieId, String apiKey) {
        return "http://139.59.87.150/imakeprofile/public/api/states/" + countrieId + "?api_token=" + apiKey;
    }

    //http://139.59.87.150/imakeprofile/public/api/cities/21?api_token=H2Y6wI6itQycNLPwoRI5BwrCBAodEFY7G21m3d9ueQW2zAWQGh8jYTQwAMcH43IVCgJKmrO8eVJmnzJNrc2guMYOZzOGlNHDFZ9k
    public static String getcities(String stateId, String apiKey) {
        return "http://139.59.87.150/imakeprofile/public/api/cities/" + stateId + "?api_token=" + apiKey;
    }

    //http://139.59.87.150/imakeprofile/public/api/company/login?email=yash@gmail.com&password=123456
    public static String getLogin() {
        return "http://139.59.87.150/imakeprofile/public/api/company/login";
    }

}

