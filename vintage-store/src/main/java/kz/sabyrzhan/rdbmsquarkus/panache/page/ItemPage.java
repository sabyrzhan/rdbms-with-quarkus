package kz.sabyrzhan.rdbmsquarkus.panache.page;

import io.quarkus.panache.common.Sort;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import kz.sabyrzhan.rdbmsquarkus.panache.model.Book;
import kz.sabyrzhan.rdbmsquarkus.panache.model.CD;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/page/items")
@Produces(MediaType.TEXT_HTML)
public class ItemPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance book(Book book);
        public static native TemplateInstance books(List<Book> books);
        public static native TemplateInstance cd(CD cd);
        public static native TemplateInstance cds(List<CD> cds);
    }

    @GET
    @Path("/books/{id}")
    public TemplateInstance showBookById(@PathParam("id") Long id) {
        return Templates.book(Book.findById(id));
    }

    @GET
    @Path("/books")
    public TemplateInstance showAllBooks(@QueryParam("page") @DefaultValue("1") int page,
                                         @QueryParam("sort") @DefaultValue("id") String sort) {
        return Templates.books(Book.findAll(Sort.by(sort)).page(page - 1, 10).list());
    }

    @GET
    @Path("/cds/{id}")
    public TemplateInstance showCDById(@PathParam("id") Long id) {
        return Templates.cd(CD.findById(id));
    }

    @GET
    @Path("/cds")
    public TemplateInstance showAllCDs(@QueryParam("page") @DefaultValue("1") int page,
                                       @QueryParam("sort") @DefaultValue("id") String sort) {
        return Templates.cds(CD.findAll(Sort.by(sort)).page(page - 1, 10).list());
    }
}
