package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xinrunfeng
 * @description:
 */
@Data
public class User implements Serializable {

    private String username;

    private LocalDateTime dateTime;
}
