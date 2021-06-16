package io.quarkus.samples.petclinic.security;

import io.quarkus.samples.petclinic.rest.MediaTypes;

import org.h2.engine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("api/v1")
@PermitAll
@Produces(MediaTypes.APPLICATION_JSON_UTF8)
@Consumes(MediaTypes.APPLICATION_JSON_UTF8)
public class AuthResource {

    private static final Logger log = LoggerFactory.getLogger("AuthResource");

    @POST
    public Response authorize(@Context SecurityContext sc) {
        Principal userPrincipal = sc.getUserPrincipal();

        log.info("Security context: "+sc);

        return null;
    }


    @POST
    @Path("auth1/login1")
    public Response login1(LoginData logindata) {
        //log.info("Security context: "+logindata.email );
        //if(logindata.email == "chicong115@gmail.com"){

        LoginDataResult data = new LoginDataResult();
        data.email = "chicong115@gmail.com";
        data.userRole = "ADMIN";
        return Response.ok(data).build();

       // }else{
       //     LoginDataResult data = new LoginDataResult();
       //     data.email = "chicong115@gmail.com";
       //     data.userRole = "USER";
       //     return Response.ok(data).build();

        //}
    }


    @GET
    @Path("users/info")
    public Response login1() {
        //==> parse token 
        io.quarkus.samples.petclinic.model.User user = 
        new io.quarkus.samples.petclinic.model.User();
        user.setLastName("lastName");

        user.setFirstName("lastName");

        user.setEmail("lastName");

        user.setId(1000);

        user.setActive(true);

        user.setAddress("199 Nguyen Hoang");
        return Response.ok(user).build();


    }


    



}
