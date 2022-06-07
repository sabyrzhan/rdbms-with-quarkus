package kz.sabyrzhan.rdbmsquarkus.panache.resource;

import kz.sabyrzhan.rdbmsquarkus.panache.model.Publisher;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/publishers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublisherResource {
    @GET
    @Path("/{id}")
    public Publisher findById(@PathParam("id") Long id) {
        return Publisher.<Publisher>findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findAll() {
        return Publisher.listAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Publisher addPublisher(Publisher publisher) {
        Publisher.persist(publisher);
        return publisher;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @DELETE
    @Path("/{id}")
    public Response deletePublisher(@PathParam("id") long id) {
        Publisher.deleteById(id);
        return Response.noContent().build();
    }
}
