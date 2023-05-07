package com.castro.helena.app.appgallery.helena.common;

public abstract class Resource<T> {

    T data;
    String message;

    public Resource() {
    }

    public Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    static class Success<T> extends Resource<T> {
        T data;
    }

    static class Error<T> extends Resource<T> {
        T data;
        String message;
    }

    static class Loading<T> extends Resource<T> {
        T data;
    }

}
