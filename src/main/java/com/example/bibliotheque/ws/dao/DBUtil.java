package com.example.bibliotheque.ws.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBUtil {
    private static final Properties PROPS = new Properties();
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new IllegalStateException("db.properties introuvable dans le classpath");
            }
            PROPS.load(in);
            String host = PROPS.getProperty("db.host", "localhost");
            String port = PROPS.getProperty("db.port", "3306");
            String database = PROPS.getProperty("db.name", "bibliotheque");
            user = PROPS.getProperty("db.user", "root");
            password = PROPS.getProperty("db.password", "");
            String params = PROPS.getProperty("db.params", "useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
            url = "jdbc:mariadb://" + host + ":" + port + "/" + database + "?" + params;
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
} 