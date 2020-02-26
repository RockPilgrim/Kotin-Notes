package my.rockpilgrim.chucknorriskotlin.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import my.rockpilgrim.chucknorriskotlin.JokeFragment
import my.rockpilgrim.chucknorriskotlin.WebFragment

const val JOKES_FRAGMENT = 0
const val WEB_FRAGMENT = 1

class JokePagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    private val fragmentsCreator:Map<Int,() ->Fragment> = mapOf(
        JOKES_FRAGMENT to {JokeFragment()},
        WEB_FRAGMENT to { WebFragment()}
    )

    override fun getItemCount(): Int = fragmentsCreator.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}