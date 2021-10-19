package com.app.shaadi.db;

import java.util.concurrent.Callable;

public class DbExecutor<T> implements Callable<T> {

    private T value;

    @Override
    public T call() throws Exception {
        return null;
    }
}
