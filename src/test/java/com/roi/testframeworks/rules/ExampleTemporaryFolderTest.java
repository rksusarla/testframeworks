package com.roi.testframeworks.rules;

import java.io.File;
import java.io.IOException;

import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class ExampleTemporaryFolderTest {
	
	@Rule
	public TemporaryFolder folder= new TemporaryFolder();

	@BeforeClass
	public static void classSetup() {

	}

	@AfterClass
	public static void classCleanup() {

	}


	@Before
	public void setup() {

	}

	@After
	public void cleanup() {

	}

	boolean sharedState = false;
	@Test
	public void testUsingTempFolder() throws IOException {
	   File createdFile= folder.newFile("tmpfile.txt");
	   File createdFolder= folder.newFolder("tmpfolder");
	   sharedState = true;
	   System.out.printf("Created temp folder location is %s %n", createdFolder.getAbsolutePath());
	}

	@Test
	public void test2() {
		assertTrue(sharedState);
	}
}
