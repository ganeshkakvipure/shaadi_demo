package com.app.shaadi.network.livedata;

import static com.app.shaadi.network.livedata.Status.ERROR;
import static com.app.shaadi.network.livedata.Status.LOADING;
import static com.app.shaadi.network.livedata.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    private final AppException exception;

    @Nullable
    public final T data;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable AppException exception) {
        this.status = status;
        this.data = data;
        this.exception = exception;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(AppException exception, @Nullable T data) {
        return new Resource<>(ERROR, data, exception);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    @Nullable
    public AppException getException() {
        return exception;
    }

    @Nullable
    public T getData() {
        return data;
    }


}
