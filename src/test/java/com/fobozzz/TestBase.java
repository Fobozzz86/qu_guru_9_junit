package com.fobozzz;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
        @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.google.com/";
        Configuration.holdBrowserOpen = true;
  //      Configuration.browser = "Edge";
        Configuration.browserSize = "1200x768";

      //  Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 45000; // таймаут на загрузку страници
    }
}
