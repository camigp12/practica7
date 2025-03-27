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
        return this.credenciales.equals(usuarioLogin + SEPARADOR + passwordLogin);
    }

    public static Usuario registrar(String username, String password) {
        if (validarUsuario(username) && validarPassword(username, password)) {
            System.out.println("Registro exitoso.\n");
            return new Usuario(username, password);
        }
        System.out.println("Registro fallido.\n");
        return null;
    }

    public static boolean validarUsuario(String username) {
        // TODO
        if (username.contains(" ") || username.contains(SEPARADOR)) {
            return false;
        }
        if (!username.equals("administrador") && !username.startsWith("_")) {
            return false;
        }
        return true;
    }

    public static boolean validarPassword(String username, String password) {
        // TODO
        if (password.contains(" ") || password.contains(SEPARADOR)) {
            return false;
        }
        if (password.length() < 4) {
            return false;
        }
        if (username.equalsIgnoreCase(password)) {
            return false;
        }
        if (username.equals("administrador") && password.equals("admin")) {
            return false;
        }
        return true;
    }

}
