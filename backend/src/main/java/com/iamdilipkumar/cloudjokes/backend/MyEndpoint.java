/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.iamdilipkumar.cloudjokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.cloudjokes.iamdilipkumar.com",
                ownerName = "backend.cloudjokes.iamdilipkumar.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that will produce a joke
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke(MyBean bean) {
        return bean;
    }

}
