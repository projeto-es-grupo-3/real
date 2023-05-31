package com.example.classroom.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HomeControllerTest {

    @Test
    void testGetHome() {
        assertEquals("home", (new HomeController()).getHome());
    }
}

