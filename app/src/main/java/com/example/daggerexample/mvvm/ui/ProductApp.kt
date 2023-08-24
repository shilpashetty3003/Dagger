package com.example.daggerexample.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.daggerexample.R
import com.example.daggerexample.mvvm.ProductApplication
import com.example.daggerexample.mvvm.data.ProductRepository
import javax.inject.Inject

class ProductApp : AppCompatActivity() {
    private val TAG = "ProductApp"

    lateinit var productViewModel: ProductViewModel

    @Inject
    lateinit var repository: ProductRepository
    lateinit var viewModelFactory: ProductVMFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_app)
        (application as ProductApplication).productComponent.inject(this)
        viewModelFactory = ProductVMFactory(repository)
        productViewModel =
            ViewModelProvider(this, viewModelFactory).get(ProductViewModel::class.java)

        val superUsersList: MutableList<in SuperVehicle> = mutableListOf(Cycle())

        genericsExample<String>("Hello")
        genericsExample<Int>(677)

        productViewModel.productsItems.observe(this) {
            Log.d("TAG", "onCreate:  $it")

        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }

    override fun onResume() {

        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    val sealedList: List<Resouce<List<String>>> = listOf(Success<List<*>>())

    inline fun <reified T> genericsExample(value: T) {
        println(value)
        Log.d("TAG", "genericsExample: ${T::class.java} ")
    }
}


open class SuperVehicle
open class Vehicle : SuperVehicle()
class Bike : Vehicle()
class Cycle : Vehicle()

sealed class Resouce<in T>
class Success<T> : Resouce<T>()
object Failure : Resouce<Nothing>()


