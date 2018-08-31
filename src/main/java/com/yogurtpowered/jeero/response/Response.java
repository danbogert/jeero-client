package com.yogurtpowered.jeero.response;

import com.yogurtpowered.jeero.response.fields.Data;
import com.yogurtpowered.jeero.response.fields.Meta;

public abstract class Response<D extends Data> {

    private final Meta meta;
    protected final D data;

    public Response(Meta meta, D data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public D getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "\nmeta=" + meta +
                "\ndata=" + data +
                '}';
    }
}
