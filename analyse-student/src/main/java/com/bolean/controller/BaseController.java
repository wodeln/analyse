package com.bolean.controller;

import org.springframework.beans.factory.annotation.Value;

public class BaseController {
    @Value("${itemsPerPage}")
    public Integer itemsPerPage;
}
