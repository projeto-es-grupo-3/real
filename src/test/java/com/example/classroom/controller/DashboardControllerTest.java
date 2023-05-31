package com.example.classroom.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DashboardControllerTest {
    @Test
    void testGetDashboard() {
        assertEquals("dashboard/dashboard", (new DashboardController()).getDashboard());
    }

    @Test
    void testGetLibrary() {
       assertEquals("dashboard/library", (new DashboardController()).getLibrary());
    }

    @Test
    void testGetCalendar() {
        assertEquals("dashboard/calendar", (new DashboardController()).getCalendar());
    }

    @Test
    void testGetAnalytics() {
        assertEquals("dashboard/analytics", (new DashboardController()).getAnalytics());
    }

    @Test
    void testGetSales() {
        assertEquals("dashboard/sales", (new DashboardController()).getSales());
    }

    @Test
    void testGetSettings() {
        assertEquals("dashboard/settings", (new DashboardController()).getSettings());
    }

    @Test
    void testGetHelp() {
        assertEquals("dashboard/help", (new DashboardController()).getHelp());
    }

}

