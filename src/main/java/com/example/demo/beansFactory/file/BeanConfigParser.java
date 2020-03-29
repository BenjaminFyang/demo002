package com.example.demo.beansFactory.file;

import java.io.InputStream;
import java.util.List;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */

public interface BeanConfigParser {

    List parse(InputStream inputStream);

    List parse(String configContent);
}
