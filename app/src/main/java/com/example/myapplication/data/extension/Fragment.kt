package com.example.myapplication.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

internal fun Fragment.addChildFragment(
    @IdRes containerId: Int, fragment: BaseFragment, backStack: String? = "",
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    if (childFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = childFragmentManager.beginTransaction()
        t.invoke(transaction)
        transaction.add(containerId, fragment, fragment.javaClass.simpleName)
        if (backStack != null) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commitAllowingStateLoss()
        childFragmentManager.executePendingTransactions()
    }
}

internal fun Fragment.addFragment(
    @IdRes containerId: Int, fragment: BaseFragment, addBackStackString: String? = "",
    t: (transaction: FragmentTransaction) -> Unit = {}
) {
    if (fragmentManager?.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = fragmentManager?.beginTransaction()
        if (transaction != null) {
            t.invoke(transaction)
        }
        transaction?.add(containerId, fragment, fragment.javaClass.simpleName)
        if (addBackStackString != null) {
            transaction?.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction?.commitAllowingStateLoss()
        fragmentManager?.executePendingTransactions()
    }
}