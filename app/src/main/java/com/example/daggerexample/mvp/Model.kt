package com.example.daggerexample.mvp

import android.os.Handler
import java.util.Random

class Model : Contract.Model {

    var arrayList: List<String> = listOf(
        "DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
        "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments ",
        "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for \" +\n" +
                "                    \"product based against like Amazon, Microsoft, etc.",
        "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. \" +\n" +
                "                    \"Get placement ready before the interviews begin",
        "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for \" +\n" +
                "                    \"SDE 1 Interviews in top companies"
    )

    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener) {
        Handler().postDelayed(Runnable { onFinishedListener.onFinished(getRandomString()) }, 1200)
    }

    fun getRandomString(): String {
        var random = Random()
        var index = random.nextInt(arrayList.size)
        return arrayList[index]
    }
}