package com.example.myapplication.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

internal fun AppCompatActivity.replaceFragment(
    @IdRes containerId: Int, fragment: BaseFragment, isAddBackStack: Boolean = false,
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    if (supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = supportFragmentManager.beginTransaction()
        t.invoke(transaction)
        transaction.replace(containerId, fragment, fragment.javaClass.simpleName)
        if (isAddBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commitAllowingStateLoss()
    }
}

internal fun AppCompatActivity.addFragment(
    @IdRes containerId: Int, fragment: BaseFragment, addBackStackString: String? = "",
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    if (supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = supportFragmentManager.beginTransaction()
        t.invoke(transaction)
        transaction.add(containerId, fragment, fragment.javaClass.simpleName)
        if (addBackStackString != null) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commitAllowingStateLoss()
        supportFragmentManager.executePendingTransactions()
    }
}