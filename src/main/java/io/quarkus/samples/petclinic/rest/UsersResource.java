package io.quarkus.samples.petclinic.rest;

import io.quarkus.samples.petclinic.dto.order.OrderRequestDto;
import io.quarkus.samples.petclinic.dto.perfume.GraphQLRequestDto;
import io.quarkus.samples.petclinic.dto.perfume.PerfumeSearchRequestDto;
import io.quarkus.samples.petclinic.model.Order;
import io.quarkus.samples.petclinic.model.Owner;
import io.quarkus.samples.petclinic.model.Perfume;
import io.quarkus.samples.petclinic.security.Roles;
import io.quarkus.samples.petclinic.service.ClinicService;
import io.quarkus.samples.petclinic.service.OrderService;
import io.quarkus.samples.petclinic.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/api/v1/users")
@GraphQLApi
@Produces(MediaTypes.APPLICATION_JSON_UTF8)
@Consumes(MediaTypes.APPLICATION_JSON_UTF8)
public class UsersResource {

    @Inject
    ClinicService clinicService;

    @Inject
    OrderService orderService;


    @POST
    @Path("/cart")
    public Response getCart(List<Long> perfumeIds) {
        Collection<Perfume> perfumes  = clinicService.findByIdIn(perfumeIds);
        return Response.ok(perfumes).build();
    }


    


    @POST
    @Path("/order")
    public Response postOrder(@RequestBody OrderRequestDto order) {
        Order order1 = new Order();
        Order result = orderService.saveOrder(order1);
        order1.id = (long) 1;
        return Response.ok(order1).build();
    }



    @POST
    @Path("/orders")
    public Response userOrders(@RequestBody OrderRequestDto order) {
        List<Order> order1 = new ArrayList<Order>();
        Order order0 = new Order();
        order1.add(order0);
       
        return Response.ok(order1).build();
    }


}
