package deps

import androidx.lifecycle.ViewModel

/**
 * This is Shared Dependency
 * @property myRepo MyRepo
 * @constructor
 */
class MyViewModel(private val myRepo: MyRepo) : ViewModel() {

    fun getHelloFromDb() = myRepo.getHello()
}