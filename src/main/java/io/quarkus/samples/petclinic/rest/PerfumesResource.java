package io.quarkus.samples.petclinic.rest;

import io.quarkus.samples.petclinic.dto.perfume.GraphQLRequestDto;
import io.quarkus.samples.petclinic.dto.perfume.PerfumeSearchRequestDto;
import io.quarkus.samples.petclinic.model.Owner;
import io.quarkus.samples.petclinic.model.Perfume;
import io.quarkus.samples.petclinic.security.Roles;
import io.quarkus.samples.petclinic.service.ClinicService;
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
import java.util.Collection;
import java.util.List;

@Path("/api/v1")
@GraphQLApi
@Produces(MediaTypes.APPLICATION_JSON_UTF8)
@Consumes(MediaTypes.APPLICATION_JSON_UTF8)
public class PerfumesResource {

    @Inject
    ClinicService clinicService;


    @POST
    @Path("/perfume")
    public Response addPerfume(@Valid Perfume perfume) {
        perfume = clinicService.savePerfume(perfume);
        URI uri = URI.create(String.format("/api/perfume/%s", perfume.getId()));
        return Response.ok(perfume).location(uri).build();
    }

    @GET
    @Path("/perfume/{perfumeId}")
    public Response getPerfume(@PathParam("perfumeId") long perfumeId) {
        Perfume perfume = clinicService.findPerfumeById(perfumeId);
        if (perfume == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(perfume).build();
    }

    @GET
    @Path("/perfume/list")
    public Response getPerfumesList(@QueryParam("perfumeTittle") String perfumeTittle) {
        if (perfumeTittle == null) {
            perfumeTittle = "";
        }
        Collection<Perfume> perfumes = clinicService.findPerfumeByPerfumeTitle(perfumeTittle);
        return Response.ok(perfumes).build();
    }

    @GET
    @Path("/perfumes")
    public Response getPerfumes() {
        Collection<Perfume> perfumes = clinicService.findPerfumeByPerfumeTitle("");
        return Response.ok(perfumes).build();
    }

    @PUT
    @Path("/perfume/{perfumeId}")
    public Response updatePerfume(@PathParam("perfumeId") long perfumeId, @Valid Perfume perfume) {
        perfume = clinicService.updatePerfume(perfumeId, perfume);
        if (perfume == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        URI uri = URI.create(String.format("/api/perfume/%s", perfume.getId()));
        return Response.ok(perfume).location(uri).build();
    }

    @POST
    @Path("/perfumes/search")
    public Response searchPerfume(PerfumeSearchRequestDto perfumeSearchRequestDto) {
        Collection<Perfume> perfumes = clinicService.findPerfumeByRequest(perfumeSearchRequestDto);
        return Response.ok(perfumes).build();

    }

    @Query("allPerfumes")
    @Description("Get all Perfumes from store")
    public Collection<Perfume> getAllPerfumes() {
        Collection<Perfume> perfumes = clinicService.findPerfumeByPerfumeTitle("");
        return perfumes;
    }

    @POST
    @Path("/perfumes/graphql/perfumes")
    public Response getPerfumeByQuery(GraphQLRequestDto request) {
        Collection<Perfume> perfumes = clinicService.findPerfumeByPerfumeTitle("");
        return Response.ok(perfumes).build();
    }

    @POST
    @Path("/perfumes/search/perfumer")
    public Response getPerfumeByPerfumer(String perfumer) {
        Collection<Perfume> perfumes = clinicService.findPerfumeByPerfumer("perfumer");
        return Response.ok(perfumes).build();
    }

    // @PostMapping("/graphql/perfume")
    // public ResponseEntity<ExecutionResult> getPerfumeByQuery(@RequestBody
    // GraphQLRequestDto request) {
    // return
    // ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
    // }

}
