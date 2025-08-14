package com.example.bibliotheque.ws.dao;

import com.example.bibliotheque.ws.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {

    public Genre create(String nom) throws SQLException {
        String sql = "INSERT INTO genre(nom) VALUES (?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nom);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    return new Genre(id, nom);
                }
            }
        }
        return null;
    }

    public List<Genre> findAll() throws SQLException {
        String sql = "SELECT id, nom FROM genre ORDER BY nom";
        List<Genre> result = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Genre(rs.getLong("id"), rs.getString("nom")));
            }
        }
        return result;
    }

    public Genre findById(long id) throws SQLException {
        String sql = "SELECT id, nom FROM genre WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Genre(rs.getLong("id"), rs.getString("nom"));
                }
            }
        }
        return null;
    }

    public boolean deleteById(long id) throws SQLException {
        String sql = "DELETE FROM genre WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            int updated = ps.executeUpdate();
            return updated > 0;
        }
    }
} 