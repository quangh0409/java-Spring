package com.example.Java_Spring.helper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Error {

        NOT_FOUND(404,"Không tìm thấy"),
        UNAUTHORIZED(401,"Không được cấp quyền"),
        INVALID_INPUT_PARAMS(400,"Thiếu dữ liệu đầu vào");
        private int code;
        private String message;

}
/*
update priduct set display = .., price= ..., where id = abc

Sql = `update product st id = 'id'`
conditionSql = `where id = abc `
if(productDto != null){
}

 */
