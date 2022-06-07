package kz.sabyrzhan.rdbmsquarkus.panache.resource;

import kz.sabyrzhan.rdbmsquarkus.jdbc.Artist;
import kz.sabyrzhan.rdbmsquarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/artists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class ArtistResource {
    @Inject
    ArtistRepository artistRepository;

    @GET
    @Path("/{id}")
    public Artist findById(@PathParam("id") Long id) {
        return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> findAll() {
        return artistRepository.listAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Artist addArtist(Artist artist) {
        artistRepository.persist(artist);
        return artist;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @DELETE
    @Path("/{id}")
    public Response deleteArtist(@PathParam("id") long id) {
        artistRepository.deleteById(id);
        return Response.noContent().build();
    }
}
