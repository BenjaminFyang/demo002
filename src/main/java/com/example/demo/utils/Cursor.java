package com.example.demo.utils;

import lombok.Data;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-20
 * @since 1.0.0
 */

@Data
class Cursor {

    private int offset;

    void inc(int by) {
        offset += by;
    }
}
