package com.midasit.challenge.web.util.format;

import lombok.Data;

@Data
public class ResponseFormat<T> {
    /*
    code : CMD enum 값 넣어야함.
     */
    int code;

    /*
    description : success 혹은 error 넣어야함.
     */
    String description;

    /*
    last_idx : insert 등등 idx 값을 넣어줘야함.
     */
    int last_idx;

    /*
    list : 제네릭으로써 db 레코드 값을 넣어야함.
     */
    T list;

    public void fail(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public ResponseFormat() {
        this.code = 0;
        this.description = "success";
        this.last_idx = -1;
        this.list = null;
    }

    public ResponseFormat(T list) {
        this();
        this.list = list;
    }
}
