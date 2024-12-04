package com.frameium.stepdef.DataGeneration;

import com.frameium.utilities.pdfutils.Datagenerationform;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Datagenerationtest {



    @Given("User need random numbers")
    public void userNeedRandomNumbers() {
        String phonenumber = Datagenerationform.PhonenumberGenerator();
        System.out.println("generated numbers are : " + phonenumber);

        Assert.assertTrue(phonenumber.startsWith("+91"), "phone number doesn't starts with indian Country code");
    }
@Test
    public void randomalphabet()throws InterruptedException{
        String names = Datagenerationform.RandomnameGenerator();
        System.out.println("generated names are : " + names);
    }
}

