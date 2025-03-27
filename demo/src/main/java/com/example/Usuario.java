package com.example;

public class Usuario {
    private String credenciales;
    private static final String SEPARADOR = ";";

    private Usuario(String username, String password) {
        this.credenciales = username + SEPARADOR + password;
    }

    public String getCredenciales() {
        return credenciales;
    }

    public boolean login(String usuarioLogin, String passwordLogin) {
        // TO DO
        // No esta permitido realizar ninguna operacion con los parametros salvo equals.
        return this.credenciales.equals(usuarioLogin + SEPARADOR + passwordLogin);
    }

    public static Usuario registrar(String username, String password) {
        // TO DO
        username = username.toLowerCase();
        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username, password);
        }
        System.out.println("Registro fallido.\n");
        return null;
    }

    public static boolean validarUsuario(String username) {
        // TO DO
        if (username.contains(" ") || username.contains(SEPARADOR)) {
            return false;
        }
        if (!username.equals("administrador") && username.charAt(0) != '_') {
            return false;
        }
        if (username.equals("_administrador")) {
            return false;
        }
        return true;
    }

    public static boolean validarPassword(String username, String password) {
        // TO DO
        if (password.contains(" ") || password.contains(SEPARADOR)) {
            return false;
        }
        if (username.equals("administrador") && password.equals("admin")) {
            return false;
        }
        if (password.length() < 4) {
            return false;
        }
        if (username.equalsIgnoreCase(password)) {
            return false;
        }
        return true;
    }

}
