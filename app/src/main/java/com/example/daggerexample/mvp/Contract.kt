package com.example.daggerexample.mvp

interface Contract {


    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(string: String?)
    }

    interface Model {

        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

        fun getNextCourse(onFinishedListener: Model.OnFinishedListener)
    }

    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }

}