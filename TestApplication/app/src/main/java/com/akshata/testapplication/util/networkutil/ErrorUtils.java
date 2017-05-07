package com.akshata.testapplication.util.networkutil;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by Replete Android on 10/12/2016.
 */
public class ErrorUtils {

/*
    public static ResponseMessageWrapper parseError(Response<?> response, Retrofit retrofit) {

        Converter<ResponseBody, ResponseMessageWrapper> converter =
                retrofit.responseBodyConverter(ResponseMessageWrapper.class, new Annotation[0]);

        ResponseMessageWrapper error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ResponseMessageWrapper();
        }

        return error;
    }*/

}
