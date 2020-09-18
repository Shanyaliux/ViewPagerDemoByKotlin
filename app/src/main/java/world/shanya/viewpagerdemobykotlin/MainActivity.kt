package world.shanya.viewpagerdemobykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2.adapter = object :FragmentStateAdapter(this){
            override fun getItemCount() = 3

            override fun createFragment(position: Int) =
                    when (position) {
                        0 -> OneFragment()
                        1 -> TwoFragment()
                        else -> ThreeFragment()
                    }
        }

        TabLayoutMediator(tabLayout,viewPager2){tab, position ->
            when (position) {
                0 -> tab.text = "One"
                1 -> tab.text = "Two"
                else -> tab.text = "Three"
            }
        }.attach()
    }
}