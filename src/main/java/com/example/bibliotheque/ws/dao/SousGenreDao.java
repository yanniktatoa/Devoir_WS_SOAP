package com.example.bibliotheque.ws.dao;

import com.example.bibliotheque.ws.model.Genre;
import com.example.bibliotheque.ws.model.SousGenre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SousGenreDao {

    public SousGenre create(long genreId, String nom, String description) throws SQLException {
        String sql = "INSERT INTO sous_genre(genre_id, nom, description) VALUES (?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, genreId);
            ps.setString(2, nom);
            ps.setString(3, description);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    Genre g = new Genre(genreId, null);
                    return new SousGenre(id, nom, description, g);
                }
            }
        }
        return null;
    }

    public List<SousGenre> findAllByGenreId(long genreId) throws SQLException {
        String sql = "SELECT sg.id, sg.nom, sg.description, g.id as gid, g.nom as gnom " +
                "FROM sous_genre sg JOIN genre g ON sg.genre_id = g.id WHERE g.id = ? ORDER BY sg.nom";
        List<SousGenre> result = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, genreId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Genre g = new Genre(rs.getLong("gid"), rs.getString("gnom"));
                    SousGenre sg = new SousGenre(rs.getLong("id"), rs.getString("nom"), rs.getString("description"), g);
                    result.add(sg);
                }
            }
        }
        return result;
    }

    public List<SousGenre> findAll() throws SQLException {
        String sql = "SELECT sg.id, sg.nom, sg.description, g.id as gid, g.nom as gnom " +
                "FROM sous_genre sg JOIN genre g ON sg.genre_id = g.id ORDER BY g.nom, sg.nom";
        List<SousGenre> result = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Genre g = new Genre(rs.getLong("gid"), rs.getString("gnom"));
                SousGenre sg = new SousGenre(rs.getLong("id"), rs.getString("nom"), rs.getString("description"), g);
                result.add(sg);
            }
        }
        return result;
    }

    public SousGenre findById(long id) throws SQLException {
        String sql = "SELECT sg.id, sg.nom, sg.description, g.id as gid, g.nom as gnom " +
                "FROM sous_genre sg JOIN genre g ON sg.genre_id = g.id WHERE sg.id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Genre g = new Genre(rs.getLong("gid"), rs.getString("gnom"));
                    return new SousGenre(rs.getLong("id"), rs.getString("nom"), rs.getString("description"), g);
                }
            }
        }
        return null;
    }

    public boolean deleteById(long id) throws SQLException {
        String sql = "DELETE FROM sous_genre WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            int updated = ps.executeUpdate();
            return updated > 0;
        }
    }
} 