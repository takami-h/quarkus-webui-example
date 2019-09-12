package com.natswell.examples.quarkus;

import io.quarkus.test.junit.SubstrateTest;

@SubstrateTest
public class NativeGreetingResourceIT extends GreetingResourceTest {

    // Execute the same tests but in native mode.
}