package org.example.ch4.config;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingResourceIT extends GreetingResourceTest {

    // Execute the same tests but in native mode.
}