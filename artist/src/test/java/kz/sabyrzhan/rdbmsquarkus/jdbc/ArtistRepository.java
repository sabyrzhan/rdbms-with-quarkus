package kz.sabyrzhan.rdbmsquarkus.jdbc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {
    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException {
        var sql = "insert into t_artists(id,name,bio,created_date) values(?,?,?,?)";
        try(var connection = dataSource.getConnection();
            var ps = connection.prepareStatement(sql)) {
            artist.setId(Math.abs(new Random().nextLong()));
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.executeUpdate();
        }
    }

    public Artist findById(long id) throws SQLException {
        var sql = "select id,name,bio,created_date from t_artists where id = ?";
        try(var connection = dataSource.getConnection();
            var ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try(var rs = ps.executeQuery()) {
                if (rs.next()) {
                    var artist = Artist.builder()
                            .id(rs.getLong(1))
                            .name(rs.getString(2))
                            .bio(rs.getString(3))
                            .createdDate(rs.getTimestamp(4).toInstant())
                            .build();
                    return artist;
                } else {
                    throw new SQLException("No result found.");
                }
            }
        }
    }
}
