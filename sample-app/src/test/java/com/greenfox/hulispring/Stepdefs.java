package com.greenfox.hulispring;


import com.sun.tools.javac.util.List;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import static org.junit.Assert.*;


public class Stepdefs {
    private String today;
    private String actualAnswer;
    private String path;

    @Autowired
    LocalFileSystemOperator localFileSystemOperator;

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        this.today = "Sunday";
    }

    @Given("^today is Friday")
    public void today_is_Friday() {
        this.today = "Friday";
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

   // -------------------------------------------


    @Given("^a directory, in the local filesystem, at path:(.*)$")
    public void a_directory_in_the_local_filesystem_at_path(String pathh) {
        LocalFileSystemOperator.createDirectrory(pathh);
        this.path = pathh;
    }

    @Given("^a file, in the local filesystem, at path:(.*)$")
    public void a_file_in_the_local_filesystem_at_path(String pathh) throws IOException {
        LocalFileSystemOperator.createFile(pathh);
        this.path = pathh;
    }

    @When("^a file is deleted at path: (.*), from the filesystem$")
    public void a_file_is_deleted_at_path_from_the_filesystem(String patth) throws IOException {
        LocalFileSystemOperator.deleteFile(patth);
    }


    @When("^a file, in the local filesystem, is moved from (.*) to (.*)$")
    public void a_file_in_the_local_filesystem_is_moved_at_path_containing(String pathFrom, String pathTo) {
        LocalFileSystemOperator.moveFile(pathFrom,pathTo);
    }

    @When("^a file, in the local filesystem, is copied from (.*) to (.*)$")
    public void a_file_in_the_local_filesystem_is_copied_at_path_containing(String pathFrom, String pathTo) throws IOException {
        LocalFileSystemOperator.copyFile(pathFrom,pathTo);
        LocalFileSystemOperator.deleteFile(pathFrom);

    }


    @When("^a directory, in the local filesystem, is moved from (.*) to (.*)$")
    public void a_directory_in_the_local_filesystem_is_moved_at_path(String pathFrom, String pathTo) {
        LocalFileSystemOperator.moveDirectory(pathFrom,pathTo);
        }

    @When("^a directory, in the local filesystem, is copied from (.*) to (.*)$")
    public void a_directory_in_the_local_filesystem_is_copied_at_path(String pathFrom, String pathTo) {
        LocalFileSystemOperator.copyDirectory(pathFrom,pathTo);
        LocalFileSystemOperator.deleteDirectory(pathFrom);
    }

    @When("^a directory is deleted at path: (.*), from the filesystem")
    public void a_directory_is_deleted_at_path_from_the_filesystem(String patth) {
    LocalFileSystemOperator.deleteDirectory(patth);
    }



    @When("^the file contains (.*)$")
    public void the_file_contains(String text) throws IOException {
        LocalFileSystemOperator.writeToFile(text,path);
    }

    @When("^the directory conatins:$")
    public void the_directory_conatins(List list) throws Throwable {
        for (int i = 0; i < list.size(); i++) {
            LocalFileSystemOperator.createFile(path+ "/" + list.get(i).toString());
        }
        throw new PendingException();
    }

    @Then("^there a file exists, in the local filesystem, at path: (.*), containing:(.*)$")
    public void there_is_a_file_in_the_local_filesystem_at_path_containing(String pathh, String expectedAnswer) throws IOException {
        path = pathh;
        actualAnswer = localFileSystemOperator.readFile(path);
        assertEquals(expectedAnswer, actualAnswer);
        LocalFileSystemOperator.deleteFile(path);
    }

    @Then("^there is a file, in the local filesystem, at path: (.*)$")
    public void there_is_a_file_in_the_local_filesystem_at_path(String pathh) throws IOException {
        boolean isFile = LocalFileSystemOperator.isFile(pathh);
        assertEquals(true,isFile);
        LocalFileSystemOperator.deleteFile(pathh);

    }



    @Then("^the directory at path: (.*) should contain these items:$")
    public void the_directory_at_path_should_contain_these_items(String pathh, List list) throws Throwable {
    java.awt.List list2 = LocalFileSystemOperator.listDirectory(pathh);
    assertEquals(list,list2);
        throw new PendingException();
    }


    @Then("^there is a directory, in the local filesystem, at path: (.*)$")
    public void there_is_a_directory_in_the_local_filesystem_at_path(String expectedAnswer) {
        boolean isDir = LocalFileSystemOperator.isDirectory(expectedAnswer);
        assertEquals(true,isDir);
        LocalFileSystemOperator.deleteDirectory(expectedAnswer);
    }



    @Then("^there is no directory, in the local filesystem, at path: (.*)$")
    public void there_is_no_directory_in_the_local_filesystem_at_path(String expectedAnswer) {
        boolean isDir = LocalFileSystemOperator.isDirectory(expectedAnswer);
        assertEquals(false,isDir);
        LocalFileSystemOperator.deleteDirectory(expectedAnswer);
    }

    @Then("^there is no file, in the local filesystem, at path: (.*)$")
    public void there_is_no_file_in_the_local_filesystem_at_path(String expectedAnswer) {
        boolean isFile = LocalFileSystemOperator.isFile(expectedAnswer);
        try {
            LocalFileSystemOperator.deleteFile(expectedAnswer);
        } catch (IOException e) {
            assertEquals(false,isFile);
        }
    }
}
