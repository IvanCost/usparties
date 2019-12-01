package com.olu.uspparties.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.olu.uspparties.fragments.cardsTips.CardOne;
import com.olu.uspparties.fragments.cardsTips.CardThree;
import com.olu.uspparties.fragments.cardsTips.CardTwo;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        for (Fragment fragment : childFragments = new Fragment[]{
                new CardOne(), //0
                new CardTwo(), //1
                new CardThree() //2
        }) {

        }

    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length; //3 items
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }
}