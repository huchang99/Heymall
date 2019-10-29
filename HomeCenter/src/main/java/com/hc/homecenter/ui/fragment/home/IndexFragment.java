package com.hc.homecenter.ui.fragment.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridView;

import com.hc.baselibrary.ui.fragment.BaseMvpFragment;

import com.hc.homecenter.Contract.IndexContract;
import com.hc.homecenter.R;
import com.hc.homecenter.adapter.HomeGridViewAdapter;
import com.hc.homecenter.adapter.HomeRecycleViewAdapter;
import com.hc.homecenter.adapter.HomeViewPagerAdapter;
import com.hc.homecenter.model.CardData;
import com.hc.homecenter.model.GlideImageLoader;
import com.hc.homecenter.model.MenuBean;
import com.hc.homecenter.presenter.IndexPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class IndexFragment extends BaseMvpFragment<IndexContract.IndexPresenter> implements IndexContract.IndexView {

    //banner
    private Banner mBanner;
    //image
    private List<Integer> images;
    private List<String> titles;
    //String titles[] = {"标题1", "标题2", "标题3"};

    //menu
    private static int item_grid_num = 10;
    public static int number_columns = 5;//gridview一行展示的数目
    private ViewPager mViewPager;
    private HomeViewPagerAdapter mAdapter;
    private List<MenuBean> menuList;
    private List<GridView> menugridList;
    int pageSize;

    //recycleview
    private List<CardData> mCardDatas;
    private RecyclerView mRecyclerView;
    private HomeRecycleViewAdapter mHomeAdapter;


    @Override
    public void showError(String msg) {

    }

    @Override
    public Object setLayout() {
        return R.layout.index_fragment;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initData();
        initView(rootView);
    }


    public void initView(View view) {
        mBanner = view.findViewById(R.id.banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        //viewpager
        mViewPager = view.findViewById(R.id.view_pager);
        mAdapter = new HomeViewPagerAdapter(menugridList);
        //mViewPager.add(menugridList);
        mViewPager.setAdapter(mAdapter);

        //recycleview
        mRecyclerView = view.findViewById(R.id.home_recy);
        StaggeredGridLayoutManager mRecylayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mRecylayoutManager);
        mHomeAdapter = new HomeRecycleViewAdapter(getContext(),mCardDatas);
        mRecyclerView.setAdapter(mHomeAdapter);


    }


    public void initData() {
        //banner
        images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        titles = new ArrayList<>();
        titles.add("标题1");
        titles.add("标题2");
        titles.add("标题3");
        //menu
        menuList = new ArrayList<>();
        menugridList = new ArrayList<>();
        //初始化数据
        for (int i = 0; i < 30; i++) {
            MenuBean bean = new MenuBean();
            bean.name = "第" + (i + 1) + "条";
            menuList.add(bean);
        }
        //计算viewpager一共显示几页
        pageSize = menuList.size() % item_grid_num == 0
                ? menuList.size() / item_grid_num
                : menuList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(getActivity());
            HomeGridViewAdapter adapter = new HomeGridViewAdapter(getActivity(), menuList, i, item_grid_num);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter);
            menugridList.add(gridView);
        }

        //recycleview
        mCardDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            CardData data = new CardData();
            data.setImage(0);
            data.setText("123");
            mCardDatas.add(data);
        }


    }


    public void initListener() {

    }

    @Override
    public IndexContract.IndexPresenter createPresenter() {
        return new IndexPresenter();
    }
}
